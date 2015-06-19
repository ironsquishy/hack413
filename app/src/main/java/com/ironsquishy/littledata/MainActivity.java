package com.ironsquishy.littledata;

import android.support.v7.app.ActionBarActivity;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ironsquishy.sqlitehandlermod.EntryField;
import com.ironsquishy.sqlitehandlermod.SQLDBHandlers;


public class MainActivity extends ActionBarActivity {

    EditText inText;
    TextView outText;
    SQLDBHandlers dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inText = (EditText) findViewById(R.id.editText);

        outText = (TextView) findViewById(R.id.outputText);
        dbHandler = new SQLDBHandlers(this, null, null, 1);
        printDatabase();
    }

    //When add is clicked

    public void addButton(View view)
    {
        EntryField entry = new EntryField(inText.getText().toString());
        dbHandler.addEntry(entry);
        printDatabase();
    }

    public void deleteButton(View view)
    {
        String text = inText.getText().toString();
        dbHandler.deleteEntry(text);
        printDatabase();
    }



    private void printDatabase() {
        String dbString = dbHandler.databaseToString();
        outText.setText(dbString);
        inText.setText("");
    }


}
