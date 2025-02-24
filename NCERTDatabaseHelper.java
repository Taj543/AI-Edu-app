import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NCERTDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ncert.db";
    private static final int DATABASE_VERSION = 1;

    public NCERTDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE explanations (id INTEGER PRIMARY KEY, line TEXT, explanation TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS explanations");
        onCreate(db);
    }
}