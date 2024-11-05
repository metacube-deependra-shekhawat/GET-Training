package main.java;

import java.util.ArrayList;
import java.util.List;

class Organization {
    List<Department> departments;

    public Organization() {
        this.departments = new ArrayList<>();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }
}