package com.example.assigment_5_customdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnShowDialog;
    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageSliderDialog imageSliderDialog = new ImageSliderDialog(MainActivity.this, images, 2000, true);
                imageSliderDialog.show();
            }
        });
    }
}
