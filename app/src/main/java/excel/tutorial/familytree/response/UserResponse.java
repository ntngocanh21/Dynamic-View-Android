package excel.tutorial.familytree.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class UserResponse {

    @SerializedName("message")
    @Expose
    private Error error;

    @SerializedName("users")
    @Expose
    private ArrayList<UserData> userData;

    public Error getError() {
        return error;
    }

    public ArrayList<UserData> getUserData() {
        return userData;
    }
}
