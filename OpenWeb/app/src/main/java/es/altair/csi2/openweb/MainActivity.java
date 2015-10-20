package es.altair.csi2.openweb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSend;
    private EditText edtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);

        edtUrl = (EditText) findViewById(R.id.edtUrl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSend:
                //  Comprobar la caja de texto no está vacia
                if(edtUrl.getText().length() != 0){
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("web", edtUrl.getText().toString());
                    startActivity(i);
                }
                else{
                    edtUrl.setError(getResources().getString(R.string.msgerror));
                }
                break;
        }
    }
}
