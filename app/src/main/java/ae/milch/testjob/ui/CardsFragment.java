package ae.milch.testjob.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import ae.milch.testjob.R;
import ae.milch.testjob.models.CommentModelResponse;
import ae.milch.testjob.models.PhotoModelResponse;
import ae.milch.testjob.models.PostModelResponse;
import ae.milch.testjob.models.TodosModelResponse;
import ae.milch.testjob.models.usermodel.UserModelResponse;

public class CardsFragment extends Fragment implements MainActivityView {

    EditText etPost;
    Button btnLoadPost;
    TextView tvTitlePost;
    TextView tvBodyPost;

    EditText etComment;
    Button btnLoadComment;
    TextView tvNameComment;
    TextView tvEmailComment;
    TextView tvBodyComment;

    TextView tvNameUser1;
    TextView tvNameUser2;
    TextView tvNameUser3;
    TextView tvNameUser4;
    TextView tvNameUser5;

    SimpleDraweeView ivPhoto;

    TextView tvTitleTodos;
    TextView tvCompletedTodos;

    MainActivityPresenter presenter = new MainActivityPresenter(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards, container, false);
        etPost = view.findViewById(R.id.etPost);
        btnLoadPost = view.findViewById(R.id.btnLoadPost);
        tvTitlePost = view.findViewById(R.id.tvTitlePost);
        tvBodyPost = view.findViewById(R.id.tvBodyPost);

        etComment = view.findViewById(R.id.etComment);
        btnLoadComment = view.findViewById(R.id.btnLoadComment);
        tvNameComment = view.findViewById(R.id.tvNameComment);
        tvEmailComment = view.findViewById(R.id.tvEmailComment);
        tvBodyComment = view.findViewById(R.id.tvBodyComment);

        tvNameUser1 = view.findViewById(R.id.tvNameUser1);
        tvNameUser2 = view.findViewById(R.id.tvNameUser2);
        tvNameUser3 = view.findViewById(R.id.tvNameUser3);
        tvNameUser4 = view.findViewById(R.id.tvNameUser4);
        tvNameUser5 = view.findViewById(R.id.tvNameUser5);

        ivPhoto = view.findViewById(R.id.ivPhoto);

        tvTitleTodos = view.findViewById(R.id.tvTitleTodos);
        tvCompletedTodos = view.findViewById(R.id.tvCompletedTodos);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        presenter.loadUser(1);
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
    public void outputUserData(UserModelResponse user) {
        tvNameUser1.setText(user.getName());
        tvNameUser2.setText(user.getName());
        tvNameUser3.setText(user.getName());
        tvNameUser4.setText(user.getName());
        tvNameUser5.setText(user.getName());
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
