package id.sch.smktelkom_mlg.learn.homeworksreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        setTitle("Add Subject");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
