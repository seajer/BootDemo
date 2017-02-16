package controller;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import utils.Ajax;
import utils.DataService;

@Controller
public class DataController extends ExceptionHandlerController{
	
	private static final Logger LOG = Logger.getLogger(DataController.class);
	
	@Autowired
    @Qualifier("dataService")
    private DataService dataService;
	
	@RequestMapping(value = "/persist", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> persist(@RequestParam("data") String data){
		LOG.debug("POST");
		try {
			if(data == null || data.equals("")){
				return Ajax.emptyResponse();
			}
			dataService.persist(data);
			return Ajax.emptyResponse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getRandomData(){
		LOG.debug("GET");
		try {
			Set<String> result = dataService.getRandomData();
			return Ajax.succesResponse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
