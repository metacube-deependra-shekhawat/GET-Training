package main.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayrollTest {

    @Test
    void completePayrollTest() {
        Organization org = new Organization();
        Department devDept = new Department("Development");
        Department adminDept = new Department("Admin");

        Employee dev1 = new DeveloperEmployee("Nikhil", 800000, 50000);
        Employee dev2 = new DeveloperEmployee("Amrit", 750000, 60000);
        Employee admin1 = new AdminEmployee("Aman", 60000, 60000);
        Employee admin2 = new AdminEmployee("Ankita", 550000, 60000);
        org.addDepartment(devDept);
        org.addDepartment(adminDept);

        assertTrue(devDept.join(dev1));
        assertTrue(devDept.join(dev2));
        assertEquals(2,org.getAllEmployees().size());
        assertFalse(devDept.join(dev2));
        assertTrue(adminDept.join(admin1));
        assertEquals(3,org.getAllEmployees().size());
        assertTrue(devDept.relieve(dev2));
        assertFalse(devDept.relieve(dev2));

        Payroll payroll = new Payroll();

        payroll.printSalarySlip(admin1);
    }
}