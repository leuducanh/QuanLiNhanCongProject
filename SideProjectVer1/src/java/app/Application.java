package app;

import controller.EmployeeController;
import model.Employee;
import service.EmployeeService;
import service.validation.CommonValidation;
import storage.EmployeeStorage;
import view.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws CloneNotSupportedException {
		CommonValidation commonValidation = new CommonValidation();
		EmployeeStorage storage = new EmployeeStorage();
		EmployeeService employeeService = new EmployeeService(storage);
		EmployeeView view = new EmployeeView();
		EmployeeController employeeController  = new EmployeeController(view,employeeService,commonValidation);
		employeeController.start();
	}
}

