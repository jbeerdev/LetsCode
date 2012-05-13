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

import lets.code.project.background.ServiceActivity;
import lets.code.project.background.WebServiceBackgroundActivity;
import lets.code.project.conectividad.ConectivityMenu;
import lets.code.project.conectividad.MyWifiManager;
import lets.code.project.conectividad.WebServiceActivity;
import lets.code.project.intents.IntentActivity;
import lets.code.project.multimedia.CameraIntent;
import lets.code.project.persistencia.ContactsActivity;
import lets.code.project.persistencia.PreferencesActivity;
import lets.code.project.persistencia.SaveDataActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		findViewById(R.id.persistencia).setOnClickListener(persistenciaClikListener);
		findViewById(R.id.intents).setOnClickListener(intentsClickListener);
		findViewById(R.id.preferencias).setOnClickListener(preferenciasClickListener);
		findViewById(R.id.contacts).setOnClickListener(contactsClickListener);
		findViewById(R.id.web_service).setOnClickListener(webServiceClickListener);
		findViewById(R.id.web_service_back).setOnClickListener(webServiceBackgroundClickListener);
		findViewById(R.id.custom).setOnClickListener(customViewClickListener);

		MyWifiManager.startWifiManager(this);


	}

	OnClickListener contactsClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,ContactsActivity.class);
			startActivity(intent);

		}
	};

	OnClickListener customViewClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,CustomViewActivity.class);
			startActivity(intent);

		}
	};


	public void formsClickListener(View v) {
		Intent intent = new Intent(MainMenu.this,FormActivity.class);
		startActivity(intent);

	}

	OnClickListener persistenciaClikListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,SaveDataActivity.class);
			startActivity(intent);

		}
	};

	OnClickListener intentsClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,IntentActivity.class);
			startActivity(intent);

		}
	};

	OnClickListener preferenciasClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,PreferencesActivity.class);
			startActivity(intent);
		}
	};


	public void flowClickListener(View v) {
		Intent intent = new Intent(MainMenu.this,FlowActivity.class);
		startActivity(intent);
	}


	OnClickListener webServiceClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,WebServiceActivity.class);
			startActivity(intent);
		}
	};

	OnClickListener webServiceBackgroundClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainMenu.this,WebServiceBackgroundActivity.class);
			startActivity(intent);
		}
	};


	public void conectivityActivity(View v) {
		Intent intent = new Intent(MainMenu.this,ConectivityMenu.class);
		startActivity(intent);
	}

	public void servicesActivity(View v) {
		Intent intent = new Intent(MainMenu.this,ServiceActivity.class);
		startActivity(intent);
	}
	
	public void camaraIntent(View v) {
		Intent intent = new Intent(MainMenu.this,CameraIntent.class);
		startActivity(intent);
	}


}
