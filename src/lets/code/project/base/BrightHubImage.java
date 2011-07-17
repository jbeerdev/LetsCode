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


import lets.code.project.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BrightHubImage extends LinearLayout implements OnLongClickListener{

	private CharSequence toastMessage;
	private CharSequence footNoteMessage;
	private Drawable image;
	private Context cxt;
	private TextView footNoteText;
	private ImageView brightImage;
	
	public BrightHubImage(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.bright_image,this);
		this.setOnLongClickListener(this);
		cxt = context;
		
	}

	public BrightHubImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.bright_image,this);
		
		this.setOnLongClickListener(this);
		cxt = context;
		
		/** We initialize the elements form our UI because we are going to modify them **/
		
		footNoteText = (TextView) findViewById(R.id.footnote);
		brightImage = (ImageView) findViewById(R.id.image);
		
		/** We get the attributes from the XML file attrs.xml **/
		TypedArray styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.BrighHubImage);
		toastMessage = styleAttributes.getString(R.styleable.BrighHubImage_message_string);
		image = styleAttributes.getDrawable(R.styleable.BrighHubImage_bright_image);
		footNoteMessage = styleAttributes.getString(R.styleable.BrighHubImage_footnote_string);
		
		footNoteText.setText(footNoteMessage);
		brightImage.setBackgroundDrawable(image);

	}
	
	@Override
	public boolean onLongClick(View arg0) {
		
		Toast.makeText(cxt, toastMessage, Toast.LENGTH_LONG).show();
		
		return false;
	}
	

}
