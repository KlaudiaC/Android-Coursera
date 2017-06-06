package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ActivityTwo extends Activity {
    // Use these as keys when you're saving state between reconfigurations
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Lab-ActivityTwo";

    // Lifecycle counters
    private int mCreate = 0;
    private int mRestart = 0;
    private int mStart = 0;
    private int mResume = 0;

    // variables for each of the TextViews for displaying the current count of each counter variable
    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvStart;
    private TextView mTvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // TextView variables
        mTvCreate = (TextView)findViewById(R.id.on_create_view);
        mTvStart = (TextView)findViewById(R.id.on_start_view);
        mTvResume = (TextView)findViewById(R.id.on_resume_view);
        mTvRestart = (TextView)findViewById(R.id.on_restart_view);


        Button closeButton = (Button) findViewById(R.id.bClose);
        closeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // This function closes Activity Two
                if(v.getId() == R.id.bClose)
                    finish();
            }
        });

        // Has previous state been saved?
        if (savedInstanceState != null) {
            // Restore value of counters from saved state
            mCreate = savedInstanceState.getInt(CREATE_KEY, 0);
            mRestart = savedInstanceState.getInt(RESTART_KEY, 0);
            mStart = savedInstanceState.getInt(START_KEY, 0);
            mResume = savedInstanceState.getInt(RESUME_KEY, 0);
        }

        // Emit LogCat message
        Log.i(TAG, "Entered the onCreate() method");

        // Update the appropriate count variable and the user interface
        mCreate++;
        displayCounts();
    }

    // Lifecycle callback methods overrides

    @Override
    public void onStart() {
        super.onStart();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStart() method");

        // Update the appropriate count variable and the user interface
        mStart++;
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Emit LogCat message
        Log.i(TAG, "Entered the onResume() method");

        // Update the appropriate count variable and the user interface
        mResume++;
        displayCounts();
    }

    @Override
    public void onPause() {
        super.onPause();

        // Emit LogCat message
        Log.i(TAG, "Entered the onPause() method");
    }

    @Override
    public void onStop() {
        super.onStop();

        // Emit LogCat message
        Log.i(TAG, "Entered the onStop() method");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        // Emit LogCat message
        Log.i(TAG, "Entered the onRestart() method");

        // Update the appropriate count variable and the user interface
        mRestart++;
        displayCounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Emit LogCat message
        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save counter state information
        savedInstanceState.putInt(RESTART_KEY, mRestart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
        savedInstanceState.putInt(START_KEY, mStart);
        savedInstanceState.putInt(CREATE_KEY, mCreate);
    }

    // Updates the displayed counters
    public void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
    }
}
