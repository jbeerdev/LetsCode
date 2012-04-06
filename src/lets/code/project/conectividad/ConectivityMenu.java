package lets.code.project.conectividad;

import lets.code.project.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConectivityMenu extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conectivitymenu);
	}
	
	
	public void conectivityManager(View v) {
		Intent intent = new Intent(ConectivityMenu.this,NetworkConectivityActivity.class);
		startActivity(intent);
	}

}
