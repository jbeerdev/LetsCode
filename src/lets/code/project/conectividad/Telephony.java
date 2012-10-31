package lets.code.project.conectividad;

import android.content.Context;
import android.telephony.TelephonyManager;

public class Telephony {


	/* How to check if we are in roaming*/
	public static boolean isRoaming(Context context){
		TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);  
		return telephony.isNetworkRoaming();
	}
	
}
