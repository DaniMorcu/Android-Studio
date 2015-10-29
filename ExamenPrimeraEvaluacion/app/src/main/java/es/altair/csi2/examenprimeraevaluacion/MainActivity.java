package es.altair.csi2.examenprimeraevaluacion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private ImageButton ib1, ib2, ib3, ib4;
    private TextView txt1, txt2, txt3, txt4, txtLastCall;
    private Button btnDelete;
    private SharedPreferences sp;

    final static int CODE1 = 1;
    final static int CODE2 = 2;
    final static int CODE3 = 3;
    final static int CODE4 = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib1 = (ImageButton) findViewById(R.id.ib1);
        ib2 = (ImageButton) findViewById(R.id.ib2);
        ib3 = (ImageButton) findViewById(R.id.ib3);
        ib4 = (ImageButton) findViewById(R.id.ib4);

        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txtLastCall = (TextView) findViewById(R.id.txtLastCall);

        btnDelete = (Button) findViewById(R.id.btnDelete);

        sp = getSharedPreferences("contact1", MODE_PRIVATE);
        sp = getSharedPreferences("contact2", MODE_PRIVATE);
        sp = getSharedPreferences("contact3", MODE_PRIVATE);
        sp = getSharedPreferences("contact4", MODE_PRIVATE);

        ib1.setOnClickListener(this);
        ib1.setOnLongClickListener(this);
        ib2.setOnClickListener(this);
        ib2.setOnLongClickListener(this);
        ib3.setOnClickListener(this);
        ib3.setOnLongClickListener(this);
        ib4.setOnClickListener(this);
        ib4.setOnLongClickListener(this);

        btnDelete.setOnClickListener(this);


//        Intent i = new Intent(MainActivity.this, FavoriteContactActivity.class);
//        startActivity(i);
//        finish();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib1:
                Intent i = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(i, CODE1);
                finish();
                break;
            case R.id.ib2:
                Intent ii = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(ii, CODE2);
                finish();
                break;
            case R.id.ib3:
                Intent iii = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(iii, CODE3);
                finish();
                break;
            case R.id.ib4:
                Intent iv = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(iv, CODE4);
                finish();
                break;
        }
    }



    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.ib1:
                Intent i = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivity(i);
                startActivityForResult(i, CODE1);
                finish();
                break;
            case R.id.ib2:
                Intent ii = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(ii, CODE2);
                finish();
                break;
            case R.id.ib3:
                Intent iii = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(iii, CODE3);
                finish();
                break;
            case R.id.ib4:
                Intent iv = new Intent(MainActivity.this, FavoriteContactActivity.class);
                startActivityForResult(iv, CODE4);
                finish();
                break;
        }
        return false;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        if(requestCode == CODE1)
        {
//            if(resultCode == RESULT_OK)
//            {
//
//            }
        }
    }
}
