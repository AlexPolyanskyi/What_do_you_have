package comalexpolyanskyi.github.what_do_you_have;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

public class ScrollingActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE = "DetailActivity:image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        ViewCompat.setTransitionName(image, EXTRA_IMAGE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public static void launch(MainActivity activity, ImageView image, Serializable data){
        ActivityOptionsCompat options =
               ActivityOptionsCompat.makeSceneTransitionAnimation(
                     activity, image, EXTRA_IMAGE);
        Intent intent = new Intent(activity, ScrollingActivity.class);
        intent.putExtra("data", data);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
