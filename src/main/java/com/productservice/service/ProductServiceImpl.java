package com.productservice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.productservice.dao.ProductDao;
import com.productservice.model.Product;

@Component
public class ProductServiceImpl implements ProductSevice{

	
	@Autowired
	ProductDao dao;
	
	@Override
	public Product getProductByIdAndName(Long id, String name) {
		//dao.getProductByIdAndName(id, name);
		return dao.getProductByIdAndName(id, name);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		dao.save(product);
	}

	@Override
	public void getListOfProduct(List listOfProductId) {
		// TODO Auto-generated method stub
		
		dao.getListOfProduct(listOfProductId);
		
	}
	@Override
	public void generateExcel() {
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
	      
	     //Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");
	       
	     //This data needs to be written (Object[])
	     Map<String, Object[]> data = new TreeMap<String, Object[]>();
	     data.put("1", new Object[] {"ID", "NAME", "LASTNAME"});
	     data.put("2", new Object[] {1, "Amit", "Shukla\u00AE"});
	     data.put("3", new Object[] {2, "Lokesh", "Gupta\u00a9"});
	     data.put("4", new Object[] {3, "John", "Adwards"});
	     data.put("5", new Object[] {4, "Brian", "Schultz"});
	       
	     //Iterate over data and write to sheet
	     Set<String> keyset = data.keySet();
	     int rownum = 0;
	     for (String key : keyset)
	     {
	         Row row = sheet.createRow(rownum++);
	         Object [] objArr = data.get(key);
	         int cellnum = 0;
	         for (Object obj : objArr)
	         {
	            Cell cell = row.createCell(cellnum++);
	            if(obj instanceof String)
	                 cell.setCellValue((String)obj);
	             else if(obj instanceof Integer)
	                 cell.setCellValue((Integer)obj);
	         }
	     }
	     try
	     {
	         //Write the workbook in file system
	         FileOutputStream out = new FileOutputStream(new File("sample.xls"));
	         workbook.write(out);
	         out.close();
	         System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
	     } 
	     catch (Exception e) 
	     {
	         e.printStackTrace();
	     }
	 }

	@Override
	public void generatePdf() {

		 Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
	         document.add(new Paragraph("Anthati Venkateswara Rao."));
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
		
	}
	
}
