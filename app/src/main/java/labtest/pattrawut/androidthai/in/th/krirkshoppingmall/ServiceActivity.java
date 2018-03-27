package labtest.pattrawut.androidthai.in.th.krirkshoppingmall;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ActionMenuView;
import android.widget.Toolbar;

public class ServiceActivity extends AppCompatActivity {
    private String[] loginString;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Get Value From Intent
        loginString = getIntent().getStringArrayExtra("Login");

//        Create Toobar
        createToolbar();
    }
    private  void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarService);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(loginString[1]);
        getSupportActionBar().setSubtitle(loginString[4]);

        drawerLayout = findViewById(R.id.layoutDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(ServiceActivity.this,
                drawerLayout, R.string.open, R.string.close);

        getSupportActionBar().set
        


    } //Main Method

    private void setSupportActionBar(Toolbar toolbar) {
    }
} //Main Class
