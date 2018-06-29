package main.java.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.java.model.Employee;

public class EmployeeStorage implements Storageable<Employee>{

	private List<Employee> employeeDatabase = new ArrayList<>();
	
	@Override
	public void save(Employee employee) {
		employeeDatabase.add(employee);
	}

	@Override
	public List<Employee> getAll() {		
		return employeeDatabase;
	}

	
	public List<Employee> searchByName(String name){
		List<Employee> searchedEmployee = new ArrayList<>();
		
		for( int i = 0; i < employeeDatabase.size(); i++ ) {
			if(employeeDatabase.get(i).equals(name)) {
				searchedEmployee.add(employeeDatabase.get(i));
			}
		}
		
		return searchedEmployee;
	}
	
	public boolean checkIfDuplicateIdEmployee(String id) {
		for(int i = 0;i < employeeDatabase.size();i++) {
			if(employeeDatabase.get(i).getId().equals(id)) {
				return true;
			}
		}
		
		return false;
	}
}
