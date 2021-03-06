package id.sch.smktelkom_mlg.learn.homeworksreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddSubject extends AppCompatActivity {

    EditText etSubject, etTeacher;
    Button buttonSave;
    TextView tvhasil;
    DB_Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        setTitle("Add Subject");

        etSubject = (EditText) findViewById(R.id.editTextSubject);
        etTeacher = (EditText) findViewById(R.id.editTextTeacher);
        tvhasil = (TextView) findViewById(R.id.tvHasil);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        controller = new DB_Controller(this, "", null, 1);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button OK KLIK!
                if (etSubject.getText().toString().isEmpty()) {
                    etSubject.setError("Subject is empty!");
                } else if (etTeacher.getText().toString().isEmpty()) {
                    etTeacher.setError("Teacher is empty!");
                } else {
                    doKlik();
                    Toast.makeText(getApplicationContext(), "Subject has been added", Toast.LENGTH_LONG).show();
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void doKlik() {
        controller.insert_subject(etSubject.getText().toString(), etTeacher.getText().toString());
    }

}
