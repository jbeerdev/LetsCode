package lets.code.project.conectividad;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class NetworkConectivityActivity extends Activity{

	ConnectivityManager conectivityManager;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		conectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		
		System.out.println("NetworkStatus"+conectivityManager.getActiveNetworkInfo().toString());
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
