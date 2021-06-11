package Main;

import CustomerAndService.Customer;
import CustomerAndService.Employee;
import CustomerAndService.House;
import CustomerAndService.Room;
import Manager.ManagerCustomer;
import Manager.ManagerEmployee;
import Manager.ManagerService;
import Setting.ReadAndWritreFile;
import Setting.ValidateCustomer;

import java.util.*;

public class MenuMain {
    static ManagerService managerService = new ManagerService();
    static ManagerCustomer managerCustomer = new ManagerCustomer();
    static ManagerEmployee managerEmployee = new ManagerEmployee();

    public static void displayMenu() {
        int lengh = 40;
        for (int i = 1; i <= lengh; i++) {
            if (i == 19) {
                System.out.println("Menu");
                i = 22;
            } else {
                System.out.println("----");
            }
        }
        String str0 = "0.Thoát";
        System.out.println(str0);
        for (int i = str0.length() - 1; i < lengh - 2; i++) {
            System.out.println("");
        }
        System.out.println("|");
        String str1 = "1.Thêm Dịch vụ mới";
        System.out.println("\n" + str1);
        for (int i = str1.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str2 = "2.Xem Dịch Vụ";
        System.out.println("\n" + str2);
        for (int i = str2.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str3 = "3.Thêm Khách Hàng Mới";
        System.out.println("\n" + str3);
        for (int i = str3.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str4 = "4.Chỉnh Sửa Khách Hàng";
        System.out.println("\n" + str4);
        for (int i = str4.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str5 = "5.Xóa Khách Hàng";
        System.out.println("\n" + str5);
        for (int i = str5.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str6 = "6.Xem thông tin của Khách Hàng";
        System.out.println("\n" + str6);
        for (int i = str6.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str7 = "7. Thêm Đặt Lịch mới";
        System.out.println("\n" + str7);
        for (int i = str7.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str8 = "8. Xem thông tin nhân viên";
        System.out.println("\n" + str8);
        for (int i = str8.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
        String str9 = "9.Stack";
        System.out.println("\n" + str9);
        for (int i = str9.length() + 1; i < lengh - 2; i++) {
            System.out.println(" ");
        }
        System.out.println("|");
    }

    public static void addNewServices() {
        boolean isContinue;
        do {
            try {
                System.out.println("------Thêm Dịch Vụ Mới-------");
                System.out.println("1.Thêm Căn hộ mới");
                System.out.println("2.Thêm Phòng mới");
                System.out.println("3.Trở về");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        managerService.addHouse();
                        isContinue = false;
                        break;
                    case 2:
                        managerService.addRoom();
                        isContinue = false;
                        break;
                    case 3:
                        isContinue = false;
                        break;
                    default:
                        System.out.println("Lựa Chọn Tính năng trong menu");
                        isContinue = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui Lòng Nhập đúng số");
                isContinue = true;
            }
        } while (isContinue);
    }

    public static void showServices() {
        boolean isshowcontinue;
        do {
            try {
                System.out.println("-----Xem Dịch Vụ-------");
                System.out.println("1.Xem tất cả căn hộ");
                System.out.println("2.Xem tất cả các phòng");
                System.out.println("3.Xem tất cả các căn hộ không trùng nhau");
                System.out.println("4.Xem tất cả các phòng không trùng nhau");
                System.out.println("5.Trở về");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        managerService.showAllHouse();
                        isshowcontinue = false;
                        break;
                    case 2:
                        managerService.showAllRoom();
                        isshowcontinue = false;
                        break;
                    case 3:
                        managerService.showHousenotDulipcateName();
                        isshowcontinue = false;
                        break;
                    case 4:
                        managerService.showRoomnotDulipcateName();
                        isshowcontinue = false;
                        break;
                    case 5:
                        isshowcontinue = false;
                        break;
                    default:
                        System.out.println("Chọn Tính năng trên Menu");
                        isshowcontinue = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui Lòng Nhập số trên menu");
                isshowcontinue = true;
            }
        } while (isshowcontinue);
    }

    public static void addNewCustomer() {
        try {
            managerCustomer.addnewCustomer();
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }

    public static void showCustomers() {
        try {
            managerCustomer.showInforAllCustomer();
        } catch (Exception e) {
            System.out.println("Lỗi Hiển Thị");
        }
    }

    public static void addNewBooking() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh Sách Khách Hàng");
        int index;
        Customer customer = managerCustomer.selectCustomerFromFile();
        if (customer == null) {
            return;
        }
        System.out.println("Chọn Loại dịch vụ muốn đặt");
        System.out.println("1.Đặt 1 căn hộ");
        System.out.println("2.Đặt 1 phòng");
        int choice;
        do {
            try {
                Thread.sleep(250);
                choice = sc.nextInt();
                if (choice < 1 | choice > 2) {
                    System.out.println("Vui Lòng chọn chức năng trong menu");
                    continue;
                }
                break;
            } catch (NumberFormatException | InterruptedException exception) {
                System.out.println("Nhập định dạng là 1 số ");
            }
        } while (true);
        ReadAndWritreFile readAndWritreFile = new ReadAndWritreFile();
        switch (choice) {
            case 1:
                House housebook = managerService.bookHouse();
                if (housebook == null) {
                    System.out.println("Không còn chỗ trống để đặt");
                    return;
                }
                readAndWritreFile.writeBookcsv(housebook.getId(), customer.getId());
                customer.setServiceUsing(housebook);
                break;
            case 2:
                Room roombook = managerService.bookRoom();
                if (roombook == null) {
                    System.out.println("Không có chỗ trống để đặt");
                    return;
                }
                readAndWritreFile.writeBookcsv(roombook.getId(), customer.getId());
                customer.setServiceUsing(roombook);
                break;
            default:
                System.out.println("Chọn chức năng trong menu");
        }
        customer.showInfo();
        List<Customer> list = readAndWritreFile.readCustomerFile();
        for (Customer customer1 : list) {
            if (customer1.getId().equals(customer.getId())) {
                list.set(list.indexOf(customer1), customer);
            }
        }
        readAndWritreFile.writeTofile(list, false);
    }

    public static Map<Integer, Employee> showEmployee() {
        ReadAndWritreFile readAndWritreFile = new ReadAndWritreFile();
        Map<Integer, Employee> map = readAndWritreFile.readEmployeecsv();
        Set<Integer> set = map.keySet();
        for (Integer value : set) {
            System.out.println(value + "." + map.get(value).toString());
        }
        return map;
    }

    public static void EmployeeMNG() {
        do {
            Scanner sc = new Scanner(System.in);
            ManagerEmployee.showMenu();
            int choice;
            do {
                try {
                    choice = sc.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Nhập ký tự là số để tiếp tục");
                }
            } while (true);
            ValidateCustomer validateCustomer = new ValidateCustomer();
            switch (choice) {
                case 1:
                    ManagerEmployee.showAllEmployee();
                    break;
                case 2:
                    do {
                        System.out.println("Nhập tên cần tìm");
                        String name = sc.nextLine();
                        if (!validateCustomer.ValidateName(name)) {
                            System.out.println("Định dạng tên không đúng");
                            continue;
                        }
                        Stack<Employee> stack = ManagerEmployee.searchByName(name);
                        if (stack.isEmpty()) {
                            System.out.println("Không tìm thấy yêu cầu");

                        } else {
                            ManagerEmployee.showListEmployee(stack);
                        }
                        break;
                    } while (true);
                    break;
                case 3:
                    do {
                        try {
                            System.out.println("Nhập tuổi cần tìm");
                            int age = sc.nextInt();
                            Stack<Employee> stack = ManagerEmployee.searchByage(age);
                            if (stack.isEmpty()) {
                                System.out.println("không tìm thấy yêu cầu");
                            } else {
                                ManagerEmployee.showListEmployee(stack);
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Nhập định dạng là 1 ký tự");
                        }
                    } while (true);
                    break;
                case 4:
                    do {
                        System.out.println("Nhập địa chỉ cần tìm");
                        String address = sc.nextLine();
                        Stack<Employee> stack = ManagerEmployee.searchbyAddress(address);
                        if (stack.isEmpty()) {
                            System.out.println("Không tìm thấy nhân viên có địa chỉ này");
                        } else {
                            ManagerEmployee.showListEmployee(stack);
                        }
                        break;
                    } while (true);
                    break;
                default:
                    System.out.println("Chức năng không có trong danh sách");

            }

        } while (true);
    }
    public static void updateCustomer(){
        try {
            managerCustomer.EditCustomer();
        }catch (InterruptedException e){
            System.out.println("Lỗi Hiển thị");
        }
    }
    public static void deleteCustomer(){
        try {
            managerCustomer.deleteCustomer();
        }catch (InterruptedException e){
            System.out.println("Lỗi Hiển Thị");
        }
    }
}
