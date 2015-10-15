package es.altair.dmb.appcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnPoint;
    private Button btnPlus;
    private Button btnLess;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnClear;
    private Button btnCalculate;

    private TextView edtCalculate;
    private TextView txtResult;

    //  Variables auxiliares para almacenar
    private String operacion = "";
    private char signo;
    private String [] parts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCero = (Button) findViewById(R.id.btnCero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnLess = (Button) findViewById(R.id.btnLess);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        edtCalculate = (TextView) findViewById(R.id.edtCalculate);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnCero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnLess.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);

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
            case R.id.btnCero:
                operacion += "0";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnOne:
                operacion += "1";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnTwo:
                operacion += "2";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnThree:
                operacion += "3";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnFour:
                operacion += "4";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnFive:
                operacion += "5";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnSix:
                operacion += "6";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnSeven:
                operacion += "7";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnEight:
                operacion += "8";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnNine:
                operacion += "9";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnPlus:
                operacion += "+";
                signo = '+';
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnLess:
                operacion += "-";
                signo = '-';
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnMultiply:
                operacion += "*";
                signo = '*';
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnDivide:
                operacion += "/";
                signo = '/';
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnPoint:
                operacion +=  ".";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnClear:
                operacion = "";
                edtCalculate.setText(operacion.toString());
                break;
            case R.id.btnCalculate:
                String [] parts = null;
                float result = 0;

                switch (signo){
                    case '+':
                        parts = operacion.split("+");
                        result = Float.parseFloat(parts[0]) + Float.parseFloat(parts[2]);
                        break;
                    case '-':
                        parts = operacion.split("-");
                        result = Float.parseFloat(parts[0]) + Float.parseFloat(parts[2]);
                        break;
                    case '*':
                        parts = operacion.split("*");
                        result = Float.parseFloat(parts[0]) + Float.parseFloat(parts[2]);
                        break;
                    case '/':
                        parts = operacion.split("/");
                        result = Float.parseFloat(parts[0]) + Float.parseFloat(parts[2]);
                        break;
                }
                txtResult.setText(String.valueOf(result));

                break;
        }
    }
}
