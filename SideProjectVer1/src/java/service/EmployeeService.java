package service;


import model.Employee;
import service.utils.StandardizedStringUtil;
import storage.EmployeeStorage;

import java.util.Comparator;
import java.util.List;

public class EmployeeService extends AbstractService<Employee, EmployeeStorage>{


	public EmployeeService() {
		super();
	}

	public EmployeeService(EmployeeStorage storage) {
		super(storage);
	}

	@Override
	public boolean save(Employee employee) {
		employee.setName(StandardizedStringUtil.standardizedName(employee.getName()));
		employee.setId(StandardizedStringUtil.standardizedId(employee.getId()));
		return (storage.checkIfDuplicateIdEmployee(employee.getId())) ? false : super.save(employee);
	}

	public boolean delete(String id){
		return storage.delete(StandardizedStringUtil.standardizedId(id));
	}

	public boolean update(Employee newEmployee){
		newEmployee.setName(StandardizedStringUtil.standardizedName(newEmployee.getName()));
		return storage.update(newEmployee);
	}

	public List<Employee> searchByName(String name){
		return storage.searchByName(StandardizedStringUtil.standardizedOneWord(name));
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
