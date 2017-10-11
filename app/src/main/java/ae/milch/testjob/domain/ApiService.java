package ae.milch.testjob.domain;

import ae.milch.testjob.models.CommentModelResponse;
import ae.milch.testjob.models.PhotoModelResponse;
import ae.milch.testjob.models.PostModelResponse;
import ae.milch.testjob.models.TodosModelResponse;
import ae.milch.testjob.models.usermodel.UserModelResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts/{id}")
    Observable<PostModelResponse> getPostById(@Path("id") String id);

    @GET("/comments/{id}")
    Observable<CommentModelResponse> getCommentById(@Path("id") String id);

    @GET("/users/{id}")
    Observable<UserModelResponse> getUserById(@Path("id") int id);

    @GET("/photos/{id}")
    Observable<PhotoModelResponse> getPhotoById(@Path("id") int id);

    @GET("/todos/{id}")
    Observable<TodosModelResponse> getTodosRandom(@Path("id") String id);
}
