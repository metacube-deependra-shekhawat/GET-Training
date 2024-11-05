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

    public boolean join(Employee employee) {
        for(Employee emp: employees){
            if(emp == employee) return false;
        }
        return employees.add(employee);
    }

    public boolean relieve(Employee employee) {
        if(employees.contains(employee)){
            return employees.remove(employee);
        } else {
            return false;
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}