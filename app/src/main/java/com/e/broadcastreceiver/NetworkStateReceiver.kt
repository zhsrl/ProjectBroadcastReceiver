package com.e.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.telecom.Connection
import android.widget.Toast

class NetworkStateReceiver: BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        if(p1!!.action == WifiManager.WIFI_STATE_CHANGED_ACTION || p1.action == WifiManager.NETWORK_STATE_CHANGED_ACTION){
            Toast.makeText(p0, "WiFi or Mobile Network states changed", Toast.LENGTH_LONG).show()
        }
    }
}