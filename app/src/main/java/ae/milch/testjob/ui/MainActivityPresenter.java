package ae.milch.testjob.ui;

import java.util.Random;

import ae.milch.testjob.domain.ApiService;
import ae.milch.testjob.domain.NetworkModule;
import ae.milch.testjob.models.CommentModelResponse;
import ae.milch.testjob.models.PhotoModelResponse;
import ae.milch.testjob.models.PostModelResponse;
import ae.milch.testjob.models.TodosModelResponse;
import ae.milch.testjob.models.usermodel.UserModelResponse;
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
                .subscribe(new Consumer<PostModelResponse>() {
                               @Override
                               public void accept(PostModelResponse postModelResponse) throws Exception {
                                   view.outputPostData(postModelResponse);
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
                .subscribe(new Consumer<CommentModelResponse>() {
                               @Override
                               public void accept(CommentModelResponse commentModelResponse) throws Exception {
                                   view.outputCommentData(commentModelResponse);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
    }

    public void loadUser(int id) {
        ApiService apiService = new NetworkModule().createService();
        apiService.getUserById(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserModelResponse>() {
                               @Override
                               public void accept(UserModelResponse userModelResponse) throws Exception {
                                   view.outputUserData(userModelResponse);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
    }

    public void loadPhoto(int id) {
        ApiService apiService = new NetworkModule().createService();
        apiService.getPhotoById(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhotoModelResponse>() {
                               @Override
                               public void accept(PhotoModelResponse photoModelResponse) throws Exception {
                                   view.outputPhoto(photoModelResponse);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });
    }

    public void loadTodos() {
        ApiService apiService = new NetworkModule().createService();
        Random random = new Random();
        apiService.getTodosRandom(String.valueOf(random.nextInt(200)))
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TodosModelResponse>() {
                               @Override
                               public void accept(TodosModelResponse todosModelResponse) throws Exception {
                                   view.outputTodos(todosModelResponse);
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
