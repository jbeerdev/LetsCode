package lets.code.project.background;

import lets.code.project.conectividad.ConectivityClass;
import android.os.AsyncTask;

public class MyBackgroundProcess extends AsyncTask<Integer, Boolean, String> {

	@Override
	protected String doInBackground(Integer... params) {	
		System.out.println("Esto es lo que se ejecuta en segundo plano ");
		return ConectivityClass.getHTMLPage();
	}

	@Override
	protected void onPostExecute(String result) {
		System.out.println("Esto se llama después de ejecutarse el proceso " + result);
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		System.out.println("Esto se llama antes de ejecutarse el proceso");
		super.onPreExecute();
	}
	
	

}
