package excel.tutorial.familytree.view.activity.Home;

import excel.tutorial.familytree.service.TutorialAppApi;

public class HomeModelImpl implements HomeModel {

    private TutorialAppApi ApiService;

    public HomeModelImpl() {
        ApiService = TutorialAppApi.Factory.create();
    }

//    @Override
//    public void getMapTreeFamily() {
//        Call<UserResponse> call = ApiService.getUser();
//        call.enqueue(new Callback<UserResponse>() {
//            @Override
//            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                UserResponse userResponse = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<UserResponse> call, Throwable t) {
//                Log.e("TAG", t.getMessage());
//            }
//        });
//    }

    @Override
    public void getMapTreeFamily() {
    }
}
