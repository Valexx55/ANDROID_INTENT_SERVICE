package com.example.formador.myintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this


    public MyIntentService() {
        super("MyIntentService");
    }

    private Bitmap getBitMap (String url)
    {
        Bitmap bitmap = null;
        InputStream is = null;
        HttpURLConnection httpURLConnection = null;
        URL url_net = null;
        int respuesta = -1;

        try{
            url_net = new URL(url);
            httpURLConnection = (HttpURLConnection)url_net.openConnection();

            respuesta = httpURLConnection.getResponseCode();
            if (respuesta == HttpURLConnection.HTTP_OK)
            {
                is = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            }

        }catch (Exception e)
        {
            Log.e(getClass().getCanonicalName(), "ERROR" , e);

        }finally {
            if (httpURLConnection != null)
            {
                httpURLConnection.disconnect();
            }
        }

        return bitmap;
    }

    private Bitmap comprimirFoto (Bitmap foto, int alto, int ancho)
    {
        return (Bitmap.createScaledBitmap(foto, ancho, alto, true));
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //aquí iniciamos el servicio
        Log.d(getClass().getCanonicalName(), "INICIANDO INTENT SERVICIO");

        //TODO HAGO EL SERIVCIO

        Bitmap foto = getBitMap("http://cdn.playbuzz.com/cdn/28f186e6-8922-4cb6-86e7-07d092ae1635/6afd84bd-bb61-484c-8265-dffbcdca6f00.jpg");

        Bitmap foto_reducida = comprimirFoto (foto, 300, 300);

        //INFORMO QUE HE ACABADO
        Intent intentfin = new Intent("IS_FIN");
        intentfin.putExtra("escudo", foto_reducida);



        sendBroadcast(intentfin);

    }




}
