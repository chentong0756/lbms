/**
 * 
 */
package com.lbms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lbms.domain.Student;


public class ReadExcel {

	public static List<Student> readXls(InputStream is) throws IOException {
		//HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		XSSFWorkbook hssfWorkbook=new XSSFWorkbook(is);
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					student = new Student();
					XSSFCell first = hssfRow.getCell(0);
					XSSFCell second = hssfRow.getCell(1);
					XSSFCell third = hssfRow.getCell(2);
					XSSFCell fourth = hssfRow.getCell(3);
					XSSFCell fifth = hssfRow.getCell(4);
					XSSFCell sixth = hssfRow.getCell(5);
					student.setUsername(getValue(first));
					student.setName(getValue(second));
					student.setSex(getValue(third));
					student.setSpecialization(getValue(fourth));
					student.setGrade(getValue(fifth));
					student.setContact(getValue(sixth));
					
					list.add(student);
					
				}
			}
		}
		hssfWorkbook.close();
		return list;
	}
	
	 @SuppressWarnings("static-access")
	private static String getValue(XSSFCell hssfCell) {
	        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	            // ���ز������͵�ֵ
	            return String.valueOf(hssfCell.getBooleanCellValue());
	        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	            // ������ֵ���͵�ֵ
	            return String.valueOf(hssfCell.getNumericCellValue());
	        } else {
	            // �����ַ������͵�ֵ
	            return hssfCell.getStringCellValue();
	        }
	    }
}
