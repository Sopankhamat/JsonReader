package com.sbi.test;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sbi.bean.Transaction;

public class Test 
{
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		Transaction transaction = new Transaction("transaction", new Date());
		
		ObjectMapper objectMap = new ObjectMapper();
		ObjectMapper objectMap2 = new ObjectMapper();

		String output = objectMap.writeValueAsString(transaction);
		System.out.println(output);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
		
		objectMap2.setDateFormat(dateFormat);
		
		String out = objectMap2.writeValueAsString(dateFormat);
		
		System.out.println(out);
		
	}
}
