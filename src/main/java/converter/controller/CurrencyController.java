package converter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import converter.service.CurrencyService;

@RestController
public class CurrencyController {
	private final Logger logger =LoggerFactory.getLogger(this.getClass());
	@Autowired
	CurrencyService service;
	
	@GetMapping("/")
	public String home() {
		logger.info("Page loaded successfully");
		return "Welcome to currency converter app";
		
		
	}
	
//	http://localhost:8080/convertINRto/CAD/amount/1000
	@GetMapping("convertINRto/{toCode}/amount/{amount}")
		public String calculateAmount(@PathVariable String toCode, @PathVariable double amount) {
		logger.info("calculateAmount method called with toCode var :" + toCode + " amount : " + amount);
		logger.info("Making Service call to exchange currency");
		return service.exchangeCurrency(toCode,amount); 
		
	
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public String incorrectCode(Exception e) {
		logger.error("Incorrect code");
		logger.error("Error :" + e);
		return "Incorrect code";
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String invalidAmount(Exception e) {
		logger.error("Invalid amount" + e);
		return "Invalid amount";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String UnknownException(Exception e) {
		logger.error("Exception handled :" + e);
		return "Unknown exception";
		
	}
}
