package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProvider1
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testdata\\logintestdata.xlsx";//taking excel file from testdata
		ExcelUtility exl=new ExcelUtility(path);
		int totalrows=exl.getRowCount("Sheet1");
		int totalcolms=exl.getCellCount("Sheet1", 1);
		String logindata[][]=new String[totalrows][totalcolms];//creating 2dimension array for storing data
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcolms;j++)
			{
				logindata[i-1][j]=exl.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
	}

}
