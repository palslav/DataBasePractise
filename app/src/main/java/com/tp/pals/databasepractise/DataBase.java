package com.tp.pals.databasepractise;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pallav.choudhary on 07-07-2017.
 */

public class DataBase extends AppCompatActivity{

    private TextView emp_dbView;

    DatabaseActivity dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_main);

        emp_dbView = (TextView) findViewById(R.id.tv_db);
        emp_dbView.setMovementMethod(new ScrollingMovementMethod());

        dbHandler = new DatabaseActivity(this, null, null, 1);

        emp_dbView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                onEmpDBClicked();
                return true;
            }
        });
        printDatabase();
    }

    private void printDatabase() {
        String dbString = dbHandler.databasetoString();
        emp_dbView.setText(dbString);
    }

    private void onEmpDBClicked() {
        ClipboardManager cManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData cData = android.content.ClipData.newPlainText("text", emp_dbView.getText().toString());
        cManager.setPrimaryClip(cData);
        //Util.toast(mContext, string.text_copyed);
        //emp_dbview.setTextIsSelectable(true);
        //emp_dbview.setFocusable(true);
        //emp_dbview.setFocusableInTouchMode(true);

        /*String emp_data = emp_dbView.getText().toString();
        int startIndex = emp_dbView.getSelectionStart();
        int endIndex = emp_dbView.getSelectionEnd();

        int min = 0;
        int max = emp_dbView.getText().length();
        min = Math.max(0, Math.min(startIndex, endIndex));
        max = Math.max(0, Math.max(startIndex, endIndex));

        emp_data = emp_data.substring(min, max);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Plain Text", emp_data);
        clipboard.setPrimaryClip(clip);*/
    }
}
