package com.example.kalyan.timetable;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import static android.widget.Toast.LENGTH_SHORT;

public class Poll extends AppCompatActivity {
    EditText polltitle;
    Button startbutton;
    Button endbutton;

    FloatingActionButton fab = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        polltitle=(EditText)findViewById(R.id.polltitle);
        startbutton=(Button) findViewById(R.id.startpoll);
        endbutton=(Button)findViewById(R.id.endpoll);

        fab = (FloatingActionButton) findViewById(R.id.fabpoll);
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Poll.this,"Polling Started",Toast.LENGTH_SHORT).show();
            }
        });

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Poll.this,"Polling Ended",Toast.LENGTH_SHORT).show();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder a_builder = new AlertDialog.Builder(Poll.this);
                a_builder.setMessage(polltitle.getText().toString())
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Poll.this,"Your Poll has been counted",LENGTH_SHORT).show();
                                finish();
                                Intent intent = new Intent(Poll.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(Poll.this,"Your Poll has been counted",LENGTH_SHORT).show();
                                finish();
                                Intent intent = new Intent(Poll.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.show();
            }
        });
    }


}
