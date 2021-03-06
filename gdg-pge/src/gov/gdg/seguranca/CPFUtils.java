package gov.gdg.seguranca;

public class CPFUtils {

	/**
	 * Realiza a valida��o do CPF.
	 * 
	 * @param strCPF
	 *            n�mero de CPF a ser validado
	 * @return true se o CPF � v�lido e false se n�o � v�lido
	 */
	public static boolean validar(String strCpf) {

		if (strCpf.equals("00000000000") || strCpf.equals("11111111111")
				|| strCpf.equals("22222222222") || strCpf.equals("33333333333")
				|| strCpf.equals("44444444444") || strCpf.equals("55555555555")
				|| strCpf.equals("66666666666") || strCpf.equals("77777777777")
				|| strCpf.equals("88888888888") || strCpf.equals("99999999999")
				|| (strCpf.length() != 11)) {
			return false;
		}

		int d1, d2;
		int digito1, digito2, resto;
		int digitoCPF;
		String nDigResult;

		d1 = d2 = 0;
		digito1 = digito2 = resto = 0;

		for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
			digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount))
					.intValue();

			// multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
			// e assim por diante.
			d1 = d1 + (11 - nCount) * digitoCPF;

			// para o segundo digito repita o procedimento incluindo o primeiro
			// digito calculado no passo anterior.
			d2 = d2 + (12 - nCount) * digitoCPF;
		}
		;

		// Primeiro resto da divis�o por 11.
		resto = (d1 % 11);

		// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
		// menos o resultado anterior.
		if (resto < 2)
			digito1 = 0;
		else
			digito1 = 11 - resto;

		d2 += 2 * digito1;

		// Segundo resto da divis�o por 11.
		resto = (d2 % 11);

		// Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11
		// menos o resultado anterior.
		if (resto < 2)
			digito2 = 0;
		else
			digito2 = 11 - resto;

		// Digito verificador do CPF que est� sendo validado.
		String nDigVerific = strCpf.substring(strCpf.length() - 2,
				strCpf.length());

		// Concatenando o primeiro resto com o segundo.
		nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

		// comparar o digito verificador do cpf com o primeiro resto + o segundo
		// resto.
		return nDigVerific.equals(nDigResult);
	}

}
