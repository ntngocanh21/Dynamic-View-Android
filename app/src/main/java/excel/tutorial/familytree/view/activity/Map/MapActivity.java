package excel.tutorial.familytree.view.activity.Map;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.app.Application;
import excel.tutorial.familytree.custom.DrawView;
import excel.tutorial.familytree.custom.ZoomLinearLayout;
import excel.tutorial.familytree.di.module.MapModule;
import excel.tutorial.familytree.response.UserData;
import excel.tutorial.familytree.utilities.Constants;
import excel.tutorial.familytree.view.activity.BaseActivity;
import excel.tutorial.familytree.view.fragment.map.FragmentNode;

public class MapActivity extends BaseActivity implements MapView {

    @Inject
    Context mContext;

    @Inject
    MapActivity mActivity;


    @Inject
    FragmentNode mFragmentNode;

    private DrawView drawView;
    private Node currentNode;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance().getAppComponent().plus(new MapModule(this, this)).inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_map;
    }

    @Override
    protected void initViews() {
        mFragmentNode.setParentFragment(mContext, this);
        final ZoomLinearLayout zoomLinearLayout = findViewById(R.id.zoomLayout);
        zoomLinearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                zoomLinearLayout.init(MapActivity.this);
                return false;
            }
        });

        mFragmentNode.attachEventInterface(new FragmentNode.InterfaceRecipeFragment() {
            @Override
            public void addRecipe(Object recipe) {
                // TODO
            }
        });
        UserData userData1 = new UserData();
        userData1.setName("Van Co");

        UserData userData2 = new UserData();
        userData2.setName("Ngoc Ha");

        UserData userData3 = new UserData();
        userData3.setName("Ngoc Anh");

        GraphView graphView = findViewById(R.id.graph);

        // example tree
        final Graph graph = new Graph();
        final Node node1 = new Node(userData1);
        final Node node2 = new Node(userData2);
        final Node node3 = new Node(userData3);


        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);

        // you can set the graph via the constructor or use the adapter.setGraph(Graph) method
        final BaseGraphAdapter<ViewHolder> adapter = new BaseGraphAdapter<ViewHolder>(this, R.layout.node, graph) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(View view) {
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Object data, int position) {
                viewHolder.mTextView.setText(((UserData) data).getName());
            }
        };
        graphView.setAdapter(adapter);

        graphView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentNode = adapter.getNode(position);
                UserData userData = new UserData();
                userData.setName("c of " + ((UserData) currentNode.getData()).getName());
                Node newNode = new Node(userData);
                graph.addEdge(currentNode, newNode);
            }
        });

        // set the algorithm here
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(100)
                .setLevelSeparation(300)
                .setSubtreeSeparation(300)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
                .build();
        adapter.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
    }


    @Override
    public void showDialogNode() {
        mFragmentNode.show(mActivity.getFragmentManager(), Constants.TAG_NODE);
    }
}