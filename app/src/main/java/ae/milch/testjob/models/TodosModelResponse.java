package ae.milch.testjob.models;

import com.google.gson.annotations.SerializedName;

public class TodosModelResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("completed")
    private String completed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
