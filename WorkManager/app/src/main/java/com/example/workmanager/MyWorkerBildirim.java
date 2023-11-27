package com.example.workmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorkerBildirim extends Worker {
    public MyWorkerBildirim(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        bildirimGoster();
        return Result.success();
    }

    private void bildirimGoster() {
        NotificationCompat.Builder builder;
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,intent,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("id");
            if (notificationChannel == null){
                notificationChannel = new NotificationChannel("id","ad",NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            builder = new NotificationCompat.Builder(getApplicationContext(),"id");
            builder.setContentTitle("Başlık")
                    .setContentText("icerik")
                    .setSmallIcon(R.drawable.bildirim)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent);
        }else {
            builder = new NotificationCompat.Builder(getApplicationContext());
            builder.setContentTitle("Başlık")
                    .setContentText("icerik")
                    .setSmallIcon(R.drawable.bildirim)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setPriority(Notification.PRIORITY_HIGH);
        }
        notificationManager.notify(10,builder.build());
    }

}
