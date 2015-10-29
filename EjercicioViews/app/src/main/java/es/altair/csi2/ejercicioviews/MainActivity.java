package es.altair.csi2.ejercicioviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ToggleButton tglButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tglButton = (ToggleButton) findViewById(R.id.tglButton);

        tglButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tglButton:
                if (tglButton.isChecked())
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.msgActivated), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.msgNoActivated), Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
