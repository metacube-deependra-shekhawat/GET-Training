package main.java;
import java.util.ArrayList;
import java.util.List;

class Department {
    String name;
    List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // This method will add an employee to the department
    public boolean join(Employee employee) {
        for(Employee emp: employees){
            if(emp == employee) return false;
        }
        return employees.add(employee);
    }

    // This method will remove an employee from the department
    public boolean relieve(Employee employee) {
        if(employees.contains(employee)){
            return employees.remove(employee);
        } else {
            return false;
        }
    }

    // This method will return the list of employees of the department
    public List<Employee> getEmployees() {
        return employees;
    }
}