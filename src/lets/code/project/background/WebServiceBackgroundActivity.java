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

import java.util.List;

import lets.code.project.R;
import lets.code.project.base.Alertas;
import lets.code.project.base.AlertasAdapter;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

public class WebServiceBackgroundActivity extends ListActivity{

	private static final String WEB_SERVICE_URL = "http://barrapunto.com/index.xml";
	ProgressDialog dialog;
	TextView rssText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertas_list);
		rssText = (TextView) findViewById(R.id.rss_text);
		initializeDialog();
		startWebServiceTask();
		
	}

	private void startWebServiceTask() {
		WebServiceAsyncTask webServiceTask = new WebServiceAsyncTask();
		webServiceTask.execute(WEB_SERVICE_URL,this);
	}

	private void initializeDialog() {
		dialog = ProgressDialog.show(WebServiceBackgroundActivity.this, "", "Cargando Datos. Espere...", true);
		dialog.show();
	}
	
	public void populateListWithAlerts(List<Alertas> alertList){
		AlertasAdapter ad = new AlertasAdapter(this, alertList);
		this.setListAdapter(ad);	
		dialog.dismiss();
	}
	
	public void printResult(String result){
		rssText.setText(result);
		dialog.dismiss();
	}

}


