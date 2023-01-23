package Tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;


public class TestHibernate {

	public static void main(String[] args) {
		
		try(SessionFactory sf= getFactory(); Scanner sc = new Scanner(System.in)){
			System.out.println("In session factory");
			
			EmployeeDaoImpl emp=new EmployeeDaoImpl();
			System.out.println("enter data");

			Employee user = new Employee(sc.next(),sc.next(),Department.valueOf(sc.next().toUpperCase()),sc.nextDouble(),LocalDate.parse(sc.next()),sc.nextBoolean());
			
			System.out.println(emp.addEmpDetails(user));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
