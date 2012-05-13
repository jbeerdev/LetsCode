package lets.code.project.conectividad;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

public class NetworkConectivityActivity extends Activity{

	ConnectivityManager conectivityManager;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		conectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		
		NetworkInfo[] arrayNetwork = conectivityManager.getAllNetworkInfo();
		
		for(NetworkInfo network : arrayNetwork){
			System.out.println("NetworkStatus"+network.toString());
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
