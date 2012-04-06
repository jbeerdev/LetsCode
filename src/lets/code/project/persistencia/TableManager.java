/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TableManager {

	public static final String KEY_NAME = "name";
	public static final String KEY_ROWID = "_id";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	/**
	 * Database creation sql statement
	 */
	public static final String DATABASE_CREATE =
		"create table alumnos (_id integer primary key autoincrement, "
		+ "name text not null);";

	
	private static final String DATABASE_TABLE = "alumnos";
	

	private final Context mCtx;


	public TableManager(Context ctx) {
		this.mCtx = ctx;
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
	}


	public void close() {
		mDbHelper.close();
	}
	


	public long createAlumno(String title) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, title);
		return mDb.insert(DATABASE_TABLE, null, initialValues);
	}

	public boolean deleteAlumno(long rowId) {

		return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	public Cursor fetchAllAlumnos() {
		return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME}, null, null, null, null, null);
	}

	public Cursor fetchAlumno(long rowId) throws SQLException {

		Cursor mCursor = mDb.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
					KEY_NAME}, KEY_ROWID + "=" + rowId, null,
					null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	public boolean updateAlumno(long rowId, String title) {
		ContentValues args = new ContentValues();
		args.put(KEY_NAME, title);
		return mDb.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}

