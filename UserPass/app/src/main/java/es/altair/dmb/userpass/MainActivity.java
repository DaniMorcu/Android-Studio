package es.altair.dmb.userpass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*  Declaramos todos los atributos que vayamos a usar en la aplicacion de la activity_main*/
    private EditText edtUser;
    private EditText edtPass;
    private Button btnSend;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*  Nos dice la primera pantalla que vamos a ver al iniciar y nos indica la ruta del mismo */
        setContentView(R.layout.activity_main);

        /*  Asignamos a la varible la caja de texto del activity_main, casteamos para localizacrlo
         SIEMPRE con findViewById y con R localizamos el id del objeto (inicianizandolo)*/
        edtUser = (EditText) findViewById(R.id.txtUser);
        edtPass = (EditText) findViewById(R.id.txtPass);

        btnSend = (Button) findViewById(R.id.btnSend);
        /*  Creamo el evento del click del boton y confirmamos que lo implementemos en el main
        (en el error)*/
        btnSend.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
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
    /**
     * View es cualquier elemento.
     */
    public void onClick(View v) {
        /**
         * Diferenciamos los distintos botones con el id de cada botón ya que es único
         */
        switch (v.getId())
        {
            /**
             * Boton de enviar
             */
            case R.id.btnSend:
                /**
                 * Con getText extraemos el texto del Editext, con el lenght confirmamos que no es uan cadena
                 * vacía comparandolo con 0 (si introduce un espacio en blanco tendríamos que jugar con el Trim
                 * para regularlos.
                 */
                if(edtUser.getText().length() ==0 || edtPass.getText().length()==0) {
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.msg01), Toast.LENGTH_LONG).show();
                }
                else
                {
                    /*  Evento que usamos para manejarnos entre las actividades o pantallas*/
                    Intent i = new Intent(MainActivity.this, Main2Activity.class); /*Donde estoy, a donde voy*/
                    /*  Es un mapa donde almacenamos clave y valor, este lo usamos en los intent para mandar información
                     * string, char, bytes... a la siguiente actividad. Con cada clave identificamos una cadena que luego
                      * llamaremos en la activity 2 con su correspodiente clave y asi jugar con las cadensa obtenidas en
                      * la pantalla Main*/
                    i.putExtra("user", edtUser.getText().toString());   /*  Con el .ToString para verificar
                    que no dará error al extrar el valor de text*/
                    i.putExtra("pass", edtPass.getText().toString());
                    startActivity(i);
                    /* Con esto finalizamos la actividad y si pulsamos retroceder al entrar en al panalla
                    * regresará a la pantalla inicial*/
                    //finish();
                }
                break;
            /**
             * Botón de limpiar
             */
            case R.id.btnClear:
                edtUser.setText("");
                edtPass.setText("");
                break;
        }
    }
}
