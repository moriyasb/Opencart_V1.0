package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider is created as separated class since we can reuse many number of times across
	//test cases, here in DP we are fetching value from xcell into a String 2D array 
	//and returning it as it obviously does.
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx"; //Taking XL file from testData folder
		ExcelUtility xlutility = new ExcelUtility(path); //creating an object for XLUtility
		
		int totalrows=xlutility.getRowCount("Sheet1");
		int totalcols=xlutility.getCellCount("Sheet1", 1 );//1 is row number leaving out header row 0th one
		//taking out row and col number so to create same size of 2D array 
		
		String logindata[][]=new String[totalrows][totalcols];
		//created two dimension array which can store the data user email and password
		
		for(int i=1;i<=totalrows;i++) //taking 1st row leaving 0th row since it having header
			// <= lessthan/equalto since row count starting from 0
		{
			for(int j=0;j<totalcols;j++) //taking 0th column
				// < lessthan since col count starting from 1
			{
				logindata[i-1][j] = xlutility.getCellData("Sheet1", i, j); //1,0
						//loading values into 2D array with x and y index starting (0,0)
			}
		}
		return logindata; //returning two dimension array
	}
		//DataProvider 2
	
		//DataProvider 3
		
		//DataProvider 4
}
