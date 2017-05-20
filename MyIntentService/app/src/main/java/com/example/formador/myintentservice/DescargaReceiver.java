package com.example.formador.myintentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

public class DescargaReceiver extends BroadcastReceiver {

    private Context contexto;

    public DescargaReceiver (Context ma)
    {
        this.contexto = ma;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d(getClass().getCanonicalName(), "IS FINALIZADO");

        Bitmap escudo = (Bitmap)intent.getParcelableExtra("escudo");



        if (this.contexto instanceof MainActivity)
        {
            MainActivity ma = (MainActivity)this.contexto;
            ma.setEscudo(escudo);
        }

    }
}
