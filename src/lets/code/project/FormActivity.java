package lets.code.project;

import lets.code.project.background.MyBackgroundProcess;
import lets.code.project.persistencia.PreferencesActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

		iniElements();
		generateSpinnerValues();
		
		MyBackgroundProcess myProcess = new MyBackgroundProcess();
		myProcess.execute(10);

	}

	private void iniElements() {
		sendButton = (Button)findViewById(R.id.button);
		spinner = (Spinner) findViewById(R.id.spinner);
		editText = (EditText) findViewById(R.id.nameInput);
		findViewById(R.id.radio_hombre).setOnClickListener(radioClickListener);
		findViewById(R.id.radio_mujer).setOnClickListener(radioClickListener);
		sendButton.setOnClickListener(clickListener);
	}

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
}


