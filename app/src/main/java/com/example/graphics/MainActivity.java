package com.example.graphics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mBackgroundLinearLayout;

    private String[] colors = {"BLUE", "BLACK", "CYAN", "DKGRAY",
            "GRAY", "GREEN", "LTGRAY", "MAGENTA", "RED",  "TRANSPARENT",
            "WHITE", "YELLOW"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBackgroundLinearLayout = findViewById(R.id.linearLayout);

        final Spinner colorSpinner = findViewById(R.id.color_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);
        colorSpinner.setSelection(0);

        colorSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                setBackgroundColor(colorSpinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
        private void setBackgroundColor(String strColor){
            Toast.makeText(this, strColor, Toast.LENGTH_SHORT).show();
            if(strColor.equalsIgnoreCase("BLUE")){
                mBackgroundLinearLayout.setBackgroundColor(Color.BLUE);
            }else if (strColor.equalsIgnoreCase("BLACK")){
                mBackgroundLinearLayout.setBackgroundColor(Color.BLACK);
            }else if (strColor.equalsIgnoreCase("CYAN")){
                mBackgroundLinearLayout.setBackgroundColor(Color.CYAN);
            }else if (strColor.equalsIgnoreCase("DKGRAY")){
                mBackgroundLinearLayout.setBackgroundColor(Color.DKGRAY);
            }else if (strColor.equalsIgnoreCase("GRAY")){
                mBackgroundLinearLayout.setBackgroundColor(Color.GRAY);
            }else if (strColor.equalsIgnoreCase("GREEN")){
                mBackgroundLinearLayout.setBackgroundColor(Color.GREEN);
            }else if (strColor.equalsIgnoreCase("LTGRAY")){
                mBackgroundLinearLayout.setBackgroundColor(Color.LTGRAY);
            }else if (strColor.equalsIgnoreCase("MAGENTA")){
                mBackgroundLinearLayout.setBackgroundColor(Color.MAGENTA);
            }else if (strColor.equalsIgnoreCase("RED")){
                mBackgroundLinearLayout.setBackgroundColor(Color.RED);
            }else if (strColor.equalsIgnoreCase("TRANSPARENT")){
                mBackgroundLinearLayout.setBackgroundColor(Color.TRANSPARENT);
            }else if (strColor.equalsIgnoreCase("WHITE")){
                mBackgroundLinearLayout.setBackgroundColor(Color.WHITE);
            }else if (strColor.equalsIgnoreCase("YELLOW")){
                mBackgroundLinearLayout.setBackgroundColor(Color.YELLOW);
            }


    }

    public class ViewGraphicsActivity extends Activity{
        @Override
        public void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);

            setContentView(new MyView(this));
        }
    }

    class MyView extends View{
        public MyView(Context context){
            super(context);
        }

        @Override
        public void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(20);
            paint.setAntiAlias(true);
            canvas.drawColor(Color.BLUE);
            canvas.drawText("Hello Kitty", 10, 20, paint);
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
            canvas.drawBitmap(image, 40, 80, null);

        }
    }
}
