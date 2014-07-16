package com.example.dylan.testapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buttonOnCLick(View v) {
//        int[] notes = new int[]{60, 62, 64, 65, 67, 69, 71, 72, 72, 71, 69, 67, 65, 64, 62, 60};
//        try {
//            Synthesizer synthesizer = MidiSystem.getSynthesizer();
//            synthesizer.open();
//            MidiChannel channel = synthesizer.getChannels()[0];
//
//            for (int note : notes) {
//                channel.noteOn(note, 50);
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    break;
//                } finally {
//                    channel.noteOff(note);
//                }
//            }
//        } catch (MidiUnavailableException e) {
//            e.printStackTrace();
//        }
        Button button = (Button) v;
        button.setText("I was clicked!!!");
    }
}
