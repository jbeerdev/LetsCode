/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project;

import android.app.Activity;
import android.os.Bundle;

public class FlowActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("OnCreate");
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onRestart() {
		System.out.println("OnRestart");
		super.onRestart();
	}
	
	@Override
	protected void onDestroy() {
		System.out.println("OnDestroy");
		super.onDestroy();
	}
	
	@Override
	protected void onStop() {
		System.out.println("OnStop");
		super.onStop();
	}
	
	@Override
	protected void onResume() {
		System.out.println("OnResume");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		System.out.println("OnPause");
		super.onPause();
	}

}
