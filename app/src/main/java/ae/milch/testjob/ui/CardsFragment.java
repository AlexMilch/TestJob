package ae.milch.testjob.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ae.milch.testjob.InputFilterMinMax;
import ae.milch.testjob.R;
import ae.milch.testjob.models.CommentModelResponse;
import ae.milch.testjob.models.PhotoModelResponse;
import ae.milch.testjob.models.PostModelResponse;
import ae.milch.testjob.models.TodosModelResponse;
import ae.milch.testjob.models.usermodel.UserModelResponse;

public class CardsFragment extends Fragment implements MainActivityView {

    private EditText etPost;
    private Button btnLoadPost;
    private TextView tvTitlePost;
    private TextView tvBodyPost;

    private EditText etComment;
    private Button btnLoadComment;
    private TextView tvNameComment;
    private TextView tvEmailComment;
    private TextView tvBodyComment;

    private SimpleDraweeView ivPhoto;

    private TextView tvTitleTodos;
    private TextView tvCompletedTodos;

    private MainActivityPresenter presenter = new MainActivityPresenter(this);

    private LinearLayout llUserContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards, container, false);
        etPost = view.findViewById(R.id.et_post);
        btnLoadPost = view.findViewById(R.id.btn_load_post);
        tvTitlePost = view.findViewById(R.id.tv_title_post);
        tvBodyPost = view.findViewById(R.id.tv_body_post);

        etComment = view.findViewById(R.id.et_comment);
        btnLoadComment = view.findViewById(R.id.btn_load_comment);
        tvNameComment = view.findViewById(R.id.tv_name_comment);
        tvEmailComment = view.findViewById(R.id.tv_email_comment);
        tvBodyComment = view.findViewById(R.id.tv_body_comment);

        llUserContainer = view.findViewById(R.id.ll_user_container);

        ivPhoto = view.findViewById(R.id.iv_photo);

        tvTitleTodos = view.findViewById(R.id.tv_title_todos);
        tvCompletedTodos = view.findViewById(R.id.tv_completed_todos);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        etPost.setFilters(new InputFilter[]{new InputFilterMinMax(1, 100, "Введите id поста от 1 до 100", getContext())});
        etComment.setFilters(new InputFilter[]{new InputFilterMinMax(1, 500, "Введите id комментария от 1 до 500", getContext())});

        loadPost(etPost.getText().toString());
        loadComment(etComment.getText().toString());
        loadUser();
        loadPhoto();
        loadTodos();

        btnLoadPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPost(etPost.getText().toString());
            }
        });
        btnLoadComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadComment(etComment.getText().toString());
            }
        });
    }

    private void loadComment(String id) {
        presenter.loadComment(id);
    }

    public void loadPost(String id) {
        presenter.loadPost(id);
    }

    private void loadUser() {
        presenter.loadUser();
    }

    private void loadPhoto() {
        presenter.loadPhoto(3);
    }

    private void loadTodos() {
        presenter.loadTodos();
    }

    @Override
    public void outputPostData(PostModelResponse post) {
        tvTitlePost.setText(post.getTitle());
        tvBodyPost.setText(post.getBody());
    }

    @Override
    public void outputCommentData(CommentModelResponse comment) {
        tvNameComment.setText(comment.getName());
        tvEmailComment.setText(comment.getEmail());
        tvBodyComment.setText(comment.getBody());
    }

    @Override
    public void outputUserData(List<UserModelResponse> userList) {
        for (int i = 0; i < 5; i++) {
            UserView userView = llUserContainer.findViewWithTag(String.valueOf(i + 1));
            userView.setup(userList.get(i), i);
        }
    }

    @Override
    public void outputPhoto(PhotoModelResponse photoModelResponse) {
        ivPhoto.setImageURI(Uri.parse(photoModelResponse.getUrl()));
    }

    @Override
    public void outputTodos(TodosModelResponse todos) {
        tvTitleTodos.setText(todos.getTitle());
        tvCompletedTodos.setText(todos.getCompleted());
    }
}
