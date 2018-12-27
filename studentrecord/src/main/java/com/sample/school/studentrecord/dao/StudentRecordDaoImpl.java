package com.sample.school.studentrecord.dao;

import com.sample.school.studentrecord.domain.Module;
import com.sample.school.studentrecord.domain.StudentRecord;
import com.sample.school.studentrecord.entity.StudentModuleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRecordDaoImpl implements StudentRecordDao {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_STUDENT_DETAIL = "select a.student_no student_no, a.surname last_name, a.forename first_name, b.module_code course_no, b.mark grade, c.module_name course_name from students a, marks b, modules c where a.student_no=b.student_no and b.module_code = c.module_code";
    private static final String GET_STUDENT_DETAIL_BY_LAST_NAME = "select a.student_no student_no, a.surname last_name, a.forename first_name, b.module_code course_no, b.mark grade, c.module_name course_name from students a, marks b, modules c where a.student_no=b.student_no and b.module_code = c.module_code";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<StudentRecord> getAllStudentDetail() {

        List<StudentModuleDetail> studentModuleDetails = jdbcTemplate.query(GET_ALL_STUDENT_DETAIL, new StudentModuleDetailMapper());

        ArrayList<StudentRecord> studentRecords = new ArrayList<>();
        StudentRecord studentRecord = null;

        for (StudentModuleDetail studentModuleDetail : studentModuleDetails) {
            if (studentRecord != null && studentRecord.getStudent_no().equals(studentModuleDetail.getStudentNo())) {
                // do nothing
            } else {
                if (studentRecord != null) {
                    studentRecords.add(studentRecord);
                }
                studentRecord = new StudentRecord();
                studentRecord.setStudent_no(studentModuleDetail.getStudentNo());
                studentRecord.setFirst_name(studentModuleDetail.getFirstName());
                studentRecord.setLast_name(studentModuleDetail.getLastName());
            }
            Module newModule = new Module();
            newModule.setMark(studentModuleDetail.getMark());
            newModule.setModule_code(studentModuleDetail.getModuleCode());
            newModule.setModule_name(studentModuleDetail.getModuleName());
            studentRecord.getModules().add(newModule);
        }
        if (studentRecord != null) {
            studentRecords.add(studentRecord);
        }

        return studentRecords;
    }

    public ArrayList<StudentRecord> getStudentDetailByLastName(String lastname) {

        List<StudentModuleDetail> studentModuleDetails = jdbcTemplate.query(GET_STUDENT_DETAIL_BY_LAST_NAME, new StudentModuleDetailMapper());

        ArrayList<StudentRecord> studentRecords = new ArrayList<>();
        StudentRecord studentRecord = null;

        for (StudentModuleDetail studentModuleDetail : studentModuleDetails) {
            if (studentRecord != null && studentRecord.getStudent_no().equals(studentModuleDetail.getStudentNo())) {
                // do nothing
            } else {
                if (studentRecord != null) {
                    studentRecords.add(studentRecord);
                }
                studentRecord = new StudentRecord();
                studentRecord.setStudent_no(studentModuleDetail.getStudentNo());
                studentRecord.setFirst_name(studentModuleDetail.getFirstName());
                studentRecord.setLast_name(studentModuleDetail.getLastName());
            }
            Module newModule = new Module();
            newModule.setMark(studentModuleDetail.getMark());
            newModule.setModule_code(studentModuleDetail.getModuleCode());
            newModule.setModule_name(studentModuleDetail.getModuleName());
            studentRecord.getModules().add(newModule);
        }
        if (studentRecord != null) {
            studentRecords.add(studentRecord);
        }

        return studentRecords;
    }
}
