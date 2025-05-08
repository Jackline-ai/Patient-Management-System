package com.patientmis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patientmis.service.PatientReportService;

@RestController
@RequestMapping("/api")
public class PatientListReportController {

    @Autowired
    private PatientReportService patientReportService;

    @GetMapping("/generateReport")
    public String generateReport(@RequestParam(name = "reportFormat", required = false) String reportFormat) {
	if (reportFormat == null) {
	    return "Error: 'reportFormat' parameter is required.";
	}
	try {
	    return patientReportService.exportReport(reportFormat);
	} catch (Exception e) {
	    return "error generating report" + e.getMessage();
	}

    }

}
