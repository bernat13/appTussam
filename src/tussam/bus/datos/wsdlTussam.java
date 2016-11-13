package tussam.bus.datos;



import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

public class wsdlTussam {

	private  String SOAP_ACTION="http://tempuri.org/GetPasoParada";
	private  String METHOD_NAME="GetPasoParada";
	private  String NAMESPACE="http://tempuri.org/";
	private  String URL="http://www.infobustussam.com:9001/services/dinamica.asmx";
		
	public wsdlTussam(){}

	public String Consultar(String linea, String parada){
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("linea",linea);
        request.addProperty("parada",parada);
        
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        
        soapEnvelope.dotNet=true;
        soapEnvelope.setOutputSoapObject(request);
        AndroidHttpTransport aht = new AndroidHttpTransport(URL);
        
        try {
			aht.call(SOAP_ACTION, soapEnvelope);
			SoapObject respuesta = (SoapObject)soapEnvelope.getResponse();
        	String resultado =  respuesta.toString();
        	       	
			return ParsearResultado(resultado);
        	
		} catch (Exception e) {
			e.printStackTrace();
			return "Parada o linea incorrecta";
		}
		
	}
	
	private String ParsearResultado(String resultado){
	
		String ret="";
    	int i = 0;
    	for (String item : resultado.split("minutos=")) {
    		if (i>0) {
    			String v[] = item.split(";");
        		ret = ret + "\n Próximo bus en " +  v[0] + " Minutos";	
			}
    		i ++;
    		
		}
    	return ret;
		
	}
	
}
