package excel.tutorial.familytree.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("description")
    @Expose
    private String description;

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
