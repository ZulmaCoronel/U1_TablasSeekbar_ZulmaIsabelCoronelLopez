package mx.edu.ittepic.u1_tablasseekbar_zulmaisabelcoronellopez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar valorM;
    EditText valorN;
    TextView ResTabla,progreso;
    int num1 = 0,num2 = 0, tot = 0;
    String res = "";
    ListView lvTablas;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorN = (EditText) findViewById(R.id.etNumero1);
        valorM = (SeekBar) findViewById(R.id.seekBar);
        ResTabla = (TextView) findViewById(R.id.tvResultado);
        progreso = (TextView) findViewById(R.id.tvNumero2);
        lvTablas = (ListView) findViewById(R.id.lvTablas);

        //-----------------------ListView---------------------------
        al = new ArrayList<String>();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, al);
        lvTablas.setAdapter(aa);

        //al = ArrayList     //aa ArrayAdapter
        //---------------------SeekBar--------------------------------
        valorM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                num2 = progress;
                progreso.setText("Calcular hasta: "+num2);

                res = "";
                num1  = Integer.parseInt(valorN.getText().toString());

                for(int i = 0 ; i <= 20;  i++){

                    tot = num1 * i;
                    res += num1 + " x "+ i + " = " + tot + "\n";
                }

                ResTabla.setText(res);
                al.add(ResTabla.getText().toString());
                lvTablas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        //int noItem = position;
                        String valItem = (String)lvTablas.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(), "Ha presionado: "+valItem, Toast.LENGTH_LONG).show();
                    }
                });
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        }
}
