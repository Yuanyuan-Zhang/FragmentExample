package com.example.student.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    int check=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final FragmentOne fragOne = new FragmentOne();
        FragmentTwo fragTwo = new FragmentTwo();
        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.add(R.id.fragView, fragTwo, "Fragment2");
        transaction.commit();

        //int check = 1;

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if(check==1) {
                            ImageView iv1 = (ImageView) findViewById(R.id.imageView2);
                            iv1.setImageResource(R.drawable.linux01);
                            ImageView iv2 = (ImageView) findViewById(R.id.imageView);
                            iv2.setImageResource(R.drawable.linux02);
                            check=0;
                        }else{
                            ImageView iv1 = (ImageView) findViewById(R.id.imageView);
                            iv1.setImageResource(R.drawable.linux01);
                            ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
                            iv2.setImageResource(R.drawable.linux02);
                            check=1;


                        }

                    }
                }
        );

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
}
