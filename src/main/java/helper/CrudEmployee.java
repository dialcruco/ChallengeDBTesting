package helper;

import entities.Employee;
import database.EmployeeQuery;

import java.util.List;

public class CrudEmployee {

    protected Employee employee = new Employee();
    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsEmployee;

    // no-argument constructor
    public CrudEmployee() { }

    public void insertEmployee(int idEmp, String firstName, String lastName, String email, String phoneNumb, String address, String salary, String birth) {
        Boolean result = employeeQuery.addEmployee(idEmp, firstName, lastName, email, phoneNumb, address, salary, birth);

        if ( result == true )
            System.out.println(" Employee Added ");
        else
            System.out.println(" Employee NOT Added ");
    }

    public void getAllEmployees() {
        resultsEmployee = employeeQuery.getAllEmployees();
        for (Employee emp : resultsEmployee) {
            System.out.print(emp.getIdEmployee()+"  -  ");
            System.out.print(emp.getFirstName()+"  -  ");
            System.out.print(emp.getLastName()+"  -  ");
            System.out.print(emp.getEmail()+"  -  ");
            System.out.println(emp.getPhoneNumber()+"  -  ");
            System.out.println(emp.getAddress()+"  -  ");
            System.out.println(emp.getSalary()+"  -  ");
            System.out.println(emp.getBirthDate());
        }
    }

    public void findEmployeeId(int idEmp) {
        employee = employeeQuery.getEmployeebyId(idEmp);
            System.out.print(employee.getIdEmployee()+"  -  ");
            System.out.print(employee.getFirstName()+"  -  ");
            System.out.print(employee.getLastName()+"  -  ");
            System.out.print(employee.getEmail()+"  -  ");
            System.out.println(employee.getPhoneNumber()+"  -  ");
            System.out.println(employee.getAddress()+"  -  ");
            System.out.println(employee.getSalary()+"  -  ");
            System.out.println(employee.getBirthDate());
    }

    public void findEmployeeLastName(String lastName) {
        resultsEmployee = employeeQuery.getEmployeebyLastName(lastName);
        for (Employee emp : resultsEmployee) {
            System.out.print(emp.getIdEmployee()+"  -  ");
            System.out.print(emp.getFirstName()+"  -  ");
            System.out.print(emp.getLastName()+"  -  ");
            System.out.print(emp.getEmail()+"  -  ");
            System.out.println(emp.getPhoneNumber()+"  -  ");
            System.out.println(emp.getAddress()+"  -  ");
            System.out.println(emp.getSalary()+"  -  ");
            System.out.println(emp.getBirthDate());
        }
    }

    public void updateEmployee(int idEmp, String firstName, String lastName, String email, String phoneNumb, String address, String salary, String birth) {
        Boolean result = employeeQuery.updateEmployee(idEmp, firstName, lastName, email, phoneNumb, address, salary, birth);
        if ( result == true )
            System.out.println(" Employee Updated ");
        else
            System.out.println(" Employee NOT Updated ");
    }

    public void deleteEmployee(int idEmp) {
        int result = employeeQuery.deleteEmployee(idEmp);

        if ( result == 1 )
            System.out.println(" Employee Deleted ");
        else
            System.out.println(" Employee NOT Deleted ");
    }
}
