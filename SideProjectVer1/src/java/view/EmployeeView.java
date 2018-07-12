package view;

import model.Employee;
import service.utils.StandardizedStringUtil;
import service.validation.CommonValidation;

import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private Scanner scanner;
    private CommonValidation validation;

    public EmployeeView() {
        this.scanner = new Scanner(System.in);
        validation = new CommonValidation();
    }

    public int displayMenu(){

        int c;
        do {
            System.out.println("1)Nhap moi nhan vien \n"
                    + "2)Tim theo ten va in danh sach nhan vien ra man hinh \n"
                    + "3)Xuat ra danh sach nhan vien \n"
                    + "4)Xoa 1 nhan vien theo ma \n"
                    + "5)Thay doi 1 nhan vien \n");

            c = Integer.parseInt(scanner.nextLine());

            if(c > 5 || c < 0) System.out.println("Vui long chon dung so!!!!!");
            else break;
        }while(true);

        return c;
    }

    public int showMenuForEditing(){
        int c;
        do{
            System.out.println("Chose what you want: \n");
            System.out.println("1)Name\n" +
                    "2)Age\n" +
                    "3)Adress\n" +
                    "4)Salary\n" +
                    "5)Chosse other employee to edit\n" +
                    "6)Discard all\n" +
                    "0)Save\n");
            c = Integer.parseInt(scanner.nextLine());
            if(c > 6 || c < 0) System.out.println("Vui long chon dung so!!!!");
            else break;
        }while (true);

        return c;
    }

    public void printMessage(String mess){
        System.out.println(mess);
    }

    public String inputEmployeeId(){
        System.out.println("Nhap ma nhan vien: ");
        return scanner.nextLine();
    }

    public String inputEmployeeName(){
        System.out.println("Nhap ten nhan vien: ");
        return scanner.nextLine();
    }

    public Employee inputEmployee(){
        String id;
        String name;
        String age;
        String address;
        String salary;

        do{
            System.out.println("Nhap id nhan vien: ");
            id = scanner.nextLine();

            System.out.println("Nhap ten nhan vien: ");
            name = scanner.nextLine();

            System.out.println("Nhap tuoi nhan vien: ");
            age = scanner.nextLine();

            System.out.println("Nhap dia chi nhan vien: ");
            address = scanner.nextLine();

            System.out.println("Nhap luong nhan vien: ");
            salary = scanner.nextLine();

            if(validation.validateIsNotEmpty(id) &&
                    validation.validateIsNotEmpty(name) &&
                    validation.validateIsNotEmpty(age) &&
                    validation.validateIsNotEmpty(address) &&
                    validation.validateIsNotEmpty(salary) &&
                    validation.validateIsNumber(age) &&
                    validation.validateIsNumber(salary)) {
                break;
            }else{
                System.out.println("Nhap ko dung !");
            }

        }while (true);

        return new Employee(id,name,Integer.parseInt(age),address,Long.parseLong(salary));
    }

    public void display(List<Employee> employees) {
        System.out.println("Danh sach nhan vien la: ");
        for(int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            System.out.println(e.toString());
        }
        System.out.println("=================================");
    }

    public String choseEmployeeId(List<Employee> employees){
        display(employees);
        return inputEmployeeId();
    }

    public String showChoseYesOrNoAnswer(){
        String chose;

        do{
            System.out.println("Chose Yes or No [Yes/No]: ");
            chose = scanner.nextLine();
            chose = StandardizedStringUtil.standardizedOneWord(chose);

            if(chose.equals("Yes") || chose.charAt(0) == 'Y') return "Yes";
            if(chose.equals("No") || chose.charAt(0) == 'N') return "No";
        }while(true);
    }

    public String showInputProperty(String propertyName){
        System.out.print("Please input " + propertyName + ": ");
        return scanner.nextLine();
    }
}