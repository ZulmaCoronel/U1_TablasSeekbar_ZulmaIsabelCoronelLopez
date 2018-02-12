package mx.edu.ittepic.u1_tablasseekbar_zulmaisabelcoronellopez;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button botoncal;
    SeekBar seekBar;
    TextView avance;
    String concat,total;
    int selec,respuesta;
    ListView lista;
    String [] array = new String[21];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        avance = findViewById(R.id.tvResultado);
        botoncal = findViewById(R.id.btncalcular);
        lista = findViewById(R.id.lvTablas);
        total="";
        concat="";
        selec=0;
        //-----------------------ListView---------------------------
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);

        //---------------------SeekBar--------------------------------
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                total="";
                concat="";
                avance.setText(""+progress);
                selec = progress;
                }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        botoncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<=20;i++){
                    respuesta=selec*i;
                    array[i]=""+selec+" X "+i+" = "+respuesta;
                }
                lista.setAdapter(adapter);
            }
        });
    }
}


