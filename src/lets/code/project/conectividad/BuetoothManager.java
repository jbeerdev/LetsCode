package lets.code.project.conectividad;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

public class BuetoothManager {



	public static void startBluetooth(){
		try{
			BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
			btAdapter.enable();
		}catch(NullPointerException ex){
			Log.e("Bluetooth","Device not avaliable");
		}
	}

	public static void stopBluetooth(){

		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
		btAdapter.disable();
	}

	public static boolean isBluetoothEnabled(){
		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
		return btAdapter.isEnabled();
	}

}
