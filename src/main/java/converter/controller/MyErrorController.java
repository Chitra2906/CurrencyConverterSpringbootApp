package converter.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController{
	
	private final Logger logger =LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value ="/error")
	public String handleError( HttpServletRequest request) {
		logger.error("MyErrorController handled the request");
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			logger.error("statusCode handled : " + statusCode);
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				
				return "error : Check the URL again";
			}
			
			else 
				return "error";
		}
		
		return "error";
	}
	
	private String getErrorPath() {
		return "/error";

	}
}
