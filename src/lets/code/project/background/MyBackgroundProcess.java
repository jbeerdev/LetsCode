/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.background;

import lets.code.project.conectividad.ConectivityClass;
import android.os.AsyncTask;

public class MyBackgroundProcess extends AsyncTask<Integer, Boolean, String> {

	@Override
	protected String doInBackground(Integer... params) {	
		System.out.println("Esto es lo que se ejecuta en segundo plano ");
		return ConectivityClass.getHTMLPage();
	}

	@Override
	protected void onPostExecute(String result) {
		System.out.println("Esto se llama después de ejecutarse el proceso " + result);
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		System.out.println("Esto se llama antes de ejecutarse el proceso");
		super.onPreExecute();
	}
	
	

}
