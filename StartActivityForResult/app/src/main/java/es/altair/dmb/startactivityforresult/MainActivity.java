package es.altair.dmb.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Es una variable constante
     */
    private static final int CODE2 = 1;
    private static final int CODE3 = 2;

    private Button btnSend;
    private Button btnGo;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Declaramos las variables en onCreate
         */
        btnSend = (Button)findViewById(R.id.btnSend);
        btnGo = (Button)findViewById(R.id.btngGo);
        txtResult = (TextView)findViewById(R.id.txtResult);

        /**
         * Asignamos un evento al click de los botones
         */
        btnSend.setOnClickListener(this);
        btnGo.setOnClickListener(this);
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
        case R.id.btnSend:
            /**
             * Intent: para movernos a otra actividad. De donde venimos y donde vamos
             */
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(i, CODE2);
            break;
        case R.id.btngGo:
            Intent ii = new Intent(MainActivity.this, ThirdActivity.class);
            startActivityForResult(ii, CODE3);
            break;
    }


    }

    /**
     * Creamos este metodo recogemos el resultado devuelto de la anterior actividad
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         *
         */
        if(requestCode == CODE2){
            if(resultCode == RESULT_OK){
                txtResult.setText(getResources().getString(R.string.ok));
            }
            else if (resultCode == RESULT_CANCELED) {
                txtResult.setText((getResources().getString(R.string.cancel)));
            }
        }
        else if(resultCode == CODE3){
            if(resultCode == RESULT_OK)
            {
                /**
                 * El intent se llama data, por lo que obtenemos la cadena declarado como "texto"
                 */
                txtResult.setText(data.getStringExtra("texto"));
            }
        }
    }
}
