package com.example.formador.myintentservice;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //public static ImageView escudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //escudo = (ImageView) findViewById(R.id.escudoatl);

        //PREPARO EL LISTENER DEL FIN DEL SERVICIO
        IntentFilter intentFilter = new IntentFilter("IS_FIN");
        BroadcastReceiver br = new DescargaReceiver(this);

        registerReceiver(br, intentFilter);

        //LANZAR EL SERVICIO
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    public void setEscudo (Bitmap bitmap)
    {
        ImageView imageView = (ImageView)findViewById(R.id.escudoatl);
        imageView.setImageBitmap(bitmap);
    }
}
