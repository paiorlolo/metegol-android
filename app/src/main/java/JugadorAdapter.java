import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Paula on 19/06/2017.
 */

public class JugadorAdapter {
        private Context context;
        private DBHelper dbHelper;
        private static final String TABLE_NAME = "jugador";
        private static final String COLUMN_JUGADOR_NAME = "NOMBRE_JUGADOR";
        private static final String COLUMN_JUGADOR_PTS = "PUNTOS";

        private SQLiteDatabase db;

        public JugadorAdapter(Context context) {
            this.context = context;
        }

        public void abrir() {
            dbHelper = new DBHelper(context);
            db = dbHelper.getWritableDatabase();
        }

        public String monedaPorId(int id) {

            /**
             * public Cursor query (String table, String[] columns,
             *                      String selection, String[] selectionArgs,
             *                      String groupBy, String having, String orderBy)
             */

            Cursor c = db.query(TABLE_NAME, new String[]{COLUMN_JUGADOR_NAME, COLUMN_JUGADOR_PTS},
                    "id=?", new String[]{String.valueOf(id)},
                    null, null, COLUMN_JUGADOR_PTS);

            if (c.moveToFirst()) {
                int colIndex = c.getColumnIndex(COLUMN_JUGADOR_NAME);
                return c.getString(colIndex);
            } else {
                return null;
            }
        }

        public Float valorJugadorPorNombre(String nombre) {

            /**
             * public Cursor query (String table, String[] columns,
             *                      String selection, String[] selectionArgs,
             *                      String groupBy, String having, String orderBy)
             *
             *              SELECT currency_name FROM Currency WHERE name = "x" ORDER BY nombre
             */

            Cursor c = db.query(TABLE_NAME, new String[]{COLUMN_JUGADOR_PTS},
                    "NOMBRE_JUGADOR=?", new String[]{String.valueOf(nombre)},
                    null, null, null);

            if (c.moveToFirst()) {
                int colIndex = c.getColumnIndex(COLUMN_JUGADOR_PTS);
                return c.getFloat(colIndex);
            } else {
                return null;
            }
        }
        public Cursor todos() {

            /**
             *  public Cursor query (String table,
             *                      String[] columns,
             *                      String selection,
             *                      String[] selectionArgs,
             *                      String groupBy,
             *                      String having,
             *                      String orderBy)
             */

            return db.query(TABLE_NAME, new String[]{"id", COLUMN_JUGADOR_NAME, COLUMN_JUGADOR_PTS},
                    null, null, null, null, COLUMN_JUGADOR_NAME);
        }

        public void insertar(String nombre, Integer pts) {

            ContentValues valores = new ContentValues();

            valores.put(COLUMN_JUGADOR_NAME, nombre);
            valores.put(COLUMN_JUGADOR_PTS, pts);

            db.insert(TABLE_NAME, null, valores);
        }

        public void actualizar(int id, String nombre, Integer pts) {

            ContentValues valores = new ContentValues();
            valores.put(COLUMN_JUGADOR_NAME, nombre);
            valores.put(COLUMN_JUGADOR_PTS, pts);

            /**
             * public int update (String table,
             *                      ContentValues values,
             *                      String whereClause,
             *                      String[] whereArgs)
             */

            db.update(TABLE_NAME, valores, "ID=" + String.valueOf(id), null);
        }

        public void eliminar(int id) {
            db.delete(TABLE_NAME, "ID=?", new String[]{String.valueOf(id)});
        }

        public void cerrar() {
            dbHelper.close();
        }

}