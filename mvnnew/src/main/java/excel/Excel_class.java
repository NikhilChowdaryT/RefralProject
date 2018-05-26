package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.WriteAbortedException;

import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Excel_class extends Base {
	
	public static String folderpath = config("xlFolderPath");
	
	static Sheet sh;
	static Workbook wb;
	static WritableWorkbook wwb;
	static WritableSheet wsh;
	public static void excelconnection(String filename, String sheetname)
	{
		
		try {
			File f = new File(folderpath+filename);
			wb =  Workbook.getWorkbook(f);
			sh = wb.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public static int rcount()

	{
	int i=sh.getRows();
	return i;

	}
	public static int ccount()
  	{
	int i=sh.getColumns();
	return i;
  	}
	
	//to read data
	public static String readdata(int col,int row)
	{
	String x = sh.getCell(col,row).getContents();
	return x;
	}

	  public Object[][] excelcontent(String filename , String sheetname)
	    {
	    	Excel_class.excelconnection(filename, sheetname);
	    	
	    	int rc=Excel_class.rcount();
	    	int cc=Excel_class.ccount();
	    	String[][] data = new String[rc-1][cc];
	    	for(int r=1;r<rc;r++){
	    		for(int c=0;c<cc;c++){
	    			data[r-1][c]=Excel_class.readdata(c, r);
	    		}
	    	}
	    	return data;
	    	
	    }
	   
	    //writing to excel
	    public static void outputexcelconnection(String ifilename,String ofilename,String sheetname)
	   	{
	   		try {
	   			
				FileInputStream fis=new FileInputStream(folderpath+ifilename);
	   			
	   			wb =  Workbook.getWorkbook(fis);
	   			 sh = wb.getSheet(sheetname);
	   			 
	   			 FileOutputStream fos=new FileOutputStream(folderpath+ofilename);
	   			 
	   			 wwb=Workbook.createWorkbook(fos, wb);
	   			 
	   			wsh= wwb.getSheet(sheetname);
	   		} catch (Exception e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		} 
	   	}
	   	
	   	public static void writedata(int col,int row,String data)
	   	{
	   		try {
	   			Label l=new Label(col, row, data);
	   			wsh.addCell(l);
	   		} catch (Exception e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		} 
	   	}
	   	public static void saveworkbook()
	   	{
	   		try {
	   			wwb.write();
	   			wwb.close();
	   			wb.close();
	   		} catch (Exception e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		} 
	   	}
	       
	
	
	    
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
