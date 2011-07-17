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
	
	DataBaseExample mDbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_form);
		mDbHelper = new DataBaseExample(this);
        mDbHelper.open();
        
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
