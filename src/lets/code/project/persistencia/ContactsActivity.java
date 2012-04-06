/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lets.code.project.R;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ContactsActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_list);
		String filter = Phone.DISPLAY_NAME + " LIKE '%Jose%' "; //POSIBLE FILTRO A USAR
		Cursor cursor = getContentResolver().query(
				ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
				new String[] {Phone._ID, Phone.DISPLAY_NAME, Phone.NUMBER}, 
				null, null, Phone.DISPLAY_NAME);
		startManagingCursor(cursor);
		String[] from = new String[] { Phone.DISPLAY_NAME, Phone.NUMBER};
		int[] to = new int[] { R.id.name_entry, R.id.number_entry};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.contact, cursor, from, to);
		this.setListAdapter(adapter);
		
//		String[] from = new String[] {"display_name", "data1"};
//		int[] to = new int[] { R.id.name_entry, R.id.number_entry};
//		
//		List<HashMap<String, String>> dataMap = new ArrayList<HashMap<String, String>>();
//		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("display_name", "Jose Cortés");
//		map.put("data1","555444333");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("display_name", "Roberto Brenlla");
//		map1.put("data1","3322244411");
//		
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("display_name", "Alberto Gimenez");
//		map2.put("data1","9998887733");
//		
//		dataMap.add(map);
//		dataMap.add(map2);
//		dataMap.add(map1);
//		
//		SimpleAdapter simpleAdapter = new SimpleAdapter(this, dataMap, R.layout.contact, from, to);
//		this.setListAdapter(simpleAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Cursor c = ((Cursor) l.getAdapter().getItem(position));
		Toast.makeText(getBaseContext(),  c.getString(c.getColumnIndex(Phone.DISPLAY_NAME)), Toast.LENGTH_LONG).show();
	}
}
