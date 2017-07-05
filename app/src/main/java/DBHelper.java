import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Paula on 19/06/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "exchange.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "jugador";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE_JUGADOR TEXT, PUNTOS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

