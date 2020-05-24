package utilities;

import java.util.ArrayList;

import base.TDDBase;

public class TDDUtil extends TDDBase{
	 static Xls_Reader reader;
	
	
	
	 public static ArrayList<Object[]> getExcelSheetData() {
			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			try{
				reader = new Xls_Reader("C:\\Users\\SING110\\Documents\\JAVARELATEDITEMS\\POMWorkspace\\TDDFramework\\src\\main\\java\\testData\\CustomerData.xlsx");
			} catch(Exception e ) {
				e.printStackTrace();
			}
			
			int rowCount = reader.getRowCount("customer");
			
			
			for(int rowNum=2; rowNum<=rowCount; rowNum++) {
				String clientname= reader.getCellData("customer", 0, rowNum);
				String workflow= reader.getCellData("customer", 1, rowNum); 
				String lawfirm= reader.getCellData("customer", 2, rowNum);
				String timekeeper= reader.getCellData("customer", 3, rowNum);
				String fname= reader.getCellData("customer", 4, rowNum);
				String lname= reader.getCellData("customer", 5, rowNum);
				String emailAddr= reader.getCellData("customer", 6, rowNum);
				String division= reader.getCellData("customer", 7, rowNum);
				String office= reader.getCellData("customer", 8, rowNum);
				String add1= reader.getCellData("customer", 9, rowNum);
				String city= reader.getCellData("customer", 10, rowNum);
				String state= reader.getCellData("customer", 11, rowNum);
				String zip= reader.getCellData("customer", 12, rowNum);
				String phone= reader.getCellData("customer", 13, rowNum);
				
				Object[] ob = {clientname,workflow,lawfirm,timekeeper,fname,lname,emailAddr,division,office,add1,city,state,zip,phone};
				myData.add(ob);
			}
			return myData;
				
		}
		
		
	
}
