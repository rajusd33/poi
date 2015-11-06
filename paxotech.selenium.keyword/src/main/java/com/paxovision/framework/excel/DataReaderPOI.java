package com.paxovision.framework.excel;

import java.io.File;
import java.io.FileInputStream;





import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataReaderPOI implements IDataReader{

	private String fileName = null;
	private File file = null;
	private XSSFWorkbook wb  = null;
	
	private SimpleDateFormat simpleDateFormat;
	
	public DataReaderPOI(String fileName) throws Exception{
		this.fileName = fileName;
		file = new File(fileName);
		if(!file.exists()){
			throw new Exception("file with name " + fileName + " does not exist");
		}
		else
		{
			FileInputStream fileStreem = new FileInputStream(file);
			wb  = new XSSFWorkbook(fileStreem);
		}
	}
	
	
	
	
	
	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}





	@Override
	public String[] getExcelRowData(String sheetName, int row) {
		String[] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(row).getPhysicalNumberOfCells();

				data = new String[cols];

				for (int i = 0; i < cols; i++) {
						
					Cell cell = sheet.getRow(row).getCell(i);
					String cellData = getData(cell).toString();

					data[i] = cellData;
					
				}

			}
		}
		return data;
	}

	@Override
	public String[] getExcelRowData(int sheetNumbere, int row) {
		String[] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheetAt(sheetNumbere);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(row).getPhysicalNumberOfCells();

				data = new String[cols];

				for (int i = 0; i < cols; i++) {
						
					Cell cell = sheet.getRow(row).getCell(i);
					String cellData = getData(cell).toString();

					data[i] = cellData;
					
				}

			}
		}
		return data;
	}

	@Override
	public String[] getExcelColData(String sheetName, int col) {
		String[] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

				data = new String[rows];

				for (int i = 0; i < rows; i++) {
						
					Cell cell = sheet.getRow(i).getCell(col);
					String cellData = getData(cell).toString();

					data[i] = cellData;
					
				}

			}
		}
		return data;
	}

	@Override
	public String[] getExcelColData(int sheetNumber, int col) {
		String[] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheetAt(sheetNumber);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

				data = new String[rows];

				for (int i = 0; i < rows; i++) {
						
					Cell cell = sheet.getRow(i).getCell(col);
					String cellData = getData(cell).toString();

					data[i] = cellData;
					
				}

			}
		}
		return data;
	}

	@Override
	public String getExcelCellData(String sheetName, int row, int col) {
		String data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(row).getPhysicalNumberOfCells();

				Cell cell = sheet.getRow(row).getCell(col);
				String cellData = getData(cell).toString();
				data = cellData;
			}
		}
		return data;
	}

	@Override
	public String getExcelCellData(int sheetNumber, int row, int col) {
		String data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheetAt(sheetNumber);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(row).getPhysicalNumberOfCells();

				Cell cell = sheet.getRow(row).getCell(col);
				String cellData = getData(cell).toString();
				data = cellData;
			}
		}
		return data;
	}

	@Override
	public String[][] getExcelSheetData(String sheetName) throws Exception {
		String[][] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

				data = new String[rows][cols];

				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						
						Cell cell = sheet.getRow(i).getCell(j);
						String cellData = getData(cell).toString();

						data[i][j] = cellData;
					}
				}

			}
		}
		return data;
	}
	

	public String[][] getExcelSheetData(String sheetName, boolean skipHeaderColumn) throws Exception {
		String[][] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				
				if(skipHeaderColumn){
					int rows = sheet.getLastRowNum();
					int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
	
					data = new String[rows][cols];
	
					for (int i = 1; i <= rows; i++) {
						for (int j = 0; j < cols; j++) {
							
							Cell cell = sheet.getRow(i).getCell(j);
							String cellData = getData(cell).toString();
	
							data[i - 1][j] = cellData;
						}
					}
				}
				else{
					int rows = sheet.getLastRowNum() + 1;
					int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();
	
					data = new String[rows][cols];
	
					for (int i = 0; i < rows; i++) {
						for (int j = 0; j < cols; j++) {
							
							Cell cell = sheet.getRow(i).getCell(j);
							String cellData = getData(cell).toString();
	
							data[i][j] = cellData;
						}
					}
				}
	
			}
		}
		return data;
	}
	

	@Override
	public String[][] getExcelSheetData(int sheetNumber) throws Exception {
		String[][] data = null;

		if (wb != null) {
			XSSFSheet sheet = wb.getSheetAt(sheetNumber);
			if (sheet != null) {
				int rows = sheet.getLastRowNum() + 1;
				int cols = sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells();

				data = new String[rows][cols];

				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						
						Cell cell = sheet.getRow(i).getCell(j);
						String cellData = getData(cell).toString();

						data[i][j] = cellData;
					}
				}

			}
		}
		return data;
	}
	
	
private  Object getData(Cell cell){
		
		Object result = null;
		
		if(cell != null){
			switch (cell.getCellType ())
			{
				case HSSFCell.CELL_TYPE_NUMERIC :
				{
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						result = simpleDateFormat.format(cell.getDateCellValue());
					}
					else
					{
						result = cell.getNumericCellValue ();
					}
					break;
				}
				case HSSFCell.CELL_TYPE_STRING :
				{
					RichTextString richTextString = cell.getRichStringCellValue ();
					result = richTextString.getString();	
					break;
				}
				default :
				{
					System.out.println ("Type not supported.");
					result = "";
					break;
				}
			}
		}
		
		return result;
	}

}
