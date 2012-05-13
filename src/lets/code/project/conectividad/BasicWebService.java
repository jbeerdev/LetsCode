/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.conectividad;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class BasicWebService{

	DefaultHttpClient httpClient;
	HttpContext localContext;
	String returnedValue;

	HttpResponse response = null;
	HttpPost httpPost = null;
	HttpGet httpGet = null;
	String webServiceUrl;

	public BasicWebService(String serviceName){
		HttpParams myParams = new BasicHttpParams();

		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		HttpConnectionParams.setSoTimeout(myParams, 10000);
		httpClient = new DefaultHttpClient(myParams);
		localContext = new BasicHttpContext();
		webServiceUrl = serviceName;

	}

	public String webGet(String methodName, Map<String, String> params) {
		String getUrl = webServiceUrl + methodName;

		getUrl = generateUrl(params, getUrl);

		httpGet = new HttpGet(getUrl);
		Log.e("WebGetURL: ",getUrl);
		try {
			response = httpClient.execute(httpGet);
			System.out.println("STATUS RESPONSE "+response.getStatusLine().getStatusCode());
			returnedValue = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			Log.e("WebService:", " Messaje " +  e.getMessage());
		} catch (Exception e) {
			Log.e("WebService:", " Messaje " + e.getMessage());
		}

		return returnedValue;
	}

	private String generateUrl(Map<String, String> params, String getUrl) {
		int i = 0;
		for (Map.Entry<String, String> param : params.entrySet())
		{
			if(i == 0){
				getUrl += "?";
			}
			else{
				getUrl += "&";
			}

			try {
				getUrl += param.getKey() + "=" + URLEncoder.encode(param.getValue(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			i++;
		}
		return getUrl;
	}

	public void postData() {
		httpPost = new HttpPost(webServiceUrl);
		try {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
			nameValuePairs.add(new BasicNameValuePair("id", "1"));
			nameValuePairs.add(new BasicNameValuePair("name", "crf"));
			nameValuePairs.add(new BasicNameValuePair("course", "android"));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			httpClient.execute(httpPost);

		} catch (ClientProtocolException e) {
			Log.e("WebService:", " ClientProtocolException " +  e.getMessage());
		} catch (IOException e) {
			Log.e("WebService:", " IOException " +  e.getMessage());
		}
	} 

}
