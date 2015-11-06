package com.paxovision.framework.excel;

public interface IDataReader {

	public abstract String[] getExcelRowData(String sheetName, int row);

	public abstract String[] getExcelRowData(int sheetNumbere, int row);

	public abstract String[] getExcelColData(String sheetName, int col);

	public abstract String[] getExcelColData(int sheetNumber, int col);

	public abstract String getExcelCellData(String sheetName, int row, int col);

	public abstract String getExcelCellData(int sheetNumber, int row, int col);

	public abstract String[][] getExcelSheetData(String sheetName)
			throws Exception;
	public abstract String[][] getExcelSheetData(String sheetName, boolean skipHeaderColumn)
		  throws Exception;

	public abstract String[][] getExcelSheetData(int sheetNumber)
			throws Exception;

}