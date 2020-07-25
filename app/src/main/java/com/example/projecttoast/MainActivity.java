package com.example.projecttoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    Button btnToast, btnError, btnSuccess, btnInfo, btnWarning, btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btn_Toast);

        btnError = findViewById(R.id.btn_Error);
        btnSuccess = findViewById(R.id.btn_Success);
        btnWarning = findViewById(R.id.btn_Warning);
        btnImage = findViewById(R.id.btn_Image);
        btnInfo = findViewById(R.id.btn_Info);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCustomToast("Happy Birth Day Again");
            }
        });


        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.error(MainActivity.this, "This is an error Toast.", Toast.LENGTH_SHORT, true).show();

            }
        });
        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toasty.success(MainActivity.this, "This is an success Toast.", Toast.LENGTH_SHORT, true).show();
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(MainActivity.this, "This is an info Toast.", Toast.LENGTH_SHORT, true).show();


            }
        });
        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toasty.warning(MainActivity.this, "This is an warning Toast.", Toast.LENGTH_SHORT, true).show();

            }
        });
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.normal(MainActivity.this, "This is an Image Toast.", Toast.LENGTH_SHORT, ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_cake)).show();

            }
        });


    }


    public void myCustomToast(String string) {
        LayoutInflater Inflater = getLayoutInflater();
        View layoutVIew = Inflater.inflate(R.layout.layout_toast, (ViewGroup) findViewById(R.id.root_Toast));
        TextView toattextView = layoutVIew.findViewById(R.id.toast_Text);
        toattextView.setText(string);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layoutVIew);
        toast.show();

    }
}