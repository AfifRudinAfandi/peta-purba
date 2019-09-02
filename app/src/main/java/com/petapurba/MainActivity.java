package com.petapurba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Dialog dialog;
    Button menu;
    ToggleButton tgl1,tgl2,tgl3,tgl4;
    FrameLayout detail1,detail2,detail3,detail4;
    ImageView zoom1,zoom2,zoom3,zoom4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.menu1);
        tgl1 = findViewById(R.id.toggleButton1);
        tgl2 = findViewById(R.id.toggleButton2);
        tgl3 = findViewById(R.id.toggleButton3);
        tgl4 = findViewById(R.id.toggleButton4);
        detail1 = findViewById(R.id.detail1);
        detail2 = findViewById(R.id.detail2);
        detail3 = findViewById(R.id.detail3);
        detail4 = findViewById(R.id.detail4);
        zoom1 = findViewById(R.id.zoom1);
        zoom2 = findViewById(R.id.zoom2);
        zoom3 = findViewById(R.id.zoom3);
        zoom4 = findViewById(R.id.zoom4);
        dialog = new Dialog(this);
//        dialog = new Dialog(this, );
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        final Animation zoomAnimation = AnimationUtils.loadAnimation(this,R.anim.zoom);
        zoom1.startAnimation(zoomAnimation);
        zoom2.startAnimation(zoomAnimation);
        zoom3.startAnimation(zoomAnimation);
        zoom4.startAnimation(zoomAnimation);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlertMenu();
            }
        });

        tgl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detail1.getVisibility() == View.INVISIBLE){
                    detail1.setVisibility(View.VISIBLE);
                    detail2.setVisibility(View.INVISIBLE);
                    detail3.setVisibility(View.INVISIBLE);
                    detail4.setVisibility(View.INVISIBLE);
                }else {
                    detail1.setVisibility(View.INVISIBLE);
                }
            }
        });

        tgl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detail2.getVisibility() == View.INVISIBLE){
                    detail2.setVisibility(View.VISIBLE);
                    detail1.setVisibility(View.INVISIBLE);
                    detail3.setVisibility(View.INVISIBLE);
                    detail4.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail2.setVisibility(View.INVISIBLE);
                }
            }
        });

        tgl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detail3.getVisibility() == View.INVISIBLE){
                    detail3.setVisibility(View.VISIBLE);
                    detail1.setVisibility(View.INVISIBLE);
                    detail2.setVisibility(View.INVISIBLE);
                    detail4.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail3.setVisibility(View.INVISIBLE);
                }
            }
        });

        tgl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detail4.getVisibility() == View.INVISIBLE){
                    detail4.setVisibility(View.VISIBLE);
                    detail1.setVisibility(View.INVISIBLE);
                    detail2.setVisibility(View.INVISIBLE);
                    detail3.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail4.setVisibility(View.INVISIBLE);
                }
            }
        });

        /*tgl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    detail1.setVisibility(View.VISIBLE);
                    detail2.setVisibility(View.INVISIBLE);
                    detail3.setVisibility(View.INVISIBLE);
                    detail4.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail1.setVisibility(View.INVISIBLE);
                }
            }
        });*/
        /*tgl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    detail2.setVisibility(View.VISIBLE);
                    detail1.setVisibility(View.INVISIBLE);
                    detail3.setVisibility(View.INVISIBLE);
                    detail4.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail2.setVisibility(View.INVISIBLE);
                }
            }
        });*/
        /*tgl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    detail3.setVisibility(View.VISIBLE);
                    detail1.setVisibility(View.INVISIBLE);
                    detail2.setVisibility(View.INVISIBLE);
                    detail4.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail3.setVisibility(View.INVISIBLE);
                }
            }
        });*/
        /*tgl4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    detail4.setVisibility(View.VISIBLE);
                    detail1.setVisibility(View.INVISIBLE);
                    detail2.setVisibility(View.INVISIBLE);
                    detail3.setVisibility(View.INVISIBLE);
                } else {
                    // The toggle is disabled

                    detail4.setVisibility(View.INVISIBLE);
                }
            }
        });*/


    }


    public void ShowAlertMenu(){
        dialog.setContentView(R.layout.alert_menu);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
