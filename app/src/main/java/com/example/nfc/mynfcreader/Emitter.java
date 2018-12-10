package com.example.nfc.mynfcreader;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class Emitter extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emitter);
        String flyby = getString(R.string.Write);
        String tiptap = getString(R.string.type);
   /*     if (flyby != null && tiptap != null) {
            NdefMessage yumyum = createTextMessage(flyby);
            createUriMessage(flyby, tiptap);
        }*/
    }
    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText flyby = (EditText) findViewById(R.id.textView);
        String flymessage = flyby.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/

    public NdefMessage createUriMessage(View pushButton) {
        while (true) {
            NdefRecord record = NdefRecord.createUri(1 + "123456789");
            NdefMessage msg = new NdefMessage(new NdefRecord[]{record});
            return msg;
        }
    } 

    public NdefMessage createTextMessage(String content) {
        try {
            // Get UTF-8 byte
            byte[] lang = Locale.getDefault().getLanguage().getBytes("UTF-8");
            byte[] text = content.getBytes("UTF-8"); // Content in UTF-8

            int langSize = lang.length;
            int textLength = text.length;

            ByteArrayOutputStream payload = new ByteArrayOutputStream(1 + langSize + textLength);
            payload.write((byte) (langSize & 0x1F));
            payload.write(lang, 0, langSize);
            payload.write(text, 0, textLength);
            NdefRecord record = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                    NdefRecord.RTD_TEXT, new byte[0],
                    payload.toByteArray());
            return new NdefMessage(new NdefRecord[]{record});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
