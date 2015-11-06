package com.paxovision.qa.selenium.keyword.driver;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paxovision.framework.KeyWordScriptBase;
import com.paxovision.framework.kw.TestStep;

public class KeywordDriver extends KeyWordScriptBase{
	
	@Test(dataProvider="ScriptList")
	public void driver(String testCase, String testScript) throws Exception{

		System.out.println("Executing " + testCase + " ....");
		
		loadTestScript(testScript);
		
		for(TestStep ts : testSteps){
			System.out.println("Processing: " + ts.toString());
			processKeyword(ts);		
		}	
	}
	
	
	
	
	@DataProvider(name="ScriptList")
	public String[][] getScriptList(){
		String[][] data = new String[2][2];
		data[0][0] = "Test Case 1";
		data[0][1] = "Script01";
		
		data[1][0] = "Test Case 2";
		data[1][1] = "Script02";
		
		return data;
		
	}
	
	
	
	
	
	
	

}
