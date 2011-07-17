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

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lets.code.project.base.Alertas;
import lets.code.project.conectividad.BasicWebService;
import android.os.AsyncTask;
import android.util.Log;


public class WebServiceAsyncTask extends AsyncTask<Object, Boolean, String> {

	WebServiceBackgroundActivity callerActivity;
	
	
	@Override
	protected String doInBackground(Object... params) {	
		String serviceUrl = (String) params[0];
		callerActivity = (WebServiceBackgroundActivity) params[1];
		
		BasicWebService webService = new BasicWebService(serviceUrl);
		Map<String, String> serviceParams = new HashMap<String, String>();
		serviceParams.put("var", "");	
		return webService.webGet("", serviceParams);
	}

	@Override
	protected void onPostExecute(String response) {
		try
		{
			Type collectionType = new TypeToken<List<Alertas>>(){}.getType();
			List<Alertas> alertas = new Gson().fromJson(response, collectionType);
			callerActivity.populateListWithAlerts(alertas);
		}
		catch(Exception e)
		{
			Log.d("Error: ", e.getMessage());
		}
		super.onPostExecute(response);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	

}
