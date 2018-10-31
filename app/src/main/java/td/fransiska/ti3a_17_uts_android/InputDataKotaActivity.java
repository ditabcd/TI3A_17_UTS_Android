package td.fransiska.ti3a_17_uts_android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import td.fransiska.ti3a_17_uts_android.Helper.DataKotaHelper;

public class InputDataKotaActivity extends AppCompatActivity {

    DataKotaHelper dataKotaHelper;
    Cursor cursor;
    EditText edtNama;
    Button btnInput,btnLihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_kota);

        edtNama = findViewById(R.id.edtNama);
        btnInput = findViewById(R.id.btnInput);
        btnLihat = findViewById(R.id.btnLihat);
        dataKotaHelper = new DataKotaHelper(this);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edtNama.getText().toString();
                SQLiteDatabase db = dataKotaHelper.getWritableDatabase();
                db.execSQL("insert into kota (nama) values ('"+nama+"')");
                Toast.makeText(InputDataKotaActivity.this,"Input Berhasil! Nama Kota: "+nama,Toast.LENGTH_LONG).show();
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InputDataKotaActivity.this,LihatDaftarKotaActivity.class);
                startActivity(i);
            }
        });
    }
}
