package ae.milch.testjob.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.facebook.drawee.backends.pipeline.Fresco;

import ae.milch.testjob.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.content, new CardsFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_cards:
                            getSupportFragmentManager().beginTransaction().replace(R.id.content, new CardsFragment()).commit();
                            return true;
                        case R.id.action_contacts:
                            getSupportFragmentManager().beginTransaction().replace(R.id.content, new MyContactFragment()).commit();
                            return true;
                    }
                    return false;
                }
            };
}
