package es.altair.csi2.examenprimeraevaluacion;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FavoriteContactActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName;
    private TextView txtNumber;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnOk, btnCancel;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_contact);

        edtName = (EditText) findViewById(R.id.edtName);

        txtNumber = (TextView) findViewById(R.id.txtNumber);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnOk = (Button) findViewById(R.id.btnOk);

        txtNumber = (TextView) findViewById(R.id.txtNumber);

        sp = getSharedPreferences("contacts", MODE_PRIVATE);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn0:
                txtNumber.setText(txtNumber.getText().toString() + btn0.getText());
                break;
            case R.id.btn1:
                txtNumber.setText(txtNumber.getText().toString() + btn1.getText());
                break;
            case R.id.btn2:
                txtNumber.setText(txtNumber.getText().toString() + btn2.getText());
                break;
            case R.id.btn3:
                txtNumber.setText( txtNumber.getText().toString() + btn3.getText());
                break;
            case R.id.btn4:
                txtNumber.setText(txtNumber.getText().toString() + btn4.getText());
                break;
            case R.id.btn5:
                txtNumber.setText(txtNumber.getText().toString() + btn5.getText());
                break;
            case R.id.btn6:
                txtNumber.setText(txtNumber.getText().toString() + btn6.getText());
                break;
            case R.id.btn7:
                txtNumber.setText(txtNumber.getText().toString() + btn7.getText());
                break;
            case R.id.btn8:
                txtNumber.setText(txtNumber.getText().toString() + btn8.getText());
                break;
            case R.id.btn9:
                txtNumber.setText(txtNumber.getText().toString() + btn9.getText());
                break;
            case R.id.btnOk:
                setResult(RESULT_OK);
                break;
            case R.id.btnCancel:
                break;
        }
    }
}
