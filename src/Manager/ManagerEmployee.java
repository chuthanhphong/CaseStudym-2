package Manager;

import CustomerAndService.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ManagerEmployee {
    public static Stack<Employee> getAllEmployee(){
        final  String path ="D:\\Module2\\untitled1\\src\\FileSaving\\Employee.csv";
        Stack<Employee> stack=new Stack<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                String []value =line.split(",");
                Employee employee = new Employee(value[0],Integer.parseInt(value[1]),value[2],value[3]);
                stack.push(employee);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy file");
        }catch (IOException e){
            System.out.println("Lỗi đọc file");
        }
        return stack;
    }
    public static void showAllEmployee(){
        Stack<Employee> stack = getAllEmployee();
        System.out.println("Danh Sách Nhân viên");
        while (!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }
    }
    public static void showListEmployee(Stack<Employee> stack){
        System.out.println("Nhân viên");
        while (!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }
    }
    public static Stack<Employee> searchByName(String name){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> resutl = new Stack<>();
        while (!allEmployee.isEmpty()){
            Employee employee = allEmployee.pop();
            if(employee.getName().equals(name)){
                resutl.push(employee);
            }
        }
        return resutl;
    }
    public static Stack<Employee>searchByage(int age){
        Stack<Employee> allemployee =getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allemployee.isEmpty()){
            Employee employee = getAllEmployee().pop();
            if(employee.getAge()==age){
                result.push(employee);
            }
        }
        return result;
    }
    public static Stack<Employee> searchbyAddress(String address){
        Stack<Employee> allemployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allemployee.isEmpty()){
            Employee employee = getAllEmployee().pop();
            if(employee.getAddress().equals(address)){
                result.push(employee);
            }
        }
        return result;
    }
    public static void showMenu(){
        System.out.println("-----Quản lý Nhân viên-----");
        System.out.println("1.Xem tất cả nhân viên");
        System.out.println("2.Tìm Kiếm Nhân viên theo tên");
        System.out.println("3.Tìm Kiếm Nhân viên theo tuổi");
        System.out.println("4.Tìm Kiếm Nhân viên theo địa chỉ");
        System.out.println("5.Trở về Menu");
    }
}
