package com.quinstedt.islandRush.activityClasses;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import com.quinstedt.islandRush.R;

public class ControlChoice extends AppCompatActivity {

    Button controlPad, joystick;
    ImageButton escapeHash;
    Animation scaleUp,scaleDown;
    Boolean isOnRaceMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_choice);

        ConstraintLayout layout = findViewById(R.id.controlChoice);
        AnimationDrawable animationBackground = (AnimationDrawable) layout.getBackground();
        animationBackground.setEnterFadeDuration(2500);
        animationBackground.setExitFadeDuration(5000);
        animationBackground.start();

        escapeHash =  findViewById(R.id.controlChoice_escapeHash);
        escapeHash.setOnClickListener(view -> goBack());

        joystick = findViewById(R.id.button_joystick);
        joystick.setOnClickListener(view -> openJoystick());

        controlPad = findViewById(R.id.button_control);
        controlPad.setOnClickListener(view -> openButtonControl());
        SwitchCompat raceMode = findViewById(R.id.raceMode);
        raceMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean raceModeIsON) {
                if(raceModeIsON){
                    isOnRaceMode = true;
                }else{
                    isOnRaceMode = false;
                }
            }
        });
    }

    /**
     * Method for the escape Hash that launches MainActivity
     */
    private void goBack() {
        Intent goToMain = new Intent(this, MainActivity.class);
        escapeHash.startAnimation(scaleUp);
        escapeHash.startAnimation(scaleDown);
        startActivity(goToMain);
    }

    /**
     * Launches ControlPad when ButtonPad button is click
     */
    public void openButtonControl() {
        Intent buttonControlIntent = new Intent(this, ControlPad.class);
        if(isOnRaceMode){
            buttonControlIntent.putExtra("RaceMode", "Race Mode is on" );
        }
        startActivity(buttonControlIntent);
    }
    /**
     * Launches Joystick Activity when joystick button is click
     */
    public void openJoystick() {
        Intent joystickIntent = new Intent(this, Joystick.class);
        if(isOnRaceMode){
            joystickIntent.putExtra("RaceMode", "Race Mode is on");
        }
        startActivity(joystickIntent);
    }

}
