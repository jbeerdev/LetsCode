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
