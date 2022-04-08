package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Employee")  //Declara Entidad Employee, que Representa una tabla en la Base de Datos
@Table(name="Employee")  // Anotacion para referirnos a la tabla en la base de Datos
public class Employee {

    @Id
    @Column(name = "idEmployee")
    protected int idEmployee;
    @Column(name = "firstName")
    protected String firstName;
    @Column(name = "lastName")
    protected String lastName;
    @Column(name = "email")
    protected String email;
    @Column(name = "phoneNumber")
    protected String phoneNumber;
    @Column(name = "address")
    protected String address;
    @Column(name = "Salary")
    protected String salary;
    @Column(name = "birthDate")
    protected String birthDate;
    @Column(name = "idCompany")
    protected int idCompany;

    // no-argument constructor
    public Employee()
    {
    }

    public Employee(int idEmployee, String firstName, String lastName, String email, String phoneNumber, String address, String salary, String birthDate, int idCompany) {
        this.idEmployee = idEmployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.birthDate = birthDate;
        this.idCompany = idCompany;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }
}
