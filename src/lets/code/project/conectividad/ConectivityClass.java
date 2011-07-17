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

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ConectivityClass {
	
	public static String getHTMLPage() {
    	String str = "***";

        try
    	{
    		HttpClient hc = new DefaultHttpClient();
    		//HttpPost post = new HttpPost("http://www.yahoo.com");
    		HttpGet get = new HttpGet("http://barrapunto.com/index.xml");

    		HttpResponse rp = hc.execute(get);
    		System.out.println("STATUS "+rp.getStatusLine().getStatusCode());
    		if(rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
    		{
    			str = EntityUtils.toString(rp.getEntity());
    		}
    	}catch(IOException e){
    		e.printStackTrace();
    	}  
    	
    	return str;
    }

}
