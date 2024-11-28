package main.java;

abstract class Employee {
    String name;
    String id;
    int basicSalary;
    int bonus;
    int compensation;
    abstract int getBasicSalary();
    abstract int getBonus();
    abstract int getCompensation();
}

class AdminEmployee extends Employee {

    static int count = 1;

    public AdminEmployee(String name, int salary, int bonus){
        this.name = name;
        this.id = "AD"+count++;
        this.basicSalary = salary;
        this.bonus = bonus;
        this.compensation = salary+bonus;
    }

    @Override
    int getBasicSalary(){
        return this.basicSalary;
    }

    @Override
    int getBonus(){
        return this.bonus;
    }

    @Override
    int getCompensation(){
        return this.compensation;
    }
}

class DeveloperEmployee extends Employee {

    static int count = 1;

    public DeveloperEmployee(String name, int salary, int bonus){
        this.name = name;
        this.id = "DP"+count++;
        this.basicSalary = salary;
        this.bonus = bonus;
        this.compensation = salary+bonus;
    }

    @Override
    int getBasicSalary(){
        return this.basicSalary;
    }

    @Override
    int getBonus(){
        return this.bonus;
    }

    @Override
    int getCompensation(){
        return this.compensation;
    }
}
