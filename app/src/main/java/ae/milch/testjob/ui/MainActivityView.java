package ae.milch.testjob.ui;

import java.util.List;

import ae.milch.testjob.models.CommentModelResponse;
import ae.milch.testjob.models.PhotoModelResponse;
import ae.milch.testjob.models.PostModelResponse;
import ae.milch.testjob.models.TodosModelResponse;
import ae.milch.testjob.models.usermodel.UserModelResponse;

public interface MainActivityView {
    void outputPostData(PostModelResponse post);

    void outputCommentData(CommentModelResponse comment);

    void outputUserData(List<UserModelResponse> userList);

    void outputPhoto(PhotoModelResponse photoModelResponse);

    void outputTodos(TodosModelResponse todosModelResponse);
}
