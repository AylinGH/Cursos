package com.example.listawear;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.listawear.databinding.ActivityMainBinding;

public class CardActivity extends Activity {
    private TextView titulo;
    private TextView descripcion;
    private Button cerrar, ins;
    private ActivityMainBinding binding;
    private Intent intent;
    private PendingIntent pendingIntent;
    private NotificationCompat.Builder notificacion;
    private NotificationManagerCompat nm;
    private NotificationCompat.WearableExtender wearableExtender;
    String idChannel = "Mi_Canal";
    int idNotificacion = 001;

    private NotificationCompat.BigTextStyle bigTextStyle;

    String longText = "¡Te has inscrito al curso!";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

        titulo = (TextView) findViewById(R.id.txtTitulo);
        descripcion = (TextView) findViewById(R.id.txtDescripcion);
        cerrar = (Button) findViewById(R.id.btnCerrar);
        ins = (Button) findViewById(R.id.btnIns);
        intent = new Intent(CardActivity.this, MainActivity.class);

        nm = NotificationManagerCompat.from(CardActivity.this);

        wearableExtender = new NotificationCompat.WearableExtender();

        bigTextStyle = new NotificationCompat.BigTextStyle().bigText(longText);



        Bundle extras = getIntent().getExtras();
        if( extras != null){
            titulo.setText(extras.getString("titulo"));
            descripcion.setText(extras.getString("descripcion"));
        }

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                String name = "Notificación";

                NotificationChannel notificationChannel =
                        new NotificationChannel(idChannel, name, importance);

                nm.createNotificationChannel(notificationChannel);

                pendingIntent = PendingIntent.getActivity(CardActivity.this, 0, intent, 0);

                notificacion = new NotificationCompat.Builder(CardActivity.this, idChannel)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Cursos")
                        .setContentText(longText)
                        .setContentIntent(pendingIntent)
                        .extend(wearableExtender)
                        .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                        .setStyle(bigTextStyle);

                nm.notify(idNotificacion, notificacion.build());

            }
        });
    }

}
