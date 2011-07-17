package lets.code.project.conectividad;

import android.content.Context;
import android.net.wifi.WifiManager;

public class MyWifiManager {


	public static void startWifiManager(Context context){

		WifiManager wifi;
		wifi = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
		wifi.setWifiEnabled(true);
		

	}


}
