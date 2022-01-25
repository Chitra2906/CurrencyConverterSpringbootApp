package converter.service;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converter.data.CurrencyData;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyData data;
	private final Logger logger =LoggerFactory.getLogger(this.getClass());
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	
	public String exchangeCurrency(String toCode , double amount) {
		logger.info("exchangeCurrency method in service entered");
		logger.info("toCode value : " + toCode + " amount : " +amount );
		float rate = data.exchangeRate(toCode);
		double converetedAmount = amount * rate;
		logger.info("fetched rate :" + rate );
		logger.info("Amount after conversion is " + converetedAmount );
		return "Amount after conversion is " + numberFormat.format(converetedAmount);
		
	}

}
