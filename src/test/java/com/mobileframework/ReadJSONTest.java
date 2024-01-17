package com.mobileframework;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.mobileframework.TestUtils.BaseClass1;
import com.mobileframework.pageObjects.android.InitialPage;

public class ReadJSONTest extends BaseClass1 {
	
		InitialPage initialPage;
		
		
		
		@BeforeMethod
		public void presetup(){
			initialPage = new InitialPage(driver);
			initialPage.setActivity();
		}
		
		@Test(dataProvider="getData")//Indicate test method will use data Provider

		//public void dataProviderTest(String field1, String field2, String field3) {
		public void jsonTest(HashMap<String, String>input) {
			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("TextFields");
			initialPage.typeTextFields(0, input.get("name"));
			initialPage.typeTextFields(1, input.get("lastname"));
			initialPage.typeTextFields(2, input.get("text"));
		}
		
		@Test(dataProvider="getData")//Indicate test method will use data Provider
		public void jsonTest2(HashMap<String, String>input) {
			initialPage.clickViewButton();
			initialPage.scrollDownToVisibleElement("TextFields");
			initialPage.typeTextFields(0, input.get("name2"));
			initialPage.typeTextFields(1, input.get("lastname2"));
			initialPage.typeTextFields(2, input.get("text2"));
		}
		
		/*Add Data Provider annotation and create a bidimensional array
		to store values*/
		@DataProvider()
		public Object getData() throws IOException{
			//Create a list of hashmap which will store each hashmap 
			// {   {hash},   {hash}    } 
			//key-name ,value 
			/*
			  { "textfield1":"data1", 
			    "textfield2": "data2", 
			    "textfield3": "data3" },
			  
			  { "textfield1":"Gilberto", 
			    "textfield2": "Test", 
			    "textfield3": "Another Test"
			  }
			 */
			List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")
					+"/src/test/java/com/mobileframework/TestData/sample.json");
		/*this will return a list of hashmaaps each hashmap represent a set of data
			that will run 1 time the test cases of this class in this example will 
			run test cases two time due we have 2 hashmaps*/ 
				return new Object[][] { {data.get(0)},{data.get(1)}  };
				//Below line is to run testcases 1 time
				//return new Object[][] { {data.get(0)},{data.get(1)}  };
			} 		
		}
				

