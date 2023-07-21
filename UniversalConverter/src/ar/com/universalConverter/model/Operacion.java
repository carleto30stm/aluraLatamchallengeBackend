package ar.com.universalConverter.model;

import java.util.HashMap;

public class Operacion {
	private String currency, currencyTo;
	private double  value;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public double getValue() {
		return  value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	private double  res;
	
	public double submit() {
		HashMap<String, Double> convertionRates = new HashMap<>();
		convertionRates.put("peso_dolar", 0.00372090);
		convertionRates.put("peso_euro", 0.00333118);
		convertionRates.put("dolar_peso", 268.752);
		convertionRates.put("dolar_euro", 1.11699);
		convertionRates.put("euro_peso", 300.194);
		convertionRates.put("euro_dolar", 0.895260);
		
		String convertionKey = currency + "_" + currencyTo;
		if(currency == currencyTo) {
			return res = value;
		}else
        if (convertionRates.containsKey(convertionKey)) {
            return res = Math.round(value)  * convertionRates.get(convertionKey);
        } else {
            // Manejar el caso de conversión no soportada
            throw new IllegalArgumentException("No se admite la conversión de " + currency + " a " + currencyTo);
        }
    
		
	}

}
