package com.sm.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sm.app.dtos.PlanApiResponse;
import com.sm.app.dtos.PlanApiResponse.PlanResponseParam;

/**
 * 
 * @author nitish.gupta_spicemo
 *
 */
public class Main {

	static String[] configTags = new String[] { "planDescription", "Id", "type", "amountInRupees" };

	public static void main( String[] args ) {
    	String jsonString="{\r\n"
    			+ "	\"valRefId\": \"SD0131166436022160980FE11CF22711547\",\r\n"
    			+ "	\"planResponse\": [{\r\n"
    			+ "		\"type\": \"CURATED\",\r\n"
    			+ "		\"planResponseParams\": [{\r\n"
    			+ "			\"name\": \"Id\",\r\n"
    			+ "			\"value\": \"1\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"Plan Type\",\r\n"
    			+ "			\"value\": \"Smart Recharge\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"Talktime\",\r\n"
    			+ "			\"value\": \"0\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"Validity\",\r\n"
    			+ "			\"value\": \"84 Days\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"Data\",\r\n"
    			+ "			\"value\": \"100 GB\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"Circle\",\r\n"
    			+ "			\"value\": \"Andhra Pradesh\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"amountInRupees\",\r\n"
    			+ "			\"value\": \"598\"\r\n"
    			+ "		}, {\r\n"
    			+ "			\"name\": \"planDescription\",\r\n"
    			+ "			\"value\": \"Tarrif Calls - Local/STD/LL @ 1P/sec\"\r\n"
    			+ "		}]\r\n"
    			+ "	}]\r\n"
    			+ "}";
		Gson gson=new Gson();
		PlanApiResponse apiResponse=(PlanApiResponse)gson.fromJson(jsonString, (TypeToken.get(PlanApiResponse.class)).getType());
		System.out.println(apiResponse);
		
		
		//processing java object
		
		Map<String,Object> map=new HashMap<String, Object>();
		
		map.put("respCode", "000");
		map.put("respDesc", "Success");
		map.put("respStatus", "SU");
		map.put("langTrans", null);
		
		
		Map<String,Object> innerMap= new HashMap<String, Object>();
		innerMap.put("valRefId", apiResponse.getValRefId());
		
		List<String> configTagsList = Arrays.asList(configTags);
		
		for(int i=0;i<apiResponse.getPlanResponse().size();i++) {
			
			Map<String,Object> planResponseObjectMap= new HashMap<String, Object>();
			planResponseObjectMap.put("planResponseParams",apiResponse.getPlanResponse().get(i).getPlanResponseParams());
			planResponseObjectMap.put("type", apiResponse.getPlanResponse().get(i).getType());
			for( PlanResponseParam tag:apiResponse.getPlanResponse().get(i).getPlanResponseParams()) {
				if(configTagsList.contains(tag.getName())) {
					planResponseObjectMap.put(tag.getName(),tag.getValue());
				}
			}
			
			innerMap.put("planResponse",planResponseObjectMap);
		}
		
		map.put("payload", innerMap);
		String response=gson.toJson(map);
		System.out.println("output is :=>"+response);
    }
}
