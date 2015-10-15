package es.altair.csi2.apptheme4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNick;
    private Button btnSend;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNick=(EditText)findViewById(R.id.edtNick);
        btnSend=(Button)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(this);

        sp = getSharedPreferences("dates", MODE_PRIVATE);

        if(sp.contains("nick")){
            Intent i = new Intent(MainActivity.this, ShowOptionsActivity.class);
            startActivity(i);
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case btnSend.getId():

                break;

        }
    }
}
