package validadorCpf;

public class ValidarCpf {
	
	public static boolean validar(String cpf) {
		if (cpf==null) {
			return false;
		}
		
		
	cpf = cpf.replaceAll("\\D", "");
	
	if (cpf.length()!=11) {
		return false;
	}
	
	if (cpf.matches("(\\d)\\1{10}")) {
        return false;
    }
	
	int soma1= 0;
	for (int i = 0; i < 9;i++) {
		soma1 += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	}
	
	int dv1 = 11 - (soma1 % 11);
	if (dv1>=10) {
		dv1=0;
	}
	
	int soma2 = 0;
    for (int i = 0; i < 10; i++) {
        soma2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
    }
    int dv2 = 11 - (soma2 % 11);
    if (dv2 >= 10) {
        dv2 = 0;
    }

    
	// Compara os dígitos calculados com os dígitos informados
    return dv1 == Character.getNumericValue(cpf.charAt(9))
        && dv2 == Character.getNumericValue(cpf.charAt(10));
}

	}
	


