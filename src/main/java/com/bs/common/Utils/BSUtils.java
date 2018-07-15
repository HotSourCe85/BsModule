package com.bs.common.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.bs.common.ENUM.RestEnum;


public class BSUtils {
//	public static void main(String[] args) {
//		Map<String, Object> reqMap = new HashMap<>();
//		
//		reqMap.put("query", "삼국지");
//		reqMap.put("page", "1");
//		
//		RestEnum addr = RestEnum.SEARCH_BOOK_PATH;
//		
//		String address = addr.getValue();
//		System.out.println(apiCallByGet(address, reqMap));
//	}
	public static String apiCallByGet(String address, Map<String, Object> reqMap) {
		RestEnum secretValue = RestEnum.CLIENT_SECRET;
		RestEnum hostValue = RestEnum.HOST;
        String clientSecret = secretValue.getValue();
        String host = hostValue.getValue();
        try {
            String params = mapToParams(reqMap); 
            String apiURL = host + address + params;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { 
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
	}
	
    public static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public static String mapToParams(Map<String, Object > map) {
        StringBuilder paramBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            paramBuilder.append(paramBuilder.length() > 0 ? "&" : "");
            paramBuilder.append(String.format("%s=%s", urlEncodeUTF8(key),
                    urlEncodeUTF8(map.get(key).toString())));
        }
        return paramBuilder.toString();
    }

}
