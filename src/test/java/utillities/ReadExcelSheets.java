package utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheets {
	
	
	XSSFWorkbook wb;
	XSSFSheet sheet ;
	
	
	public ReadExcelSheets(String excelPath) throws  IOException
	{
		File srcFile = new File(excelPath);
		FileInputStream fis = new FileInputStream(srcFile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}
	
	public String getCellData(String sheetName, int rowNumber, int columnNumber)
	{
		sheet= wb.getSheet(sheetName);
		String data= null;
		XSSFCell cell;
		
		try
		{
			data = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();	
		} catch(Exception e){
			cell= sheet.getRow(rowNumber).getCell(columnNumber);
			if(HSSFDateUtil.isCellDateFormatted(cell))
			 {
				 SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				 data= sdf.format(cell.getDateCellValue());
				
			 }else
			 {
				 Double data1 = sheet.getRow(rowNumber).getCell(columnNumber).getNumericCellValue();
				 Long longValue=data1.longValue();
				 data= new String(longValue.toString());  
			}
		}
		 
		 return data;
	}
	
	public int getRowCount(String sheetName)
	{
		int sheetIndex= wb.getSheetIndex(sheetName);
		int rowCNT = wb.getSheetAt(sheetIndex).getLastRowNum();
		return rowCNT;		
		}
   
	public int getColumnCount(String sheetName)
	{
		int sheetIndex= wb.getSheetIndex(sheetName);
		int rowCount = wb.getSheetAt(sheetIndex).getLastRowNum();
		int columnCount = 0;
		
		for(int i=0; i<rowCount;i++)
		{
		int count = wb.getSheetAt(sheetIndex).getRow(i).getLastCellNum();
		if(count>columnCount)
		{
			columnCount=count;
		}
		}
		return columnCount;
		
		}
	

}
