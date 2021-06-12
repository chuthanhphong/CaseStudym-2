package Main;

import java.util.*;
import Manager.*;
import Model.*;
import Validate.*;

public class MainControler {
        static ManagerService managerService = new ManagerService();
        static ManagerCustomer managerCustomer = new ManagerCustomer();

        //1.Add service 2.Show service 3.Add customer 4.Show customer
        //5.Add booking 6.Show Employee 7.Exit
        public static void displayMainMenu() {
            System.out.println();
            int lengthOfFrame = 40;
            for (int i = 1; i <= lengthOfFrame; i++) {
                if (i == 19) {
                    System.out.print("MENU");
                    i = 22;
                } else {
                    System.out.print("-");
                }
            }
            String str0 = "|\t0. Thoát";
            System.out.print("\n" + str0);
            for (int i = str0.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str1 = "|\t1. Thêm Dịch Vụ";
            System.out.print("\n" + str1);
            for (int i = str1.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str2 = "|\t2. Xem Dịch Vụ";
            System.out.print("\n" + str2);
            for (int i = str2.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str3 = "|\t3. Thêm Khách Hàng Mới";
            System.out.print("\n" + str3);
            for (int i = str3.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str4 = "|\t4. Cập Nhật Danh Sách Khách Hàng";
            System.out.print("\n" + str4);
            for (int i = str4.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str5 = "|\t5. Xóa Khách Hàng";
            System.out.print("\n" + str5);
            for (int i = str5.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str6 = "|\t6. Xem Thông Tin Khách Hàng";
            System.out.print("\n" + str6);
            for (int i = str6.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str7 = "|\t7. Đặt Chỗ mới";
            System.out.print("\n" + str7);
            for (int i = str7.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str8 = "|\t8. Xem Thông Tin Nhân Viên";
            System.out.print("\n" + str8);
            for (int i = str8.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("|");

            String str9 = "|\t9. Quản Lý Nhân viên";
            System.out.print("\n" + str9);
            for (int i = str9.length() + 1; i < lengthOfFrame - 2; i++) {
                System.out.print(" ");
            }
            System.out.println("|");

            for (int i = 1; i <= lengthOfFrame; i++) {
                System.out.print("-");
            }
            System.out.println();
        }

        public static void addNewServies() {
            boolean isAddContinue;
            do {
                try {
                    System.out.println("Thêm Dịch Vụ Mới");
                    System.out.println("\t1. Thêm Biệt Thự Mới\n" +
                            "\t2. Thêm Nhà Mới \n" +
                            "\t3. Thêm Phòng Mới \n" +
                            "\t4. Trở về Menu \n");
                    Thread.sleep(250);
                    Scanner sc = new Scanner(System.in);
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            managerService.addVilla();
                            isAddContinue = false;
                            break;
                        case 2:
                            managerService.addHouse();
                            isAddContinue = false;
                            break;
                        case 3:
                            managerService.addRoom();
                            isAddContinue = false;
                            break;
                        case 4:
                            isAddContinue = false;
                            break;
                        default:
                            System.err.println("Lựa Chọn các tính năng trong menu");
                            isAddContinue = true;
                            break;
                    }
                } catch (NumberFormatException | InterruptedException numberFormatException) {
                    System.err.println("Nhập sai ,Vui Lòng Nhập lại");
                    isAddContinue = true;
                }
            } while (isAddContinue);
        }

        public static void showServices() {
            boolean isShowContinue;
            do {
                try {
                    System.out.println("Xem Các Dịch Vụ");
                    System.out.println("\t1. Xem Tất Cả biệt thự\n" +
                            "\t2. Xem tất cả các nhà\n" +
                            "\t3. Xem tất cả các phòng\n" +
                            "\t4. Trở về Menu\n");
                    Scanner sc = new Scanner(System.in);
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            managerService.showAllVillas();
                            isShowContinue = false;
                            break;
                        case 2:
                            managerService.showAllHouses();
                            isShowContinue = false;
                            break;
                        case 3:
                            managerService.showAllRooms();
                            isShowContinue = false;
                            break;
                        case 4:
                            isShowContinue = false;
                            break;
                        default:
                            System.err.println("Lựa Chọn các tính năng có trong menu");
                            isShowContinue = true;
                            break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.err.println("Nhập sai,Vui Lòng Nhập lại");
                    isShowContinue = true;
                }
            } while (isShowContinue);
        }

        public static void addNewCustomer() {
            try {
                managerCustomer.addNewCustomer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void showCustomers() {
            try {
                managerCustomer.showInforAllCustomer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void addNewBooking() throws InterruptedException {
            Scanner sc = new Scanner(System.in);
            //Chọn khách hàng
            System.out.println("-----Danh Sách Khách Hàng-----");
            int indexOfCustomer; //vị trí của khách hàng trong danh sách hiển thị
            Customer customer = managerCustomer.selectCustomerFromFile();
            if (customer == null) {
                return;
            }
            //Chọn loại dịch vụ
            System.out.println("\nChọn loại dịch vụ muốn book: ");
            System.out.println("\t1. Biệt Thự" +
                    "\t2. Nhà" +
                    "\t3. Phòng");
            int chooseTypeOfService;
            do {
                try {
                    Thread.sleep(250);
                    chooseTypeOfService = Integer.parseInt(sc.nextLine());
                    if (chooseTypeOfService < 1 || chooseTypeOfService > 3) {
                        System.err.println("---Vui lòng chọn chức năng trong Menu---");
                        Thread.sleep(250);
                        continue;
                    }
                    break;
                } catch (NumberFormatException | InterruptedException e) {
                    System.err.println("---Nhập đúng định dạng là 1 số---");
                }
            } while (true);

            //Đặt phòng
            ReadAndWriteFile writeAndReadFunc = new ReadAndWriteFile();
            switch (chooseTypeOfService) {
                case 1:
                    Villa villaBooked = managerService.bookVilla();
                    if (villaBooked == null) {
                        System.err.println("---Không còn Biệt Thự trống để đặt ---");
                        Thread.sleep(250);
                        return;
                    }
                    writeAndReadFunc.writeBookingCsv(villaBooked.getId(), customer.getId());
                    customer.setServiceUsing(villaBooked);
                    break;
                case 2:
                    House houseBooked = managerService.bookHouse();
                    if (houseBooked == null) {
                        System.err.println("---Không còn Nhà trống để đặt ---");
                        Thread.sleep(250);
                        return;
                    }
                    writeAndReadFunc.writeBookingCsv(houseBooked.getId(), customer.getId());
                    customer.setServiceUsing(houseBooked);
                    break;
                case 3:
                    Room roomBooked = managerService.bookRoom();
                    if (roomBooked == null) {
                        System.err.println("---Không còn Phòng trống để đặt phòng---");
                        Thread.sleep(250);
                        return;
                    }
                    writeAndReadFunc.writeBookingCsv(roomBooked.getId(), customer.getId());
                    customer.setServiceUsing(roomBooked);
                    break;
                default:
                    System.err.println("---Chọn chức năng có trong Menu---");
            }
            customer.showInfo();
            //Ghi đè lại vào file Customer để thay đổi thuộc tính Dịch vụ đang sử dụng
            List<Customer> list = writeAndReadFunc.readCustomersFile();
            for (Customer o : list) {
                if (o.getId().equals(customer.getId())) {
                    list.set(list.indexOf(o), customer);
                }
            }
            writeAndReadFunc.writeToCSVFile(list, false);
        }

        public static Map<Integer, Employee> showEmployee() {
            ReadAndWriteFile writeAndReadFunc = new ReadAndWriteFile();
            Map<Integer, Employee> map = writeAndReadFunc.readEmployeeFile();
            Set<Integer> set = map.keySet();
            for (Integer value : set) {
                System.out.println(value + ". " + map.get(value).toString());
            }
            return map;
        }

        public static void tuHoSo() throws InterruptedException {
            do {
                Scanner sc = new Scanner(System.in);
                ManagerEmployee.showMenu();
                int chooseFunc;
                do {
                    try {
                        chooseFunc = Integer.parseInt(sc.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("---Vui lòng nhập kí tự số---");
                        Thread.sleep(250);
                    }
                } while (true);
                ValidateCustomer validateCustomer = new ValidateCustomer();
                switch (chooseFunc) {
                    case 1:
                        ManagerEmployee.showAllEmployee();
                        break;
                    case 2:
                        do {
                            System.out.print("Tên cần tìm: ");
                            String name = sc.nextLine();
                            if (!validateCustomer.validateName(name)) {
                                System.err.println("---Định dạng tên không hợp lệ---");
                                Thread.sleep(250);
                                continue;
                            }
                            Stack<Employee> stack =ManagerEmployee.searchByName(name);
                            if (stack.empty()) {
                                System.err.println("---Không tìm thấy yêu cầu---");
                                Thread.sleep(250);
                            } else {
                                ManagerEmployee.showListEmployee(stack);
                            }
                            break;
                        } while (true);
                        break;
                    case 3:
                        do {
                            try {
                                System.out.print("Tuổi cần tìm: ");
                                int age = Integer.parseInt(sc.nextLine());
                                Stack<Employee> stack = ManagerEmployee.searchByAge(age);
                                if (stack.empty()) {
                                    System.err.println("---Không tìm thấy yêu cầu---");
                                    Thread.sleep(250);
                                } else {
                                    ManagerEmployee.showListEmployee(stack);
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.err.println("---Nhập định dạng là 1 kí tự---");
                                Thread.sleep(250);
                            }
                        } while (true);
                        break;
                    case 4:
                        do {
                            System.out.print("Địa chỉ cần tìm: ");
                            String address = sc.nextLine();
                            if (!validateCustomer.validateName(address)) {
                                System.err.println("---Định dạng địa chỉ không hợp lệ---");
                                Thread.sleep(250);
                                continue;
                            }
                            Stack<Employee> stack = ManagerEmployee.searchByAddress(address);
                            if (stack.empty()) {
                                System.err.println("---Không tìm thấy yêu cầu---");
                                Thread.sleep(250);
                            } else {
                                ManagerEmployee.showListEmployee(stack);
                            }
                            break;
                        } while (true);
                        break;
                    case 5:
                        return;
                    default:
                        System.err.println("---Chức năng không có trong danh sách---");
                        Thread.sleep(250);
                }
            } while (true);
        }

        public static void updateCustomer(){
            try {
                managerCustomer.updateCustomer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void deleteCustomer() {
            try {
                managerCustomer.deleteCustomer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
