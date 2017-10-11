package ae.milch.testjob;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ae.milch.testjob.models.ModelCommentResponse;
import ae.milch.testjob.models.ModelPostResponse;

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

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

    @Override
    public void outputPostData(ModelPostResponse post) {
        tvTitlePost.setText(post.getTitle());
        tvBodyPost.setText(post.getBody());
    }

    @Override
    public void outputCommentData(ModelCommentResponse comment) {
        tvNameComment.setText(comment.getName());
        tvEmailComment.setText(comment.getEmail());
        tvBodyComment.setText(comment.getBody());
    }
}
