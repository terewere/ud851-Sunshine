package com.example.sourcecodegh.autosms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

      try {
          if (bundle !=null) {

              Object[] pduses = (Object[]) bundle.get("pdus");

              if (pduses != null) {
                  for (Object pduse : pduses) {
                      SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pduse);

                      String body = smsMessage.getDisplayMessageBody();
                      String number = smsMessage.getDisplayOriginatingAddress();

                      try {
                          if (number.equals("222")) {
                              String sms = body.substring(13, body.length()-36);

                              Intent optIntent = new Intent("OTP_FILTER");
                              optIntent.putExtra("otp", sms);

                              //Broadcast the token
                              context.sendBroadcast(optIntent);
                          }
                      } catch (Exception e) {
                          Log.d("error", e.getMessage());
                      }
                  }
              }
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(number, null,"Gracios por el servicio", null, null);
          }

      } catch (Exception e) {
          Log.e("error", e.getMessage());
      }

    }
}
