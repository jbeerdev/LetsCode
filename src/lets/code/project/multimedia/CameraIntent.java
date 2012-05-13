package lets.code.project.multimedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;



public class CameraIntent extends Activity{

	private static final int TAKE_PHOTO_REQUEST_CODE = 100;



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, TAKE_PHOTO_REQUEST_CODE);
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == TAKE_PHOTO_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
				Toast.makeText(this, "Foto guardada en:\n" +
						data.getData(), Toast.LENGTH_LONG).show();
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(this, "Foto cancelada", Toast.LENGTH_LONG).show();
			} 
			finish();
		}

	}

}
