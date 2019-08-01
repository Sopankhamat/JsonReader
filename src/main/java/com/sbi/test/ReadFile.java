package com.sbi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class ReadFile {

	public static void main(String[] args) throws JsonProcessingException, IOException {
		File file = new File("G:\\WS\\Apache Tomcat\\eclipse\\E\\JsonReader\\src\\main\\java\\Employee.json");
		
		InputStream is;
		
		is = new  FileInputStream(file);
		JsonReader reader=Json.createReader(is);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonObject object=reader.readObject();
		reader.close();
		
		System.out.println("Emp Name:"+object.getString("emp_name"));
		System.out.println("Emp Id:"+object.getInt("emp_id"));
		//read object
		
		JsonObject obj = object.getJsonObject("address");
		System.out.println("city:"+obj.getString("city"));
		
		//read array 
		
		JsonArray arrObject = object.getJsonArray("direct_reports");
		System.out.println("\n Employee Name");
		for(JsonValue value:arrObject) {
			System.out.println(value.toString());
		}
		System.out.println(".................Add New Employee...............................");
		   
        StringWriter strWtr = new StringWriter();
        JsonGenerator jsonGen = Json.createGenerator(strWtr);
        JsonGenerator start = jsonGen.writeStartObject();
        start.write("emp_name", "Khamat G");
        start.write("emp_id", 1016);
        start.write("salary", 20000);
        start.writeEnd();
        jsonGen.close();
        
        System.out.println(strWtr.toString());
		 
        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode node=objectMapper.readTree(json);
        String color = node.get("color").asText();
        
        System.out.println("\n color:"+color);
        
        //Creating map object 
        String json1 = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        Map<String, Object> map = objectMapper.readValue(json1,new TypeReference<Map<String,Object>>(){});
        
        System.out.println(json1);
        
        
	}

}
