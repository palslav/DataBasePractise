package com.tp.pals.databasepractise;

/**
 * Created by pallav.choudhary on 05-07-2017.
 */

public class Employee {

    private int _id;
    private String _empName;
    private String _empEmail;

    public Employee(){}

    public Employee(String name, String email){
        this._empName = name;
        this._empEmail = email;
    }

    public void set_id(int id){
        this._id = id;
    }

    public void set_name(String name){
        this._empName = name;
    }

    public void set_email(String email){
        this._empEmail = email;
    }

    public int getEmpId() {
        return _id;
    }

    public String getEmpName() {
        return _empName;
    }

    public String getEmpEmail() {
        return _empEmail;
    }
}
