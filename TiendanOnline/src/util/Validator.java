package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static boolean validarNIF(String nif) {

	    boolean correcto = false;

	    Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");

	    Matcher matcher = pattern.matcher(nif);

	    if (matcher.matches()) {

	        String letra = matcher.group(2);

	        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

	        int index = Integer.parseInt(matcher.group(1));

	        index = index % 23;

	        String reference = letras.substring(index, index + 1);



	        if (reference.equalsIgnoreCase(letra)) {

	            correcto = true;

	        } else {

	            correcto = false;

	        }

	    } else {

	        correcto = false;

	    }

	    return correcto;

	} 
	
	public static boolean validarCorreo (String correo) {
		boolean validado = false;
		 // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        String email = correo;

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            validado = true;
            return validado;
        } else {
            return validado;
        }
	}
	
	public static boolean isNumeric (String numero) {
		int resultado;
		try {
			resultado = Integer.parseInt(numero);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
