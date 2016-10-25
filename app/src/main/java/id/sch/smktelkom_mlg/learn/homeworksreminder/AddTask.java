package id.sch.smktelkom_mlg.learn.homeworksreminder;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddTask extends AppCompatActivity implements View.OnClickListener {

    Button bsave, bcancel, btnrDate, btnrTime;
    EditText etName, etDate, etNotes, etrDate, etrTime;
    Spinner sspinner;
    TextView tvhasil;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setTitle("Add New Task");
        etName = (EditText) findViewById(R.id.taskname);
        etDate = (EditText) findViewById(R.id.duedate);
        etNotes = (EditText) findViewById(R.id.notes);
        etrDate = (EditText) findViewById(R.id.rDate);
        etrTime = (EditText) findViewById(R.id.rTime);
        sspinner = (Spinner) findViewById(R.id.spinner);
        tvhasil = (TextView) findViewById(R.id.textView10);
        btnrDate = (Button) findViewById(R.id.btnDateReminder);
        btnrTime = (Button) findViewById(R.id.btnTimeReminder);

        btnrDate.setOnClickListener(this);
        btnrTime.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v == btnrDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    etrDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        if (v == btnrTime) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            etrTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
