package com.sample.school.studentrecord.service;

import com.sample.school.studentrecord.domain.StudentRecord;

import java.util.ArrayList;

public interface StudentRecordService {
    ArrayList<StudentRecord> getStudentRecord();
    ArrayList<StudentRecord> getStudentRecordByLastName(String lastname);
}
