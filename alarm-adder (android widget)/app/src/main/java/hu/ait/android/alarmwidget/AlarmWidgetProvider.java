package hu.ait.android.alarmwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.RemoteViews;

public class AlarmWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];

            Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.alarm_widget_layout);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, alarmIntent, 0);
            remoteViews.setOnClickPendingIntent(R.id.btnAddAlarm, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

}