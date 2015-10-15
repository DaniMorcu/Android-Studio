package es.altair.csi2.loginsharepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUser;
    private EditText edtPassword;
    private Button btnSave;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser=(EditText)findViewById(R.id.edtUser);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        //  Guardaremos una sesion en la aplicacion (es un contenedor)
        sp = getSharedPreferences("datos", MODE_PRIVATE);


        //  Con esto al iniciar la aplicacion busca una clave que se llame "user"
        //  si la hay significa que ya ha sido registrado con lo que realizamos
        //  un Intent para saltar a la segunda pantalla
        if(sp.contains("user")){

            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(i);

            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnSave:
                //  Objeto que necesitmaos para escribir en el sp (escribir)
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("user", edtUser.getText().toString());
                editor.putString("password", edtPassword.getText().toString());
                editor.commit();
                edtUser.setText("");
                edtPassword.setText("");

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);

                finish();
                break;
        }
    }
}
