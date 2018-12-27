package com.sample.school.studentrecord.controller;

import com.sample.school.studentrecord.domain.StudentRecord;
import com.sample.school.studentrecord.service.StudentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StudentRecordController {
    private StudentRecordService studentRecordService;

    @Autowired
    public void setStudentRecordService(StudentRecordService studentRecordService) {
        this.studentRecordService = studentRecordService;
    }

    @RequestMapping("/v1/schoolrecord")
    public ArrayList<StudentRecord> retreiveStudentReport() {
        return this.studentRecordService.getStudentRecord();
    }

    @RequestMapping("/v1/schoolrecordbylastname")
    public ArrayList<StudentRecord> retreiveStudentReport(@RequestParam("lastname") String lastname) {
        return this.studentRecordService.getStudentRecordByLastName(lastname);
    }
}
