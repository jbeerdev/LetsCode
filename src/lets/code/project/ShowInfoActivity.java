package lets.code.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInfoActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_info);
		Bundle extras = getIntent().getExtras();
		String name = extras.getString("NAME");
		
		
		((TextView) findViewById(R.id.nameLabel)).setText(extras.getString("NAME"));
		((TextView) findViewById(R.id.sexLabel)).setText(extras.getString("SEX"));
		((TextView) findViewById(R.id.countryLabel)).setText(extras.getString("COUNTRY"));
	}
	
	

}
