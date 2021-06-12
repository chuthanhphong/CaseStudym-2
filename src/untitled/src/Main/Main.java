package Main;
import java.util.Scanner;
import Main.*;
public class Main {
    static final int EXIT = 0;
    static final int ADD_SERVICE = 1;
    static final int SHOW_SERVICE = 2;
    static final int ADD_CUSTOMER = 3;
    static final int UPDATE_CUSTOMER = 4;
    static final int DELETE_CUSTOMER = 5;
    static final int SHOW_CUSTOMER = 6;
    static final int ADD_BOOKING = 7;
    static final int SHOW_EMPLOYEE = 8;
    static final int EMPLOYEE_PROFILE = 9;


    public static void main(String[] args) {

        {
            Scanner sc = new Scanner(System.in);
            do {
                try {
                    //Hiển thị MENU chức năng
                    MainControler.displayMainMenu();
                    //chọn chức năng
                    System.out.print("Chọn tính năng: ");
                    int chucNang = Integer.parseInt(sc.nextLine());
                    switch (chucNang) {
                        case EXIT:
                            System.exit(1);
                        case ADD_SERVICE:
                            MainControler.addNewServies();
                            break;
                        case SHOW_SERVICE:
                            MainControler.showServices();
                            break;
                        case ADD_CUSTOMER:
                            MainControler.addNewCustomer();
                            break;
                        case UPDATE_CUSTOMER:
                            MainControler.updateCustomer();
                            break;
                        case DELETE_CUSTOMER:
                            MainControler.deleteCustomer();
                            break;
                        case SHOW_CUSTOMER:
                            MainControler.showCustomers();
                            break;
                        case ADD_BOOKING:
                            MainControler.addNewBooking();
                            break;
                        case SHOW_EMPLOYEE:
                            MainControler.showEmployee();
                            break;
                        case EMPLOYEE_PROFILE:
                            MainControler.tuHoSo();
                            break;
                        default:
                            System.err.println("Lựa Chọn Các Tính Năng Có Trong Menu");
                    }
                } catch (NumberFormatException | InterruptedException e) {
                    System.err.println("Vui Lòng Nhập Vào Một Số");
                }
            } while (true);
        }
    }

}