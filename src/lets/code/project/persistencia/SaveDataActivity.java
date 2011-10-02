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
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaveDataActivity extends Activity {
	
	TableManager mDbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_form);
		mDbHelper = new TableManager(this);
        
        ((Button)findViewById(R.id.save)).setOnClickListener(saveClickListener);

	}
	
	OnClickListener saveClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			String alumnoNombre = ((EditText)findViewById(R.id.input)).getText().toString();	
			if(mDbHelper.createAlumno(alumnoNombre)!=-1){
				Toast.makeText(SaveDataActivity.this, "Alumno guardado con éxito", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(SaveDataActivity.this, "Fallo al guardar alumno", Toast.LENGTH_LONG).show();
			}
			
		}
	};

}
