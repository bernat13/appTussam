package tussam.bus;


import tussam.bus.datos.wsdlTussam;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bus extends Activity {
    /** Called when the activity is first created. */
	TextView tv;
	EditText linea;
	EditText parada;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tv = (TextView) findViewById(R.id.TextView01);
        linea = (EditText) findViewById(R.id.EditText02);
        parada = (EditText) findViewById(R.id.EditText01);
        
        Button boton = (Button) findViewById(R.id.Button01); 
        
        boton.setOnClickListener
        (
			new View.OnClickListener() 
			{
				public void onClick(View view) 
				{
					wsdlTussam	tussam = new wsdlTussam();
					String resultado = tussam.Consultar(linea.getText().toString(), parada.getText().toString());
					tv.setText(resultado);
				}
			}
        );
        
    }
}