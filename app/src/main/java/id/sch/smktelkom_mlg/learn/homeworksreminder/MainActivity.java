package id.sch.smktelkom_mlg.learn.homeworksreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button button;
    DatePicker datePicker;
    Calendar calendar;
    TextView dateView, listsbj;
    int year, month, day;
    DB_Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddTask.class));
            }
        });

        findViewById(R.id.buttonaddsubject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddSubject.class));
            }
        });
        listsbj = (TextView) findViewById(R.id.listsbj);
        controller = new DB_Controller(this, "", null, 1);
    }

    public void listsbj(View view) {
        controller.listallsubject(listsbj);
    }
}
