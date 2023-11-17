package com.naveenautomationlabs.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.naveenautomationlabs.base.TestBase;

public class ExcelUtil extends TestBase {

	public static FileInputStream fi;

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String fileName, String sheet) throws Exception {
		int rowCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();

		return rowCount;
	}

	public static int getColoumnCount(String fileName, String sheet, int rowCount) throws Exception {
		int coloumnCount;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCount);
		coloumnCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return coloumnCount;
	}

	public static  String getCellData(String fileName, String sheet, int rowCount, int coloumnCount) throws Exception {
		String data = null;
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rowCount);
		cell = row.getCell(coloumnCount);
		data = cell.getStringCellValue();
		return data;

	}
}
