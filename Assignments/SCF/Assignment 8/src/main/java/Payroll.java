package main.java;

class Payroll {
    public void printSalarySlip(Employee employee) {
        double basicSalary = employee.getBasicSalary();
        double bonus = employee.getBonus();
        double compensation = employee.getCompensation();
        double tax = calculateTax(compensation);

        System.out.println("Salary Slip of Employee " + employee.name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Compensation: " + compensation);
        System.out.println("Tax: " + tax);
        System.out.println("Final Salary: " + (compensation - tax));
    }

    /**
     * This method will calculate the tax to be charged on the compensation
     * @param compensation the total compensation before taxation
     * @return tax to be subtracted  from the compensation
     */
    private double calculateTax(double compensation) {
        return compensation * 0.3;
    }

    public static void main(String[] args){
        Organization org = new Organization();
        Department devDept = new Department("Development");
        Department adminDept = new Department("Admin");

        Employee dev1 = new DeveloperEmployee("Nikhil", 800000, 50000);
        Employee dev2 = new DeveloperEmployee("Amrit", 750000, 60000);
        Employee admin1 = new AdminEmployee("Aman", 60000, 60000);
        Employee admin2 = new AdminEmployee("Ankita", 550000, 60000);

        if(devDept.join(dev1)){
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Employee not added");
        }

        if(devDept.join(dev2)){
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Employee not added");
        }

        if(adminDept.join(admin1)){
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Employee not added");
        }

        if(adminDept.join(admin1)){
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Employee not added");
        } 

        org.addDepartment(devDept);
        org.addDepartment(adminDept);

        if(devDept.relieve(dev2)){
            System.out.println("Employee relieved successfully");
        } else {
            System.out.println("Employee does not exits");
        }

        if(adminDept.relieve(admin2)){
            System.out.println("Employee relieved successfully");
        } else {
            System.out.println("Employee does not exists");
        }

        Payroll payroll = new Payroll();

        payroll.printSalarySlip(admin1);

        for (Employee emp : org.getAllEmployees()) {
            payroll.printSalarySlip(emp);
        }
    }
}
