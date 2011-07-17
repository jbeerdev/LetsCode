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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import lets.code.project.R;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class StorageClass {


	public static void saveInternalFile(String fileName, Context context){
		String string = "hello world!";

		FileOutputStream fos;
		try {
			fos = context.openFileOutput(fileName, Context.MODE_APPEND);
			fos.write(string.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getInternalFile(String fileName, Context context){
		String string = "";

		FileInputStream fin;
		try {
			fin = context.openFileInput(fileName);
			byte [] InBuf = new byte[fin.available()];
			fin.read(InBuf); 
			string = new String(InBuf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return string;

	}


	public static void checkExternalStorageStatus(){


		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			/*Hacer lo que sea correspondiente. Está montada!*/
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			/*Está montada en modo lectura sólo*/
		} else if (Environment.MEDIA_REMOVED.equals(state)) {
			/*La unidad ha sido extraida*/
		} else if (Environment.MEDIA_UNMOUNTED.equals(state)) {
			/*La unidad no está montada*/
		}

	}
	
	public static void createExternalStoragePrivateFile(Context context) {
	    File file = new File("/mnt/sdcard", "androidIcon.png");
	    try {
	        InputStream is = context.getResources().openRawResource(R.drawable.icon);
	        OutputStream os = new FileOutputStream(file);
	        byte[] data = new byte[is.available()];
	        is.read(data);
	        os.write(data);
	        is.close();
	        os.close();
	    } catch (IOException e) {
	        Log.w("ExternalStorage", "Error writing " + file, e);
	    }
	}

	

}
