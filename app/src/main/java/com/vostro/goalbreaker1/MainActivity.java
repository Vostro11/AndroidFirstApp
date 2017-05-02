package com.vostro.goalbreaker1;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button submit;
        final EditText website,password;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        submit = (Button)findViewById(R.id.button);
        website = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);

        submit.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        FileOutputStream fos = null;

//                        Toast.makeText(MainActivity.this, website.getText().toString()+password.getText().toString(), Toast.LENGTH_SHORT).show();
                        String filename = "thisApp.txt";

                        try {
                            File myFile = new File("/sdcard/mysdfile.txt");
                            myFile.createNewFile();
                            FileOutputStream fOut = new FileOutputStream(myFile);
                            OutputStreamWriter myOutWriter =
                                    new OutputStreamWriter(fOut);
                            myOutWriter.append(website.getText());
                            myOutWriter.append("\n" + password.getText());
                            myOutWriter.close();
                            fOut.close();
                            Toast.makeText(getBaseContext(),
                                    "Done writing SD 'mysdfile.txt'",
                                    Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Toast.makeText(getBaseContext(), e.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


}
