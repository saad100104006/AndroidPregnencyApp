package info.androidhive.instantapps.pregnency;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import info.androidhive.instantapps.pregnency.utils.TextProgressBar;

/**
 * Created by Saad on 7/12/17.
 */


public class CustomProgressBarDemo extends AppCompatActivity {

    int myProgress = 0;
    TextProgressBar pb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_progressbar);

        pb = new TextProgressBar(this);
        pb = (TextProgressBar) findViewById(R.id.pb);
        new Thread(myThread).start();
    }

    private Runnable myThread = new Runnable(){
        @Override
        public void run() {
            while (myProgress<100){
                try{
                    System.out.println("SSS");
                    pb.setProgress(myProgress);
                    pb.setText(myProgress+"/100");
                    myHandle.sendMessage(myHandle.obtainMessage());
                    Thread.sleep(500);
                }
                catch(Throwable t){
                }
            }
        }

        Handler myHandle = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                myProgress++;
                pb.setProgress(myProgress);
                pb.setText(myProgress+"/100");
            }
        };
    };
}
