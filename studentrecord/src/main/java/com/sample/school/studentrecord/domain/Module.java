package com.sample.school.studentrecord.domain;

public class Module {
    private String module_code;
    private String module_name;
    private float mark;

    public String getModule_code() {
        return module_code;
    }

    public String getModule_name() {
        return module_name;
    }

    public float getMark() {
        return mark;
    }

    // Setter Methods

    public void setModule_code( String module_code ) {
        this.module_code = module_code;
    }

    public void setModule_name( String module_name ) {
        this.module_name = module_name;
    }

    public void setMark( float mark ) {
        this.mark = mark;
    }
}