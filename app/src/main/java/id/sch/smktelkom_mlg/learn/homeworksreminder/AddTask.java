package id.sch.smktelkom_mlg.learn.homeworksreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {

    Button bsave, bcancel;
    EditText etName, etDate, etNotes, etrDate, etrTime;
    Spinner sspinner;
    TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setTitle("Add New Task");
        etName = (EditText) findViewById(R.id.taskname);
        etDate = (EditText) findViewById(R.id.duedate);
        etNotes = (EditText) findViewById(R.id.notes);
        etrDate = (EditText) findViewById(R.id.rdate);
        etrTime = (EditText) findViewById(R.id.rtime);
        sspinner = (Spinner) findViewById(R.id.spinner);
        tvhasil = (TextView) findViewById(R.id.textView10);

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvhasil.setText(etName.getText().toString() + " " + etDate.getText().toString() + " " + etNotes.getText().toString() + " " + etrDate.getText().toString()
                        + " " + etrTime.getText().toString());
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
}
