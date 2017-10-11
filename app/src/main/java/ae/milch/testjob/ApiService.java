package ae.milch.testjob;

import ae.milch.testjob.models.ModelCommentResponse;
import ae.milch.testjob.models.ModelPostResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts/{id}")
    Observable<ModelPostResponse> getPostById(@Path("id") String id);

    @GET("/comments/{id}")
    Observable<ModelCommentResponse> getCommentById(@Path("id") String id);
}
