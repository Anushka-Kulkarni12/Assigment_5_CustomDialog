package com.example.assigment_5_customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageSliderDialog {
     Context context;
    Button btnShowDialog;
    ImageView imageView;

    int[] imageIds;
     int delay;
    boolean loopImages;
     int currentIndex = 0;

    // constructor called
    public ImageSliderDialog(Context context, int[] images, int delay, boolean loopImages) {
        this.context = context;
        this.imageIds = images;
        this.delay = delay;
        this.loopImages = loopImages;
    }

    public void show() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_main); // Ensure this layout is created

         imageView = dialog.findViewById(R.id.imageView);
         btnShowDialog = dialog.findViewById(R.id.btnShowDialog); // Close button

        // Start image sliding
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(imageIds[currentIndex]);
                currentIndex++;

                if (currentIndex >= imageIds.length) {
                    if (loopImages) {
                        currentIndex = 0; // Loop back to the first image
                    } else {
                        dialog.dismiss(); // Dismiss dialog in last image is show
                        return;
                    }
                }

                handler.postDelayed(this, delay); // using next images
            }
        };

        btnShowDialog.setOnClickListener(v -> {
            handler.removeCallbacks(runnable); // handler is closing
            dialog.dismiss();
        });

        handler.post(runnable); // Start the image slider
        dialog.show();
    }
}


