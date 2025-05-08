package com.patientmis.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class PatientReportService {

    @Autowired
    private DataSource dataSource;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
	String path = "C:\\Users\\developer\\Desktop\\Reports";
	Connection connection = null;
	try {

	    File file = ResourceUtils.getFile("classpath:Patient-ListReport.jrxml");
	    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

	    connection = dataSource.getConnection();

	    Map<String, Object> parameters = new HashMap<>();

	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

	    if (reportFormat.equalsIgnoreCase("pdf")) {
		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\PatientReport.pdf");
	    }

	    return "Report generated in path: " + path;

	} catch (Exception e) {
	    e.printStackTrace();
	    return "Failed to generate report";
	} finally {
	    try {
		if (connection != null) {
		    connection.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
}
