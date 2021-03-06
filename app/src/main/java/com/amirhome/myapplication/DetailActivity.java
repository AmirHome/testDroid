package com.amirhome.myapplication;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    public static final String LOG_TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "onCreate");

/*        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick ( View v){
               Log.d(LOG_TAG,"onClick");
            }
        });*/


        TextView tv = (TextView) findViewById(R.id.longText);

        StringBuffer sb = new StringBuffer();
        sb.append(getString(R.string.lorem_ipsum));
        sb.append(getString(R.string.lorem_ipsum));
        sb.append(getString(R.string.lorem_ipsum));

        tv.setText(sb.toString());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.notifyAction, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(LOG_TAG, "Changed to portrait");
        } else {
            Log.d(LOG_TAG, "Changed to Landscape");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.add(Menu.NONE, Menu.NONE, 104, "New Menu");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(DetailActivity.this, "You chose an item...", Toast.LENGTH_LONG).show();
                return false;
            }
        });
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

    public void registerClickHandler(View view) {
        Button btn = (Button) view;
//        EditText et = (EditText) view;
        Log.d(LOG_TAG, "registerClickHandler" + btn.getText());
    }

    public void imgOnclickHandler(View view) {
        ImageView iv = (ImageView) findViewById(R.id.imageView);

        String imgName = "amir_logo";
        int res = getResources().getIdentifier(imgName, "drawable", getPackageName());
        iv.setImageResource(res);


    }


    public void actionResourceOnclickHandler(MenuItem item) {
        ImageView iv = (ImageView) findViewById(R.id.imageView);

        String imgName = "amir_logo_2";
        int res = getResources().getIdentifier(imgName, "drawable", getPackageName());
        iv.setImageResource(res);
    }

    public void actionAssetsOnclickHandler(MenuItem item) {
        String imgName = "amirhome_icon.png";
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        try {
            InputStream stream = getResources().getAssets().open(imgName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv.setImageDrawable(drawable);
        } catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }
}
