package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mStoryIndex = 1;
        }
        else {
            mStoryIndex = savedInstanceState.getInt("StoryIndexKey");
        }

        // TODO: Step 4 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                    case 2:
                        mStoryIndex = 3;
                        break;
                    case 3:
                        mStoryIndex = 6;
                        break;
                }

                updateUI();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                        mStoryIndex = 2;
                        break;
                    case 2:
                        mStoryIndex = 4;
                        break;
                    case 3:
                        mStoryIndex = 5;
                        break;
                }

                updateUI();
            }
        });

        updateUI();
    }

    private void updateUI() {
        switch (mStoryIndex) {
            case 1:
                mStoryTextView.setText(R.string.T1_Story);
                mButtonTop.setText(R.string.T1_Ans1);
                mButtonBottom.setText(R.string.T1_Ans2);
                break;
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryTextView.setText(R.string.T4_End);
                mButtonTop.setVisibility(View.GONE);
                mButtonBottom.setVisibility(View.GONE);
                break;
            case 5:
                mStoryTextView.setText(R.string.T5_End);
                mButtonTop.setVisibility(View.GONE);
                mButtonBottom.setVisibility(View.GONE);
                break;
            case 6:
                mStoryTextView.setText(R.string.T6_End);
                mButtonTop.setVisibility(View.GONE);
                mButtonBottom.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndexKey", mStoryIndex);
    }
}
