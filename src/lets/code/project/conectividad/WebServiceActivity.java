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


