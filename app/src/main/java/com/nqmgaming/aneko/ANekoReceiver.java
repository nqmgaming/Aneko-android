package com.nqmgaming.aneko;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Objects;

public class ANekoReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_PACKAGE_REPLACED.equals(intent.getAction())) {
            String pkg = Objects.requireNonNull(intent.getData()).getEncodedSchemeSpecificPart();
            if (!context.getPackageName().equals(pkg)) {
                return;
            }
        }

        context.startService(new Intent(context, AnimationService.class)
                .setAction(AnimationService.ACTION_START));
    }
}
