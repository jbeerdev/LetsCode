package lets.code.project.background;

import lets.code.project.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends Activity{
	private static final String TAG = "Let's Code";
	Button buttonStart;
	Button buttonStop;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_layout);
	}

	public void startService(View view){
		Log.d(TAG, "onClick: starting Service");
		startService(new Intent(this, MyService.class));
	}

	public void stopService(View view){
		Log.d(TAG, "onClick: stopping Service");
		stopService(new Intent(this, MyService.class));
	}

}