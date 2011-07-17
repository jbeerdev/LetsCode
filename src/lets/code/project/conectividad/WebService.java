package lets.code.project.conectividad;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;

public class WebService extends BasicWebService{

	public WebService(String serviceName){
		super(serviceName);
	}
	
	public String webInvoke(String methodName, Map<String, Object> params) {

		JSONObject jsonObject = new JSONObject();

		for (Map.Entry<String, Object> param : params.entrySet()){
			try {
				jsonObject.put(param.getKey(), param.getValue());
			}
			catch (JSONException e) {
				Log.e("WebService", "JSONException : "+e);
			}
		}
		return webInvoke(methodName,  jsonObject.toString(), "application/json");
	}

	private String webInvoke(String methodName, String data, String contentType) {
		super.returnedValue = null;

		httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2109);

		httpPost = new HttpPost(webServiceUrl + methodName);
		response = null;

		StringEntity tmp = null;        

		httpPost.setHeader("Accept",
		"text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");

		if (contentType != null) {
			httpPost.setHeader("Content-Type", contentType);
		} else {
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		}

		try {
			tmp = new StringEntity(data,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			Log.e("WebService", "HttpUtils : UnsupportedEncodingException : "+e);
		}

		httpPost.setEntity(tmp);

		Log.d("WebService", webServiceUrl + "?" + data);

		try {
			response = httpClient.execute(httpPost,localContext);

			if (response != null) {
				returnedValue = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			Log.e("WebService", "HttpUtils: " + e);
		}

		return returnedValue;
	}



	public static JSONObject Object(Object o){
		try {
			return new JSONObject(new Gson().toJson(o));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public InputStream getHttpStream(String urlString) throws IOException {
		InputStream in = null;
		int response = -1;

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();

		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try{
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect(); 

			response = httpConn.getResponseCode();                 

			if (response == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream();
			}
		} catch (Exception e) {
			throw new IOException("Error connecting");
		} // end try-catch

		return in;
	}

	public void clearCookies() {
		httpClient.getCookieStore().clear();
	}

	public void abort() {
		try {
			if (httpClient != null) {
				System.out.println("Abort.");
				httpPost.abort();
			}
		} catch (Exception e) {
			System.out.println("Un fallo reportado aquí" + e);
		}
	}
}