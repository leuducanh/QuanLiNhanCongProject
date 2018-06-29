package main.java.service;

import java.util.Comparator;
import java.util.List;

import main.java.model.Employee;
import main.java.storage.EmployeeStorage;

public class EmployeeService extends AbstractService<Employee, EmployeeStorage>{

	public EmployeeService() {
		super();
		EmployeeStorage storage = new EmployeeStorage();
		super.setStorage(storage);
	}
	
	public List<Employee> searchByName(){
		String name;
		
		do {
			System.out.println("Nhap ten nhan vien: ");
			name = scanner.nextLine();
			if(validation.validateIsNotEmpty(name)) System.out.println("Khong duoc de trong!");
			else break; 
		}while(true);
		
		return storage.searchByName(name);
	}

	public void createNewEmployee() {
		String id;
		String name;
		String dateOfBirth;
		String address;
		String salary;
		
		do {
			
			System.out.println("Nhap id nhan vien: ");
			id = scanner.nextLine();
			if(!validation.validateIsNotEmpty(id)) System.out.println("Khong duoc de trong ma!");
			else {
				if(storage.checkIfDuplicateIdEmployee(id)) {
					System.out.println("Trung ma nhan vien");
				}else {
					break;
				}
			}
		}while(true);
		
		do {
			
			System.out.println("Nhap ten nhan vien: ");
			name = scanner.nextLine();
			if(!validation.validateIsNotEmpty(name)) System.out.println("Khong duoc de trong ten!");
			else break;
		}while(true);
		
		do {
			
			System.out.println("Nhap ngay sinh nhan vien: ");
			dateOfBirth = scanner.nextLine();
			if(!validation.validateIsNotEmpty(dateOfBirth)) System.out.println("Khong duoc de trong ngay sinh!");
			else break;
		}while(true);
		
		do {
			
			System.out.println("Nhap dia chi nhan vien: ");
			address = scanner.nextLine();
			if(!validation.validateIsNotEmpty(address)) System.out.println("Khong duoc de trong dia chi!");
			else break;
		}while(true);
		
		do {
			
			System.out.println("Nhap luong nhan vien: ");
			salary = scanner.nextLine();
			if(!validation.validateIsNotEmpty(salary)) System.out.println("Khong duoc de trong luong!");
			else { 
				if(!validation.validateIsNumber(salary)) System.out.println("Luong phai la so!");
				else {
					break;
				}
			}
		}while(true);
		
		save(new Employee(id,name,dateOfBirth,address,Long.parseLong(salary)));
	}
	
	public List<Employee> getCustomOderedEmployees(){
		List<Employee> employees = getAll();
		
		employees.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee employee, Employee otherEmployee) {
				if(employee.getSalary() > otherEmployee.getSalary()) return 1;
				else if(employee.getSalary() < otherEmployee.getSalary()) return -1;
				else {
					return employee.getName().compareTo(otherEmployee.getName()); 
				}
			}
		});
		
		return employees;
	}
}
