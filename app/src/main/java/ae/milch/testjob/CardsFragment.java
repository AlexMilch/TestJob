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

import ae.milch.testjob.models.ModelPostResponse;

public class CardsFragment extends Fragment implements PostView{

    Button btnLoadPost;
    TextView tvTitlePost;
    TextView tvBodyPost;
    EditText etPost;
    MainActivityPresenter presenter = new MainActivityPresenter(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cards, container, false);
        btnLoadPost = (Button) view.findViewById(R.id.btnPost);
        tvTitlePost = (TextView) view.findViewById(R.id.tvTitlePost);
        tvBodyPost= (TextView) view.findViewById(R.id.tvBodyPost);
        etPost= (EditText) view.findViewById(R.id.etPost);
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
    }

    public void loadPost(String id) {
        presenter.loadPost(id);
    }

    @Override
    public void onPostLoaded(ModelPostResponse post) {
        tvTitlePost.setText(post.getTitle());
        tvBodyPost.setText(post.getBody());
        System.out.println("QQQ" + post.getTitle());
    }
}
