package utils;

import java.util.HashMap;
import java.util.Map;

public class Ajax {
	
	public static Map<String, Object> succesResponse(Object obj){
		Map<String, Object> response = new HashMap<String, Object>();
	    response.put("result", "success");
	    response.put("data", obj);
	    return response;
	}
	
	public static Map<String, Object> emptyResponse() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("result", "success");
		return response;
    }
	
	public static Map<String, Object> errorResponse(String errorMessage) {
		Map<String, Object> response = new HashMap<String, Object>();
	    response.put("result", "error");
	    response.put("message", errorMessage);
	    return response;
	}
}
