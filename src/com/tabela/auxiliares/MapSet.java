package com.tabela.auxiliares;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class MapSet {
	
	HttpServletRequest request;
	Set<String> parameterNames = request.getParameterMap().keySet();
	
	
	for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
	    String name = entry.getKey();
	    String value = entry.getValue()[0];
	    // ...
	}
	
	  Map map = request.getParameterMap();
	  for(Object key : map.keySet()){
	      String keyStr = (String)key;
	      Object value = map.get(keyStr);     
	      System.out.println("Key " + (String)key + "     :    " + value);
	  }
	  
	  Map map = request.getParameterMap();
	  for(Object key : map.keySet()){
	    String keyStr = (String)key;
	    Object value = map.get(keyStr);
	    if(value instanceof String)
	    System.out.println("Key " + (String)key + "     :    " + (String)value);
	}
	  
	  
	  Map map = request.getParameterMap();
	    for (Object key: map.keySet())
	    {
	            String keyStr = (String)key;
	            String[] value = (String[])map.get(keyStr);
	            System.out.println("Key" + (String)key + "   :   " + Arrays.toString(value));
	    }
	    
	    String value = (String) map.get(keyStr)[0];
	    
	    
	    
	    
	    Enumeration<String> parameterNames = req.getParameterNames();
	    while (parameterNames.hasMoreElements()) {
	        String key = (String) parameterNames.nextElement();
	        String val = req.getParameter(key);
	        System.out.println("A= <"+key+"> Value<"+val+">");
	    }
	    
	    
	    
	    Map<String,Object> allMap=req.getParameterMap();
	    for(String key:allMap.keySet()){
	        String[] strArr=(String[])allMap.get(key);
	        for(String val:strArr){
	            System.out.println("Str Array= "+val);
	        }   
	    }
	  
	    
	    for (String key : map.keySet()) {
	        System.out.println(key + ":" + map.get(key));
	    }
	    
	    
	    for (Entry<String, Integer> entry : map.entrySet()) {
	        System.out.println(entry);
	    }
	    
	    
	    /*
	     * This example source code demonstrates the use of  
	     * entrySet() method of HashMap class
	     */

	    public class HashMapEntrySetExample {

	    	public static void main(String[] args){

	    		// initialize the HashMap object with Integer as key and String as value
	    		HashMap<Integer, String> mapEmployee = new HashMap<Integer, String>();
	    		
	    		// populate the student map
	    		mapEmployee.put(1287, "Aquilino Pimentel");
	    		mapEmployee.put(3125, "Travis Davis");
	    		mapEmployee.put(9972, "Marianne Laste");
	    		
	    		//get the keys
	    		Set<Map.Entry<Integer, String>> mappingSet = mapEmployee.entrySet();
	    		System.out.println("Initial value of keys:"+mappingSet);
	    		
	    		// add another key value mapping
	    		mapEmployee.put(4581, "Kate Visor");
	    		
	    		// print the values which the set contains
	    		System.out.println("New set of keys:"+mappingSet);
	    	}	
	    }
	    
	    
	    
	    public static void main(String args[]) {

	        HashMap<String, Double> hm = new HashMap<String, Double>();

	        hm.put("A", new Double(3434.34));
	        hm.put("B", new Double(123.22));
	        hm.put("C", new Double(1378.00));
	        hm.put("D", new Double(99.22));
	        hm.put("E", new Double(-19.08));

	        Set<Map.Entry<String, Double>> set = hm.entrySet();

	        for (Map.Entry<String, Double> me : set) {
	          System.out.print(me.getKey() + ": ");
	          System.out.println(me.getValue());
	        }

	        System.out.println();

	        double balance = hm.get("B");
	        hm.put("B", balance + 1000);

	        System.out.println("B's new balance: " + hm.get("B"));
	      }
	    }
	    

for(Map.Entry<Integer,VmAllocation> entry : allMap.entrySet()) {
    System.out.print("Key: " + entry.getKey());
    System.out.println(" / Value: " + entry.getValue());
}


}
