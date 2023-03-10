package com.quinstedt.islandRush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LeaderboardAnimation extends AppCompatActivity {

    TextView raceMessage, playerNameAnim, timeAnim, finnishMessageAnim;
    ImageView carImageAnim, mainImageAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_animation);


        raceMessage =  findViewById(R.id.raceMessage_anim);
        playerNameAnim = findViewById(R.id.player_name_anim);
        timeAnim = findViewById(R.id.timing_anim);
        mainImageAnim = findViewById(R.id.main_page_anim);
        carImageAnim = findViewById(R.id.car_image_anim);
        finnishMessageAnim =findViewById(R.id.message_end_anim);
        mainImageAnim = findViewById(R.id.main_page_anim);

        playerNameAnim.setText(GlobalData.getGlobalData().getPlayerData());
        String applause = Utils.getEmoji(Utils.APPLAUSE);
        String raceMessage = "Good job! " + applause;
        this.raceMessage.setText(raceMessage);
        timeAnim.setText(GlobalData.getGlobalData().getRaceTime());
        String crossedFingers = Utils.getEmoji(Utils.CROSSED_FINGERS);
        String finishMessage = "Good luck next time " + crossedFingers;
        finnishMessageAnim.setText(finishMessage);

        Animation slideBackground= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_background);
        Animation textSlideOut=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_text);
        Animation moveCar= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.car_move);
        Animation textSlideIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_text);

        carImageAnim.setAnimation(moveCar);


        //slide in the texts
        playerNameAnim.setAnimation(textSlideIn);
        timeAnim.setAnimation(textSlideIn);
        this.raceMessage.setAnimation(textSlideIn);
        finnishMessageAnim.setAnimation(textSlideIn);

        //rotate the texts

        playerNameAnim.animate().rotationBy(720).setDuration(2000).setStartDelay(2000);
        timeAnim.animate().rotationBy(720).setDuration(2000).setStartDelay(2000);
        this.raceMessage.animate().rotationBy(720).setDuration(2000).setStartDelay(2000);

        //Slide out the texts
        playerNameAnim.setAnimation(textSlideOut);
        timeAnim.setAnimation(textSlideOut);
        this.raceMessage.setAnimation(textSlideOut);
        finnishMessageAnim.setAnimation(textSlideOut);
        mainImageAnim.setAnimation(slideBackground);

        slideBackground.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),Leaderboard.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }}