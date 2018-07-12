package model;

import java.io.Serializable;

public class Employee implements Serializable,Cloneable,Comparable<Employee> {

	private String id;
	private String name;
	private int age;
	private String address;
	private Long salary;
	public Employee() {
		super();
	}

	public Employee(String id, String name, int age, String address, Long salary) {
		this.id = id;
		this.name = name;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	public String toString() {
		return id + " " + name + " " + age + " " + address + " " + salary;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int compareTo(Employee employee) {
		if(id.equals(employee.getId())
				&& name.equals(employee.getName())
				&& age == employee.getAge()
				&& address.equals(employee.getAddress())
				&& salary.equals(employee.getSalary())){
			return 0;
		}

		return -1;
	}
}
