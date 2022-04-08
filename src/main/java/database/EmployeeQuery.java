package database;

import entities.Employee;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmployeeQuery {

    EntityManager entityManager;  // Variable para obtener la conexion.
    Employee employee;
    List<Employee> listEmployee = null;

    // constructor
    public EmployeeQuery() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager(); // abre la conexion con la BD.
        listEmployee = new ArrayList<Employee>();
    }

    public Boolean addEmployee(int idEmp, String firstName, String lastName, String email, String phoneNumb, String address, String salary, String birth, int idComp)
    {
        employee = new Employee(idEmp, firstName, lastName, email, phoneNumb, address, salary, birth, idComp);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        return entityManager.contains(employee);
    }

    public List<Employee> getAllEmployees()
    {
        Query query=entityManager.createQuery("From Employee");
        listEmployee = (List<Employee>) query.getResultList();
        return listEmployee;
    }

    public Employee getEmployeebyId(int idComp)
    {
        employee = entityManager.find(Employee.class, idComp);
        return employee;
    }

    public List<Employee> getEmployeebyLastName(String lastName)
    {
        Query query=entityManager.createQuery("SELECT p FROM Employee p WHERE p.lastName = :lastName");
        query.setParameter("lastName", lastName);
        listEmployee = query.getResultList();
        return listEmployee;
    }

    public Boolean updateEmployee(int idEmp, String firstName, String lastName, String email, String phoneNumb, String address, String salary, String birth, int idComp)
    {
        Boolean result = false;
        employee = new Employee();

        employee = entityManager.find(Employee.class, idEmp);
        if(employee != null) {
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumb);
            employee.setAddress(address);
            employee.setSalary(salary);
            employee.setBirthDate(birth);
            employee.setIdCompany(idComp);

            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
            result = entityManager.contains(employee);
        }
        else ;
        return result;
    }

    public int deleteEmployee(int idEmp)
    {
        int result = 0;
        employee = new Employee();

        employee = entityManager.find(Employee.class, idEmp);
        if(employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            result=1;
        }
        else ;
        return result;
    }
}
