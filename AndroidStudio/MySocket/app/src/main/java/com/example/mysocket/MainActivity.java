package com.example.mysocket;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText etText;
    TextView tvLog;
    ImageView nemo1;/*
    ImageView nemo2;
    ImageView nemo3;
    ImageView nemo4;
    ImageView nemo5;
    ImageView nemo6;
    ImageView nemo7;
    ImageView nemo8;
    ImageView nemo9;
    ImageView nemo10;
    ImageView nemo11;
    ImageView nemo12;
    ImageView nemo13;
    ImageView nemo14;
    ImageView nemo15;
    ImageView nemo16;
    ImageView nemo17;
    ImageView nemo18;
    ImageView nemo19;
    ImageView nemo20;
    ImageView nemo21;
    ImageView nemo22;
    ImageView nemo23;
    ImageView nemo24;
    ImageView nemo25;*/
    Handler handler = new Handler();

    String Mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = (TextView)findViewById(R.id.tvLog);
        etText = (EditText)findViewById(R.id.etText);
        btnSend = (Button)findViewById(R.id.btnSend);

        nemo1 = (ImageView)findViewById(R.id.nemo1);/*
        nemo2 = (ImageView)findViewById(R.id.nemo2);
        nemo3 = (ImageView)findViewById(R.id.nemo3);
        nemo4 = (ImageView)findViewById(R.id.nemo4);
        nemo5 = (ImageView)findViewById(R.id.nemo5);
        */
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String data = etText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Send(data);
                    }
                }).start();
                Toast.makeText(MainActivity.this,data, Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void printClientLog(final String data) {
        Log.d("MainActivity", data);
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvLog.append(data+"\n");
            }
        });
    }

    public void Send(String data) {
        try {
            int portNumber = 4000;
            Socket socket = new Socket("192.168.0.84", portNumber);
            printClientLog("소켓 연결함");
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            byte b = 0x15;
            outputStream.writeByte(b);
            outputStream.flush();
            printClientLog("데이터 전송함");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            Mat = inputStream.readLine();
            printClientLog("서버로부터 받음: "+Mat.split(",")[0]);


            if(Integer.parseInt(Mat.split(",")[0]) == 0){
                nemo1.setVisibility(View.INVISIBLE);
            }
            /*
            else if(Integer.parseInt(Mat.split(",")[0]) == 1){
                nemo1.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[0]) == 2){
                nemo1.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo1.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo2.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo2.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo2.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo2.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[2]) == 0){
                nemo3.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[2]) == 1){
                nemo3.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[2]) == 2){
                nemo3.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo3.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[3]) == 0){
                nemo4.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[3]) == 1){
                nemo4.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[3]) == 2){
                nemo4.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo4.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[4]) == 0){
                nemo5.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[4]) == 1){
                nemo5.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[4]) == 2){
                nemo5.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo5.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[5]) == 0){
                nemo6.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[5]) == 1){
                nemo6.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[5]) == 2){
                nemo6.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo6.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[6]) == 0){
                nemo7.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[6]) == 1){
                nemo7.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[6]) == 2){
                nemo7.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo7.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[7]) == 0){
                nemo8.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[7]) == 1){
                nemo8.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[7]) == 2){
                nemo8.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo8.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[8]) == 0){
                nemo9.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[8]) == 1){
                nemo9.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[8]) == 2){
                nemo9.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo9.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo10.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo10.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo10.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo10.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo11.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo11.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo11.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo11.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo12.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo12.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo12.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo12.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo13.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo13.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo13.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo13.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo14.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo14.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo14.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo14.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo15.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                nemo15.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                nemo15.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                nemo15.setBackground(Drawable.createFromPath("#80E60C0C"));


            if(Integer.parseInt(Mat.split(",")[1]) == 0){
                nemo15.setVisibility(View.INVISIBLE);
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 1){
                img1.setBackground(Drawable.createFromPath("#80FAED01"));
            }
            else if(Integer.parseInt(Mat.split(",")[1]) == 2){
                img1.setBackground(Drawable.createFromPath("#80FC5D00"));
            }
            else
                img1.setBackground(Drawable.createFromPath("#80E60C0C"));

*/

            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}