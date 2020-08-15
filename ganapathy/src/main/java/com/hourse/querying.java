package com.hourse;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class querying {
	 static Map<String, String> makeQueryMap(String query) throws UnsupportedEncodingException {
	        String[] params = query.split("&");
	        Map<String, String> map = new HashMap<String, String>();
	        for( String param : params ) {
	            String[] split = param.split("=");
	            map.put("categories", URLDecoder.decode(split[0], "UTF-8"));
	        }
	        return map;
	    }

}
