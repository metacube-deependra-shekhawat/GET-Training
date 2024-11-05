package main.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayrollTest {

    @Test
    void testPayroll() {
        Organization org = new Organization();
        Department devDept = new Department("Development");
        Department adminDept = new Department("Admin");

        Employee dev1 = new DeveloperEmployee("Nikhil", 800000, 50000);
        Employee dev2 = new DeveloperEmployee("Amrit", 750000, 60000);
        Employee admin1 = new AdminEmployee("Aman", 60000, 60000);
        Employee admin2 = new AdminEmployee("Ankita", 550000, 60000);

        devDept.join(dev1);
        devDept.join(dev2);
        adminDept.join(admin1);
        adminDept.join(admin2);

        org.addDepartment(devDept);
        org.addDepartment(adminDept);

        Payroll payroll = new Payroll();
        for (Employee emp : org.getAllEmployees()) {
            payroll.printSalarySlip(emp);
        }

        assertEquals(4, org.getAllEmployees().size());

        adminDept.relieve(admin1);

        assertEquals(3, org.getAllEmployees().size());
    }
}