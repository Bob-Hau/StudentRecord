package com.sample.school.studentrecord.dao;

import com.sample.school.studentrecord.entity.StudentModuleDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModuleDetailMapper implements RowMapper<StudentModuleDetail> {
    public StudentModuleDetail mapRow(ResultSet row, int rowNum) throws SQLException {
        StudentModuleDetail studentModuleDetail = new StudentModuleDetail();

        studentModuleDetail.setStudentNo(row.getString("student_no"));
        studentModuleDetail.setLastName(row.getString("last_name"));
        studentModuleDetail.setFirstName(row.getString("first_name"));
        studentModuleDetail.setModuleCode(row.getString("course_no"));
        studentModuleDetail.setModuleName(row.getString("course_name"));
        studentModuleDetail.setMark(row.getFloat("grade"));

        return studentModuleDetail;
    }
}
