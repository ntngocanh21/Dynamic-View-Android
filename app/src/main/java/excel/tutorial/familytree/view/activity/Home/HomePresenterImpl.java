package excel.tutorial.familytree.view.activity.Home;

public class HomePresenterImpl implements HomePresenter {

    private HomeView mHomeView;
    private HomeModel mHomeModel;

    public HomePresenterImpl(HomeView homeView) {
        mHomeView = homeView;
        mHomeModel = new HomeModelImpl();
    }


    @Override
    public void getMapTreeFamily() {
        mHomeModel.getMapTreeFamily();
    }
}
