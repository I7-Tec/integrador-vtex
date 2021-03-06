package br.com.i7solution.vtex.tools;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

public class Ferramentas {
	static public Long stringToLong(String valor) {
		try{
			return Long.parseLong(valor);
		} catch (Exception e) {
			return null;
		}
	}

	static public Double stringToDouble(String valor) {
		try{
			return Double.parseDouble(valor);
		} catch (Exception e) {
			return null;
		}
	}

	static public Integer stringToInt(String valor) {
		try{
			return Integer.parseInt(valor);
		} catch (Exception e) {
			return null;
		}
	}

	static public Date stringToDate(String valor, String formatoEntrada) {
		try{
			Date data = new SimpleDateFormat(formatoEntrada).parse(valor);
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	static public String dataFormatada(Date valor, String formato) {
		try{
			var formatoData = new SimpleDateFormat(formato);
			return formatoData.format(valor);
		} catch (Exception e) {
			return null;
		}
	}

	static public String toRSCase(String texto) {
		try{
			String result = "";
			String textoMin = texto.trim().toLowerCase();

			var maiuscula = false;
			for (int i = 0; i < textoMin.length(); i++) {
				if ((maiuscula) || (i == 0)) {
					result += textoMin.substring(i, i + 1).toUpperCase();
				} else {
					result += textoMin.substring(i, i + 1);
				}
				maiuscula = textoMin.substring(i, i + 1).equals(" ");
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	static public String doubleToStringNvl(Double valor, String nvl) {
		try{
			if (valor != null) {
				return valor.toString();
			} else {
				return nvl;
			}
		} catch (Exception e) {
			return nvl;
		}
	}

	static public String removerAcentos(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	static public String somenteNumeros(String str) {
		String digitos = "";
		char[] letras  = str.toCharArray();
		for (char letra : letras) {
			if(Character.isDigit(letra)) {
				digitos += letra;
			}
		}
		return digitos;
	}

	public static int difDatas(Date dataMenor, Date dataMaior){

		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();

		startTime.setTime(dataMenor);
		endTime.setTime(dataMaior);

		int dif_multiplier = 1;

		// Verifica a ordem de inicio das datas
		if( dataMenor.compareTo(dataMaior) < 0 ){
			baseTime.setTime(dataMaior);
			curTime.setTime(dataMenor);
			dif_multiplier = 1;
		}else{
			baseTime.setTime(dataMenor);
			curTime.setTime(dataMaior);
			dif_multiplier = -1;
		}

		int result_years = 0;
		int result_months = 0;
		int result_days = 0;

		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando
		// no total de dias. Ja leva em consideracao ano bissesto
		while( curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR) ||
				curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)  )
		{
			int max_day = curTime.getActualMaximum( GregorianCalendar.DAY_OF_MONTH );
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);
		}

		// Marca que ?? um saldo negativo ou positivo
		result_months = result_months*dif_multiplier;

		// Retorna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));

		return result_years + result_months + result_days;
	}

	static public Double dividir(Double d1, Double d2) {
		try {
			return d1 / d2;
		} catch (Exception e) {
			return 0.0;
		}
	}

	static public Object nvl(Object s1, Object s2) {
		try {
			if (s1 != null) {
				return s1;
			} else {
				return s2;
			}
		} catch (Exception e) {
			return s2;
		}
	}
}

