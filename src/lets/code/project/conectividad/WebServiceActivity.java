/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.conectividad;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lets.code.project.R;
import lets.code.project.base.Alertas;
import lets.code.project.base.AlertasAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

public class WebServiceActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertas_list);

		WebService webService = new WebService("http://www.sumasoftware.com/alerts/GetAlerts.php");
		Map<String, String> params = new HashMap<String, String>();
		params.put("var", "");

		String response = webService.webGet("", params);

		try
		{
			Type collectionType = new TypeToken<List<Alertas>>(){}.getType();
			List<Alertas> alertas = new Gson().fromJson(response, collectionType);

			AlertasAdapter ad = new AlertasAdapter(this, alertas);
			this.setListAdapter(ad);		

		}
		catch(Exception e)
		{
			Log.d("Error: ", e.getMessage());
		}
	}

}


