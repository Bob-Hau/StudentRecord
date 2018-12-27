package com.sample.school.studentrecord.dao;

import com.sample.school.studentrecord.domain.StudentRecord;

import java.util.ArrayList;

public interface StudentRecordDao {
    ArrayList<StudentRecord> getAllStudentDetail();
    ArrayList<StudentRecord> getStudentDetailByLastName(String lastname);
}
