package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//Employee : id (auto_increment : PK) , first name ,last name , department (enum : RND,FINANCE,MARKETING,HR,BILLING), salary, dob(LocalDate) ,isPermanent(boolean)
//Annotations
//@Entity , @Table, @Id, @GeneratedValue(strategy=GenerationType.IDENTITY)
//, @Column , @Enumerated, ....
//table : employees

@Entity
@Table(name="emps",uniqueConstraints = @UniqueConstraint(columnNames = {"first_name","last_name"}))
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private Integer id;
	@Column(name="first_name",length = 30)
	private String firstName;
	@Column(name="last_name",length = 30)
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Department department;
	private Double salary;
	private LocalDate dob;
	private Boolean isPermanent;
	
	
	public Employee( String firstName, String lastName, Department department, Double salary, LocalDate dob,
			Boolean isPermanent) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.salary = salary;
		this.dob = dob;
		this.isPermanent = isPermanent;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Boolean getIsPermanent() {
		return isPermanent;
	}


	public void setIsPermanent(Boolean isPermanent) {
		this.isPermanent = isPermanent;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", salary=" + salary + ", dob=" + dob + ", isPermanent=" + isPermanent + "]";
	}
	
	
	

}
