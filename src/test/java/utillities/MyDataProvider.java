package utillities;

import java.io.IOException;

public class MyDataProvider {
	
	public static Object[][] getData(String excelPath) throws  IOException, InterruptedException
 	{
 	utillities.ReadExcelSheets readExcel= new utillities.ReadExcelSheets(excelPath);
 	int rowCount= readExcel.getRowCount("Sheet1");
 	int columnCount = readExcel.getColumnCount("Sheet1");
 			
 	Object[][] data = new Object[rowCount][columnCount];
   
    
 	for(int i=1;i<rowCount+1;i++ ){
 	    for(int j=0; j<columnCount; j++)    
 		{
 		data[i-1][j]=readExcel.getCellData("Sheet1",i, j);
 		System.out.println(data);
 		}}
 	return data;
 	}
}
