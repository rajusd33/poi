package com.paxovision.framework.excel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.util.Arrays;

public class DataReaderJXL implements IDataReader {

	private String fileName = null;
	private File file = null;
	private Workbook wb  = null;
	
	public DataReaderJXL(String fileName) throws Exception{
		this.fileName = fileName;
		file = new File(fileName);
		if(!file.exists()){
			throw new Exception("file with name " + fileName + " does not exist");
		}
		else
		{
			wb  = Workbook.getWorkbook(file);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelRowData(java.lang.String, int)
	 */
	@Override
	public String[] getExcelRowData(String sheetName,int row){
		String[] data = null;
		if (wb != null) {
			Sheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getRows();
				if(row >= rows){
					throw new RuntimeException("Row number : " + row + " is not valid");
				}
				int cols = sheet.getColumns();

				data = new String[cols];

					for (int j = 0; j < cols; j++) {

						String cellData = sheet.getCell(j, row).getContents();

						data[j] = cellData;
					}
			}
		}
		
		return data;
	}
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelRowData(int, int)
	 */
	@Override
	public String[] getExcelRowData(int sheetNumbere,int row){
		String[] data = null;
		if (wb != null) {
			Sheet sheet = wb.getSheet(sheetNumbere);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();

				data = new String[cols];

					for (int j = 0; j < cols; j++) {

						String cellData = sheet.getCell(j, row).getContents();

						data[j] = cellData;
					}
			}
		}
		
		return data;
	}
	
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelColData(java.lang.String, int)
	 */
	@Override
	public String[] getExcelColData(String sheetName,int col){
		String[] data = null;
		if (wb != null) {
			Sheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();

				data = new String[rows];

					for (int j = 0; j < rows; j++) {

						String cellData = sheet.getCell(col, j).getContents();

						data[j] = cellData;
					}
			}
		}
		
		return data;
	}
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelColData(int, int)
	 */
	@Override
	public String[] getExcelColData(int sheetNumber,int col){
		String[] data = null;
		if (wb != null) {
			Sheet sheet = wb.getSheet(sheetNumber);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();

				data = new String[rows];

					for (int j = 0; j < rows; j++) {

						String cellData = sheet.getCell(col, j).getContents();

						data[j] = cellData;
					}
			}
		}
		
		return data;
	}
	
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelCellData(java.lang.String, int, int)
	 */
	@Override
	public String getExcelCellData(String sheetName, int row, int col){
		String data = null;
		
		if (wb != null) {
			Sheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();
				data = sheet.getCell(col, row).getContents();
			}
		}
		
		
		return data;
	}
	
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelCellData(int, int, int)
	 */
	@Override
	public String getExcelCellData(int sheetNumber, int row, int col){
		String data = null;
		
		if (wb != null) {
			Sheet sheet = wb.getSheet(sheetNumber);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();
				data = sheet.getCell(col, row).getContents();
			}
		}
		
		
		return data;
	}
	
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelSheetData(java.lang.String)
	 */
	@Override
	public String[][] getExcelSheetData(String sheetName) throws Exception {

		String[][] data = null;

		if (wb != null) {
			// Sheet sheet = wb.getSheet(0);
			Sheet sheet = wb.getSheet(sheetName);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();

				data = new String[rows][cols];

				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {

						String cellData = sheet.getCell(j, i).getContents();

						data[i][j] = cellData;
					}
				}

			}
		}
		return data;
	}
	
	/* (non-Javadoc)
	 * @see selenium.datareader.IDataReader#getExcelSheetData(int)
	 */
	@Override
	public String[][] getExcelSheetData(int sheetNumber) throws Exception {

		String[][] data = null;

		if (wb != null) {
			// Sheet sheet = wb.getSheet(0);
			Sheet sheet = wb.getSheet(sheetNumber);
			if (sheet != null) {
				int rows = sheet.getRows();
				int cols = sheet.getColumns();

				data = new String[rows][cols];

				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {

						String cellData = sheet.getCell(j, i).getContents();

						data[i][j] = cellData;
					}
				}

			}
		}
		return data;
	}


	@Override
	public String[][] getExcelSheetData(String sheetName,
			boolean skipHeaderColumn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
