package excel.tutorial.familytree.view.fragment.map;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import excel.tutorial.familytree.R;
import excel.tutorial.familytree.view.activity.Map.MapActivity;

public class FragmentNode extends DialogFragment {

    private MapActivity mActivity;
    private Context mContext;

    @Inject
    public FragmentNode() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_node, container);
        setCancelable(false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        resetView();
        super.onResume();
    }

    private void resetView() {
    }

    public void setParentFragment(Context context, MapActivity activity) {
        mActivity = activity;
        mContext = context;
    }

    private InterfaceRecipeFragment mInterfaceRecipeFragment;

    public interface InterfaceRecipeFragment {
        void addRecipe(Object recipe);
    }

    public void attachEventInterface(InterfaceRecipeFragment interfaceRecipeFragment) {
        mInterfaceRecipeFragment = interfaceRecipeFragment;
    }

    @OnClick({R.id.btnNewNode, R.id.btnClose})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClose:
                this.dismiss();
                break;
        }
    }
}
