package ManagerAll;

import CusTomerAndService.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ManagerEmployee {
    public static Stack<Employee> getAllEmployee(){
        final String PATH = "D:\\Module2\\untitled1\\untitled\\src\\FileManager\\Employee.csv";
        Stack<Employee> stack = new Stack<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split("\\|");
                Employee employee = new Employee(words[0], Integer.parseInt(words[1]), words[2]);
                stack.push(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("---Không tìm thấy file!---");
        } catch (IOException ioException) {
            System.err.println("---Lỗi đọc file!---");
        }
        return stack;
    }

    public static void showAllEmployee(){
        Stack<Employee> stack = getAllEmployee();
        System.out.println("------Danh sách nhân viên------");
        while (!stack.empty()) {
            System.out.println(stack.pop().toString());
        }
    }

    public static void showListEmployee(Stack<Employee> stack){
        System.out.println("-----Nhân viên-----");
        while (!stack.empty()) {
            System.out.println(stack.pop().toString());
        }
    }

    public static Stack<Employee> searchByName(String name){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allEmployee.empty()){
            Employee employee = allEmployee.pop();
            if (employee.getName().equals(name)){
                result.push(employee);
            }
        }
        return result;
    }

    public static Stack<Employee> searchByAge(int age){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allEmployee.empty()){
            Employee employee = allEmployee.pop();
            if (employee.getAge() == age){
                result.push(employee);
            }
        }
        return result;
    }

    public static Stack<Employee> searchByAddress(String address){
        Stack<Employee> allEmployee = getAllEmployee();
        Stack<Employee> result = new Stack<>();
        while (!allEmployee.empty()){
            Employee employee = allEmployee.pop();
            if (employee.getAddress().equals(address)){
                result.push(employee);
            }
        }
        return result;
    }

    public static void showMenu(){
        System.out.println("---Quản lý Nhân Viên---");
        System.out.println("\t1. Xem Tất Cả Nhân Viên");
        System.out.println("\t2. Tìm Kiếm Nhân Viên Theo Tên");
        System.out.println("\t3. Tìm Kiếm Nhân Viên Theo Tuổi");
        System.out.println("\t4. Tìm Kiếm Nhân Viên Theo Địa Chỉ");
        System.out.println("\t5. Trở về Menu Chính");
    }
}
