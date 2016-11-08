package id.sch.smktelkom_mlg.learn.homeworksreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by Dwi Enggar on 07/11/2016.
 */

public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TASK.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TASK (IDTASK INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TASKNAME TEXT UNIQUE, IDSUBJECT INTEGER, DUEDATE TEXT, NOTES TEXT, RDATE TEXT, RTIME TEXT)");
        db.execSQL("CREATE TABLE SUBJECT (IDSUBJECT INTEGER PRIMARY KEY AUTOINCREMENT, SUBJECT TEXT UNIQUE, TEACHER TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TASK");
        db.execSQL("DROP TABLE IF EXISTS SUBJECT");
        onCreate(db);
    }

    public void insert_task(String taskname, int idsubject, String duedate, String notes, String rdate, String rtime) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TASKNAME", taskname);
        contentValues.put("IDSUBJECT", idsubject);
        contentValues.put("DUEDATE", duedate);
        contentValues.put("NOTES", notes);
        contentValues.put("RDATE", rdate);
        contentValues.put("RTIME", rtime);
        this.getWritableDatabase().insertOrThrow("TASK", "", contentValues);
    }

    public void insert_subject(String subject, String teacher) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("SUBJECT", subject);
        contentValues.put("TEACHER", teacher);
        this.getWritableDatabase().insertOrThrow("SUBJECT", "", contentValues);
    }

    public void delete_task(String taskname) {
        this.getWritableDatabase().delete("TASK", "TASKNAME = '" + taskname + "'", null);
    }

    public void update_task(String taskname_old, int idsubject_new, String taskname_new, String duedate_new, String notes_new,
                            String rdate_new, String rtime_new) {
        this.getWritableDatabase().execSQL("UPDATE TASK SET TASKNAME = '" + taskname_new + "', IDSUBJECT = " + idsubject_new + ", DUEDATE = '" + duedate_new + "', NOTES = '" + notes_new
                + "', RDATE = '" + rdate_new + "', RTIME = '" + rtime_new + "' WHERE TASKNAME = '" + taskname_old + "'");
    }

    public void listalltask(TextView textView) {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM TASK", null);
        textView.setText("");
        while (cursor.moveToNext()) {
            textView.append(cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3) + " " + cursor.getString(4)
                    + " " + cursor.getString(5));
        }
    }

    public void listallsubject(TextView textView) {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM SUBJECT", null);
        textView.setText("");
        while (cursor.moveToNext()) {
            textView.append(cursor.getString(1) + " " + cursor.getString(2));
        }
    }

}
