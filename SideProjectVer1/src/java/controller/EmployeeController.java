package controller;

import model.Employee;
import service.EmployeeService;
import service.utils.StandardizedStringUtil;
import service.validation.CommonValidation;
import view.EmployeeView;

import java.util.List;

public class EmployeeController{

    private EmployeeView employeeView;
    private EmployeeService employeeService;
    private CommonValidation validation;

    public EmployeeController(EmployeeView employeeView, EmployeeService employeeService) {
        this.employeeView = employeeView;
        this.employeeService = employeeService;
    }

    public EmployeeController(EmployeeView employeeView, EmployeeService employeeService, CommonValidation validation) {
        this.employeeView = employeeView;
        this.employeeService = employeeService;
        this.validation = validation;
    }

    public void start() throws CloneNotSupportedException {
        int commandNumber;
        List<Employee> list;

        do {
            commandNumber = employeeView.displayMenu();
            if(commandNumber == 0)break;
            switch (commandNumber) {
                case 1:
                    Employee employee = employeeView.inputEmployee();
                    if (employeeService.save(employee)) {
                        employeeView.printMessage("Luu thanh cong!");
                    } else {
                        employeeView.printMessage("Luu that bai!");
                    }
                    break;

                case 2:
                    String searchedName = employeeView.inputEmployeeName();
                    list = employeeService.searchByName(searchedName);
                    employeeView.display(list);
                    break;

                case 3:
                    list = employeeService.getAll();
                    employeeView.display(list);
                    break;

                case 4:
                    String idBeDeleted = employeeView.choseEmployeeId(employeeService.getAll());
                    if (employeeService.delete(idBeDeleted)) {
                        employeeView.printMessage("Xoa thanh cong");
                    } else {
                        employeeView.printMessage("Xoa that bai");
                    }
                    break;

                case 5:
                    List<Employee> employees = employeeService.getAll();

                    Employee oldEmployeeBeEdited = takeChoseEmployeeFromView(employees);
                    Employee newEmployeeBeEdited = (Employee) oldEmployeeBeEdited.clone();
                    int editCommand;
                    do{
                        editCommand = employeeView.showMenuForEditing();
                        editProperty(newEmployeeBeEdited,editCommand);

                        switch (editCommand){
                            case 5:
                                if(oldEmployeeBeEdited.compareTo(newEmployeeBeEdited) != 0){
                                    employeeView.printMessage("Do you want to save your changes?");
                                    String chose = employeeView.showChoseYesOrNoAnswer();
                                    if("".equals(chose))employeeService.update(newEmployeeBeEdited);
                                }

                                oldEmployeeBeEdited = takeChoseEmployeeFromView(employees);
                                newEmployeeBeEdited = (Employee) oldEmployeeBeEdited.clone();
                                break;
                            case 0:
                                employeeService.update(newEmployeeBeEdited);
                                break;
                        }

                    }while(editCommand != 6 && editCommand != 0);

                    break;

                default:
                    break;
            }

        }while (true) ;
    }

    private Employee takeChoseEmployeeFromView(List<Employee> employees) {
        Employee employeeBeEdited = null;
        do{
            String idBeEdited = employeeView.choseEmployeeId(employees);
            for(int i = 0;i < employees.size();i++){
                if(employees.get(i).getId().equals(StandardizedStringUtil.standardizedId(idBeEdited))) employeeBeEdited = employees.get(i);
            }

            if(employeeBeEdited == null) System.out.println("Wrong employee id!!!");
        }while (employeeBeEdited == null);


        return employeeBeEdited;
    }

    private void editProperty(Employee employee,int editCommand){

        switch (editCommand){
            case 1:
                String newName = employeeView.showInputProperty("name");
                employee.setName(newName);

                break;

            case 2:
                int newAge = Integer.parseInt(employeeView.showInputProperty("age"));
                employee.setAge(newAge);
                break;

            case 3:
                String newAddress = employeeView.showInputProperty("address");
                employee.setAddress(newAddress);
                break;

            case 4:
                Long newSalary = Long.parseLong(employeeView.showInputProperty("salary"));
                employee.setSalary(newSalary);
                break;

        }

    }
}
