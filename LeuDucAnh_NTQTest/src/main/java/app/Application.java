package main.java.app;

import java.util.List;
import java.util.Scanner;

import main.java.model.Employee;
import main.java.service.EmployeeService;

public class Application {

	public static void main(String[] args) {
		int c = 0;
		Scanner scanner = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService();
		do {
			System.out.println("1)Nhap moi nhan vien \n"
					+ "2)Tim theo ten va in danh sach nhan vien ra man hinh \n"
					+ "3)Xuat ra danh sach nhan vien \n");
			
			c = scanner.nextInt();
			
			switch (c) {
			case 1:
				employeeService.createNewEmployee();
				break;
				
			case 2:
				hienThi(employeeService.searchByName());;
				
			case 3:
				hienThi(employeeService.getAll());
				break;

			default:
				break;
			}
			
		}while(c != 0);
		
	}
	
	public static void hienThi(List<Employee> employees) {
		System.out.println("Danh sach nhan vien la: ");
		for(int i = 0; i < employees.size(); i++) {
			Employee e = employees.get(i);
			System.out.println(e.getId() + " - " + e.getName() + " - " + e.getDayOfBird() + " - " + e.getAddress() + " - " + e.getSalary() );
		}
		System.out.println("=================================");
	}
}
