package storage;


import model.Employee;
import service.utils.FileIOHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeStorage implements Storageable<Employee>{

	private final String filename="employee-file.txt";

	private List<Employee> employeeDatabase;

	public EmployeeStorage() {
		employeeDatabase = FileIOHelper.read(filename);
	}

	@Override
	public boolean delete(String id) {
		Iterator<Employee> it = employeeDatabase.iterator();

		Employee employee;
		while(it.hasNext()){
			employee = it.next();
			if(employee.getId().equals(id)) {
				employeeDatabase.remove(employee);
				FileIOHelper.write(employeeDatabase,filename);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean save(Employee employee) {
		employeeDatabase.add(employee);
		return FileIOHelper.write(employeeDatabase,filename);
	}

	@Override
	public List<Employee> getAll() {		
		return FileIOHelper.read(filename);
	}

	@Override
	public boolean update(Employee newEmployee) {
		for(int i = 0;i < employeeDatabase.size();i++){
			if(employeeDatabase.get(i).getId().equals(newEmployee.getId())){
				employeeDatabase.set(i,newEmployee);
				FileIOHelper.write(employeeDatabase,filename);
				return true;
			}
		}

		return false;
	}


	public List<Employee> searchByName(String name){
		List<Employee> searchedEmployee = new ArrayList<>();
		for( int i = 0; i < employeeDatabase.size(); i++ ) {
			if(employeeDatabase.get(i).getName().equals(name)) {
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
