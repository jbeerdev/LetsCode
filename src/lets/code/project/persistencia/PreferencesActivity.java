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

import lets.code.project.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class PreferencesActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.preference_screen);
		// Get the custom preference
		Preference customPref = (Preference) findPreference("customPref");
		customPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			public boolean onPreferenceClick(Preference preference) {
				Toast.makeText(getBaseContext(),"Preferencia Personalizada pulsada",Toast.LENGTH_LONG).show();
				SharedPreferences customSharedPreference = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
				SharedPreferences.Editor editor = customSharedPreference.edit();
				editor.putString("myCustomPref","click!");
				editor.commit();
				return true;
			}
		});
	}

	private void getPrefs() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean CheckboxPreference = prefs.getBoolean("checkboxPref", true);
		String ListPreference = prefs.getString("listPref", "USA");
		String editTextPreference = prefs.getString("editTextPref","Nada, todo vacio");
		String ringtonePreference = prefs.getString("ringtonePref","DEFAULT_RINGTONE_URI");
		String secondEditTextPreference = prefs.getString("SecondEditTextPref","Nada dentro");
		SharedPreferences mySharedPreferences = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
		String customPref = mySharedPreferences.getString("myCusomPref", "");
	}
}
