package com.example.android.sunshine.app.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CastformSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static CastformSyncAdapter sCastformSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("CastformSyncService", "onCreate - CastformSyncService");
        synchronized (sSyncAdapterLock) {
            if (sCastformSyncAdapter == null) {
                sCastformSyncAdapter = new CastformSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sCastformSyncAdapter.getSyncAdapterBinder();
    }
}