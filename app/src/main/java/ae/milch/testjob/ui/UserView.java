package ae.milch.testjob.ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ae.milch.testjob.R;
import ae.milch.testjob.models.usermodel.UserModelResponse;


public class UserView extends LinearLayout {
    private TextView tvName;
    private TextView tvUserName;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvWebsite;

    private View viewDivider;

    public UserView(Context context) {
        super(context);
        init();
    }

    public UserView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public UserView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.user_view, this);
        tvName = findViewById(R.id.tv_name);
        tvUserName = findViewById(R.id.tv_user_name);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvWebsite = findViewById(R.id.tv_website);
        viewDivider = findViewById(R.id.view_divider);
    }

    public void setup(UserModelResponse user, int position) {
        if (position == 4) {
            viewDivider.setVisibility(GONE);
        }
        tvName.setText(user.getName());
        tvUserName.setText(user.getUsername());
        tvEmail.setText(user.getEmail());
        tvPhone.setText(user.getPhone());
        tvWebsite.setText(user.getWebsite());
    }
}
