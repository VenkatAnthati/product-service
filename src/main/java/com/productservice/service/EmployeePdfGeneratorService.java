package com.productservice.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

@Service
public interface EmployeePdfGeneratorService {
	void generatePDF() throws FileNotFoundException, DocumentException;

	void preparetable() throws FileNotFoundException, DocumentException;
}
