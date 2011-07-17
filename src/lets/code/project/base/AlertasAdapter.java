/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package lets.code.project.base;

import java.util.List;

import lets.code.project.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AlertasAdapter extends BaseAdapter {
	
	Context localContext;
	List<Alertas> elements;

	public AlertasAdapter(Context context, List<Alertas> alertasList) {

		localContext = context;
		elements = alertasList;
	}
	

	public int getCount() {

		return elements.size();
	}

	public Alertas getItem(int position) {

		return elements.get(position);
	}

	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView rowText = null;
		if (convertView == null) {
			rowText = (TextView) LayoutInflater.from(localContext).inflate(R.layout.alert_row, parent, false);
		} else {
			rowText = (TextView) convertView;
		}
		((TextView) rowText.findViewById(R.id.alert_text)).setText(elements.get(position).toString());
		
		return rowText; 
	}

}
