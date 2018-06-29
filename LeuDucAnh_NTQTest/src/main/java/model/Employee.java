package main.java.model;

public class Employee implements Comparable<Employee>{
	
	private String id;
	private String name;
	private String dayOfBird;
	private String address;
	private Long salary;
	public Employee() {
		super();
	}
	public Employee(String id, String name, String dayOfBird, String address, Long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dayOfBird = dayOfBird;
		this.address = address;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDayOfBird() {
		return dayOfBird;
	}
	public void setDayOfBird(String dayOfBird) {
		this.dayOfBird = dayOfBird;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee otherEmployee) {
		if(salary > otherEmployee.getSalary()) return 1;
		else if(salary < otherEmployee.getSalary()) return -1;
		else {
			return name.compareTo(otherEmployee.getName()); 
		}
	}
}
