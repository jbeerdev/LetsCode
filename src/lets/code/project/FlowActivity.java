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
