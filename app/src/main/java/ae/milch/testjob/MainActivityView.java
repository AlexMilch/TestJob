package ae.milch.testjob;

import ae.milch.testjob.models.ModelCommentResponse;
import ae.milch.testjob.models.ModelPostResponse;

public interface MainActivityView {
    void outputPostData(ModelPostResponse post);

    void outputCommentData(ModelCommentResponse comment);
}
