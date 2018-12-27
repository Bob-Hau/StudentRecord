package com.sample.school.studentrecord.service;

import com.sample.school.studentrecord.dao.StudentRecordDao;
import com.sample.school.studentrecord.domain.StudentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service
public class StudentRecordServiceImpl implements StudentRecordService {
    private StudentRecordDao studentRecordDao;

    @Autowired
    public void setStudentRecordDao(StudentRecordDao studentRecordDao) {
        this.studentRecordDao = studentRecordDao;
    }

    public ArrayList<StudentRecord> getStudentRecord() {
        return studentRecordDao.getAllStudentDetail();
    }

    public ArrayList<StudentRecord> getStudentRecordByLastName(String lastname) {
        return studentRecordDao.getStudentDetailByLastName(lastname);
    }

}
