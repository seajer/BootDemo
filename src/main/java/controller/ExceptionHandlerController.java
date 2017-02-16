package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.RestException;

@Controller
public class ExceptionHandlerController {
	
	private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler
	public @ResponseBody String handleException(RestException e){
		LOG.error("Помилка: " + e.getMessage(), e);
        return "Помилка: " + e.getMessage();
	}
}
