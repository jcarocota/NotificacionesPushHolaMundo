package com.ebc.notificacionespushholamundo

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

import android.graphics.Bitmap
import android.graphics.BitmapFactory

class NotificacionService(private  val context: Context) {
    private val ID_MAIN_CHANNEL = "1234"

    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun lanzarNotificacionBasica() {
        val notificacion = NotificationCompat.Builder(context, ID_MAIN_CHANNEL)
            .setContentTitle("Notificación básica")
            .setContentText("Cuerpo de la notificacion")
            .setSmallIcon(R.drawable.happy_face)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notificacion
        )
    }

    fun  lanzarNotificacionGrande() {
        val notificacion = NotificationCompat.Builder(context, ID_MAIN_CHANNEL)
            .setContentTitle("Notificación grande")
            .setContentText("Esta es un anotificación grande")
            .setSmallIcon(R.drawable.happy_face)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat
                    .BigTextStyle()
                    .bigText("Este es el Texto Grande!!! Muy grande!!")
                    .setBigContentTitle("¡Noti XL!")
                    .setSummaryText("Toca para más...")
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notificacion
        )
    }

    fun lanzarNotificacionImagen() {
        val imagen = BitmapFactory.decodeResource(context.resources, R.drawable.gato)
        val notificacion = NotificationCompat.Builder(context, ID_MAIN_CHANNEL)
            .setContentTitle("Notificación imagen")
            .setContentText("Imagen del Maxi")
            .setSmallIcon(R.drawable.gato)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setLargeIcon(imagen)
            .setStyle(
                NotificationCompat
                    .BigPictureStyle()
                    .bigPicture(imagen)
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notificacion
        )
    }

}