package com.example.ledcontroller;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sdsmdg.harjot.crollerTest.Croller;
import com.sdsmdg.harjot.crollerTest.OnCrollerChangeListener;


public class Jasnosc extends AppCompatActivity {
    Croller croller ;
    //private MainActivity.ConnectedThread mConnectedThread; // bluetooth background worker thread to send and receive data
    private Button wyslij;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jasnosc);
        wyslij = (Button) findViewById(R.id.button2);
        croller =  (Croller) findViewById(R.id.croller);
        croller.setIndicatorWidth(10);
        croller.setBackCircleColor(Color.parseColor("#EDEDED"));
        croller.setMainCircleColor(Color.WHITE);
        croller.setMax(10);
        croller.setMin(0);
        croller.setStartOffset(45);
        croller.setLabel("Light: 10%");
        croller.setIsContinuous(true);
        croller.setLabelColor(Color.BLACK);
        croller.setProgressPrimaryColor(Color.parseColor("#0B3C49"));
        croller.setIndicatorColor(Color.parseColor("#0B3C49"));
        croller.setProgressSecondaryColor(Color.parseColor("#EEEEEE"));

        wyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mConnectedThread.write("dupa");

            }
        });


        croller.setOnCrollerChangeListener(new OnCrollerChangeListener() {

            @Override
            public void onProgressChanged( Croller croller, int progress) {
                sterLight(progress);

            }
            @Override
            public void onStartTrackingTouch( Croller croller) {}
            @Override
            public void onStopTrackingTouch( Croller croller) {}
        });
    }

    void sterLight(int progress){

        if(progress==10){
            progress--;
            String progres_napis = "Light:" +progress;
            //light.child(ID_light).child("stan").setValue(progres_napis);
           // mConnectedThread.write(progres_napis );
            progress++;
        }else {
            String progres_napis = "Light:" +progress;
            //light.child(ID_light).child("stan").setValue(progres_napis);
        }

        if(progress==0){
            croller.setLabel("Light: OFF");
        }else{
            progress = progress*10;
            croller.setLabel("Light: " + progress + "%");
        }
    }
}