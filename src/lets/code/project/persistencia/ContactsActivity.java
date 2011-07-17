package lets.code.project.persistencia;

import lets.code.project.R;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Cursor c = ((Cursor) l.getAdapter().getItem(position));
		Toast.makeText(getBaseContext(),  c.getString(c.getColumnIndex(Phone.DISPLAY_NAME)), Toast.LENGTH_LONG).show();
	}
}

