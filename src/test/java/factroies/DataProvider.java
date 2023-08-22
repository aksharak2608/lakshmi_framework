package factroies;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {

	
	public static String readconfigdata(String input)
	{
		String output = null;
		//System.out.println("in the readconfigmethod");
		File src= new File(System.getProperty("user.dir")+"\\Testdata\\testdata.properties");
		try {
			Properties pro= new Properties();
			pro.load(new FileInputStream(src));
			 output=(String)pro.getProperty(input);
			 //System.out.println(output);
				
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return output;
	}
	
	public static String readexceldata(String sheetname, int row, int col)
	{
		String op = null;
		try {
			
			op=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"\\Testdata\\testdataexcel.xlsx")))
			.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
			System.out.println(op);
			
		}
		catch(Exception e)
		{
			
		}
		return op;
	}
}
