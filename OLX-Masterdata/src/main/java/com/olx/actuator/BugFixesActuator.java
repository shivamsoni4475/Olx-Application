package com.olx.actuator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="bugfixes")
public class BugFixesActuator {
	
	private static Map<String,List<String>> bugsMap = new HashMap<String,List<String>>(); 
	static {
		bugsMap.put("v1",Arrays.asList("Bug 1", "Bug 2"));
		bugsMap.put("v2",Arrays.asList("Bug 3", "Bug 4"));
		
	}
    
	@ReadOperation
	public Map<String,List<String>> getAllBugs(){
		return bugsMap;
	}
	
	@ReadOperation
	public List<String> getBugListByVersion(@Selector String Version){
		return bugsMap.get(Version);
	}
	
	@DeleteOperation
	public Map<String, List<String>> deleteVersionById(@Selector String Version){
		bugsMap.remove(Version);
		return bugsMap;
	}
	
	@WriteOperation
	public Map<String, List<String>> createNewVersion(@Selector String Version, String bugs){
		bugsMap.put(Version,Arrays.asList(bugs.split(",")));
		return bugsMap;
	}
}
