package com.quinstedt.islandRush.instructionClasses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageButton;

import com.quinstedt.islandRush.R;
import com.quinstedt.islandRush.activityClasses.MainActivity;

public class CheckLeaderboard extends AppCompatActivity {

    ImageButton exitBtn4;
    float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_leaderboard);

        exitBtn4= findViewById(R.id.exitBtn4);
        exitBtn4.setOnClickListener(view -> goBack());
    }

    private void goBack() {
        Intent exitTutorial = new Intent(this, MainActivity.class);
        startActivity(exitTutorial);
    }

    /**
     * This method  is used to swipe to the previous screen
     */
    public boolean onTouchEvent(MotionEvent touchEvent2){
        switch (touchEvent2.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent2.getX();
                y1 = touchEvent2.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent2.getX();
                y2 = touchEvent2.getY();
                if(x1 < x2){
                    Intent previousScreen = new Intent(this, ControlsInstruction.class);
                    startActivity(previousScreen);
                }
        }return  false;
    }
}