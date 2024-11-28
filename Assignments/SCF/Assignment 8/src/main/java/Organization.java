package main.java;

import java.util.ArrayList;
import java.util.List;

class Organization {
    List<Department> departments;

    public Organization() {
        this.departments = new ArrayList<>();
    }

    // This method will add a department to list of departments and will return true if success
    public boolean addDepartment(Department department) {
        return departments.add(department);
    }

    //This method will return the list of all employees in the organization
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }
}