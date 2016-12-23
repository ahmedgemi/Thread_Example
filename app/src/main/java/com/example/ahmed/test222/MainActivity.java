package com.example.ahmed.test222;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


TextView t1 ;

    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        t1 = (TextView) findViewById(R.id.textView);


        myThread thread = new myThread();

        thread.start();

    }



    public class myThread extends Thread{


        public void run(){


            while (true){

                try {

                    count ++;



                    Thread.sleep(1000);

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            t1.setText(String.valueOf(count));
                        }
                    });



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }

}
