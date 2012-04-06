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

import lets.code.project.background.MyBackgroundProcess;
import lets.code.project.persistencia.PreferencesActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends Activity implements OnItemSelectedListener{

	private Button sendButton;
	private EditText editText;
	private Spinner spinner;
	private String country = "";
	private String sex = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		showNotificacion();
		LinearLayout miLayout = new LinearLayout(this);
		miLayout.setOrientation(LinearLayout.VERTICAL);

		iniElements();
		generateSpinnerValues();

		MyBackgroundProcess myProcess = new MyBackgroundProcess();
		myProcess.execute(10);

	}

	private void iniElements() {
		ImageView miImagen = (ImageView)findViewById(R.id.banner);
		miImagen.setImageResource(R.drawable.icon);


		sendButton = (Button)findViewById(R.id.button);
		spinner = (Spinner) findViewById(R.id.spinner);
		editText = (EditText) findViewById(R.id.nameInput);
		findViewById(R.id.radio_hombre).setOnClickListener(radioClickListener);
		findViewById(R.id.radio_mujer).setOnClickListener(radioClickListener);
		sendButton.setOnClickListener(clickListener);
		sendButton.setOnTouchListener(touchListener);
		sendButton.setOnLongClickListener(longClickListener);
	}

	private OnTouchListener touchListener = new OnTouchListener() {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction()==MotionEvent.ACTION_DOWN){
				//Hacer algo
			}
			return false;
		}
	};

	private OnLongClickListener longClickListener = new OnLongClickListener() {
		@Override
		public boolean onLongClick(View v) {
			return false;
		}
	};

	private OnClickListener radioClickListener = new OnClickListener() {
		public void onClick(View v) {
			RadioButton rb = (RadioButton) v;
			sex = (String) rb.getText();
		}
	};

	OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {


			Intent intent = new Intent(FormActivity.this.getApplication(), ShowInfoActivity.class);
			intent.putExtra("NAME", editText.getText().toString());
			intent.putExtra("COUNTRY", country);
			intent.putExtra("SEX", sex);
			startActivity(intent);

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem item = null;
		item = menu.add(this.getString(R.string.toast_help));
		item.setIcon(android.R.drawable.ic_menu_help);
		item = menu.add(this.getString(R.string.preferences));
		item.setIcon(android.R.drawable.ic_menu_preferences);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getTitle().equals(this.getString(R.string.toast_help))){
			Toast.makeText(this, "Texto de ayuda", Toast.LENGTH_LONG).show();
		}
		if(item.getTitle().equals(this.getString(R.string.preferences))){
			Intent settingsActivity = new Intent(getBaseContext(),PreferencesActivity.class);
			startActivity(settingsActivity);
		}
		return super.onMenuItemSelected(featureId, item);
	}

	private void generateSpinnerValues() {

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.array_ciudades, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}



	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int position,
			long arg3) {
		country = parent.getItemAtPosition(position).toString();

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		country = "Sin pais";
	}


	public void showDialog(){

		Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Título del Dialog");
		alert.setMessage("Mensaje del Dialog");
		alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Hacer algo cuando se pulsta el botón del dialog

			}
		});
		alert.show();


	}

	public void showProgressDialog(){

		ProgressDialog dialog = ProgressDialog.show(this, "", "Cargando datos", true);
		dialog.dismiss();
	}

	public void showToast(){

		Toast.makeText(this, "Base de datos actualizada!", Toast.LENGTH_LONG);
	}
	
	public void showNotificacion(){
		
		int NOTIFICATION_ID = 1;
		int iconToShowInNotification = R.drawable.icon;
		long timeInMilis = System.currentTimeMillis();
		CharSequence notificationMessage = "Esto se muestra al ser notificado!!";

		Intent notificationIntent = new Intent(this, FlowActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		
        NotificationManager notificationM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(iconToShowInNotification, notificationMessage, timeInMilis);	
        notification.setLatestEventInfo(this, "Titulo", "Esto es muestra al desplegar la barra", pendingIntent);
        notificationM.notify(NOTIFICATION_ID, notification);
		
	}


}


