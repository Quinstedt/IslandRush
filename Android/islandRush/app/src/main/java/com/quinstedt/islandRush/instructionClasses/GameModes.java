package com.quinstedt.islandRush.instructionClasses;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.quinstedt.islandRush.R;
import com.quinstedt.islandRush.activityClasses.MainActivity;

public class GameModes extends AppCompatActivity {

    ImageButton exitBtn2;
    float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_modes);
        exitBtn2= findViewById(R.id.exitBtn2);
        exitBtn2.setOnClickListener(view -> goBack());

    }

    /**
     * This method  is used to swipe to the previous screen or the next screen
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
                    Intent previousScreen = new Intent(this, GettingStarted.class);
                    startActivity(previousScreen);
                }else if(x1>x2){
                    Intent nextScreen = new Intent(this, ControlsInstruction.class);
                    startActivity(nextScreen);}
        }return  false;
    }

    private void goBack() {
        Intent exitTutorial = new Intent(this, MainActivity.class);
        startActivity(exitTutorial);
    }

}