package lets.code.project.intents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
	public static final String CUSTOM_INTENT = "lets.code.intent.action.NOW";


	@Override
	public void onReceive(Context arg0, Intent intent) {
		if(intent.getAction().equals(CUSTOM_INTENT))	
			Toast.makeText(arg0, "EY! Algo ha cambiado!!", Toast.LENGTH_LONG).show();
	}

}
