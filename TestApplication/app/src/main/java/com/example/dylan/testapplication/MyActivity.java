package com.example.dylan.testapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.AudioTrack;
import android.media.AudioManager;
import android.media.AudioFormat;
import java.util.Random;

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

    boolean m_stop = false;
    AudioTrack m_audioTrack;
    Thread m_noiseThread;

    public void buttonOnCLick(View v) {
        m_stop = false;

        /* 8000 bytes per second*/
        m_audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 8000, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_8BIT, 8000 /* 1 second buffer */,
                AudioTrack.MODE_STREAM);

        m_audioTrack.play();


        m_noiseThread = new Thread(m_noiseGenerator);
        m_noiseThread.start();
    }

    Runnable m_noiseGenerator = new Runnable()
    {
        public void run()
        {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

            /* 8000 bytes per second, 1000 bytes = 125 ms */
            byte [] noiseData = new byte[1000];
            Random rnd = new Random();

            while(!m_stop)
            {
                rnd.nextBytes(noiseData);
                m_audioTrack.write(noiseData, 0, noiseData.length);
            }
        }
    };
}
