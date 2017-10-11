package ae.milch.testjob;

import ae.milch.testjob.models.ModelCommentResponse;
import ae.milch.testjob.models.ModelPostResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {

    private final MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void loadPost(String id) {
        ApiService apiService = new NetworkModule().createService();
        apiService.getPostById(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelPostResponse>() {
                               @Override
                               public void accept(ModelPostResponse modelPostResponse) throws Exception {
                                   view.outputPostData(modelPostResponse);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
    }

    public void loadComment(String id) {
        ApiService apiService = new NetworkModule().createService();
        apiService.getCommentById(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelCommentResponse>() {
                               @Override
                               public void accept(ModelCommentResponse modelCommentResponse) throws Exception {
                                   view.outputCommentData(modelCommentResponse);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
    }
}
