package td.fransiska.ti3a_17_uts_android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import td.fransiska.ti3a_17_uts_android.Adapters.RvKotaAdapter;
import td.fransiska.ti3a_17_uts_android.Helper.DataKotaHelper;

public class LihatDaftarKotaActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RvKotaAdapter rvKotaAdapter;
    Button btnTambah;

    Cursor cursor;
    DataKotaHelper dataKotaHelper;

    ArrayList<String> dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_daftar_kota);

        rv = findViewById(R.id.rv);
        btnTambah = findViewById(R.id.btnTambah);
        dataKotaHelper = new DataKotaHelper(this);

        lm = new LinearLayoutManager(this);

        rv.setLayoutManager(lm);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LihatDaftarKotaActivity.this,InputDataKotaActivity.class);
                startActivity(i);
            }
        });
        refreshList();
    }

    public void refreshList(){
        SQLiteDatabase db = dataKotaHelper.getReadableDatabase();
        dataset = new ArrayList<String>();

        cursor = db.rawQuery("SELECT * FROM kota",null);
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            dataset.add(cursor.getString(0).toString());
        }

        rvKotaAdapter = new RvKotaAdapter(dataset);

        rv.setAdapter(rvKotaAdapter);

    }
}
