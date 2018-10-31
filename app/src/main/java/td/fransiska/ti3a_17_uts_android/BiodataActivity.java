package td.fransiska.ti3a_17_uts_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class BiodataActivity extends AppCompatActivity {

    SessionManagement sessionManagement;
    TextView txtUsername;
    Button btnLogout,btnDataKota;
    ImageView imgView;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        txtUsername = (TextView) findViewById(R.id.txtUsername);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnDataKota = (Button) findViewById(R.id.btnDataKota);
        imgView = (ImageView) findViewById(R.id.imgView);

        sessionManagement = new SessionManagement(this);
        loginUser = sessionManagement.getUserInformation();

        Toast.makeText(this,sessionManagement.isLoggedIn()+"",Toast.LENGTH_LONG).show();

        txtUsername.setText(loginUser.get(sessionManagement.KEY_EMAIL));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });

        btnDataKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BiodataActivity.this,InputDataKotaActivity.class);
                startActivity(i);
            }
        });
    }
}
