package Manager;
import Model.*;
import Validate.*;
import java.util.*;
import java.util.ArrayList;

public class ManagerCustomer {
    ValidateCustomer validateCustomer = new ValidateCustomer();
    ReadAndWriteFile writeReadFile = new ReadAndWriteFile();

    public void addNewCustomer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String name, dateOfBirth, email, typeCustomer, address, gender, id, phoneNumber;
        do {
            System.out.print("\t\tName: ");
            name = sc.nextLine().trim();
            if (!validateCustomer.validateName(name)) {
                System.err.println("---Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tDate of Birth (dd/mm/YYYY): ");
            dateOfBirth = sc.nextLine().trim();
            if (!validateCustomer.validateDateOfBirth(dateOfBirth)) {
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tGender: ");
            gender = sc.nextLine().trim();
            if (!validateCustomer.validateGender(gender)) {
                System.err.println("---Giới tính chỉ chấp nhận Nam, Nữ hoặc Không Xác Định---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tID: ");
            id = sc.nextLine().trim();
            if (!validateCustomer.validateID(id)) {
                System.err.println("---Id Card phải có 12 chữ số và theo định dạng XXX XXX XXX XXX---");
                Thread.sleep(250);
                continue;
            }
            List<Customer> list = writeReadFile.readCustomersFile();
            boolean isContinue = false;
            for (Customer customer : list) {
                if (customer.getId().equals(id)) {
                    System.err.println("---Id Card đã tồn tại---");
                    isContinue = true;
                    Thread.sleep(250);
                    break;
                }
            }
            if (!isContinue) {
                break;
            }
        } while (true);
        do {
            System.out.print("\t\tPhone Number: ");
            phoneNumber = sc.nextLine().trim();
            if (!validateCustomer.validatePhoneNumber(phoneNumber)) {
                System.err.println("---SĐT phải là 10 chữ số viết liền nhau---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        do {
            System.out.print("\t\tEmail: ");
            email = sc.nextLine().trim();
            if (!validateCustomer.validateEmail(email)) {
                System.err.println("---Email phải đúng định dạng abc@abc.abc---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);

        do {
            System.out.print("\t\tType of Customer: ");
            typeCustomer = sc.nextLine();
            if (!validateCustomer.validateTypeOfCustomer(typeCustomer)) {
                System.err.println("---Kiểu khách hàng là 1 trong các loại: Vip1,Vip2,Vip3,,Vip4,Normal---");
                Thread.sleep(250);
                continue;
            }
            break;
        } while (true);
        System.out.print("\t\tAddress: ");
        address = sc.nextLine();
        Customer customer = new Customer(name, dateOfBirth, gender, id, phoneNumber, email, typeCustomer, address);
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        writeReadFile.writeToCSVFile(list, true);
    }

    public List<Customer> showInforAllCustomer() {
        List<Customer> list = writeReadFile.readCustomersFile();
        //Sắp xếp danh sách Customer
        Collections.sort(list,
                new NameCustomerComparato());
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getName().equals(list.get(j).getName())) {
                    if (list.get(i).compareDateOfBirthAcsending(list.get(j)) == 1) {
                        Collections.swap(list, i, j);
                    }
                } else {
                    i = j - 1;
                    break;
                }
            }
        }
        //In ra màn hình
        int i = 1;
        for (Customer customer : list) {
            System.out.print(i++ + ".\t");
            customer.showInfo();
            System.out.println();
        }
        return list;
    }

    public Customer selectCustomerFromFile() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Customer List-----");
        int indexOfCustomer; //vị trí của khách hàng trong danh sách hiển thị
        List<Customer> customerList = writeReadFile.readCustomersFile();
        //danh sách các Customer đã book phòng
        Map map = writeReadFile.readBookingCsv();
        //không hiển thị các Customer đã book phòng
        customerList.removeIf(o -> map.containsValue(o.getId()));
        if (customerList.size() == 0) {
            System.err.println("---Không còn Khách Hàng nào khả dụng---");
            Thread.sleep(250);
            return null;
        } else {
            Collections.sort(customerList, new NameCustomerComparato());
            for (int i = 0; i < customerList.size() - 1; i++) {
                for (int j = i + 1; j < customerList.size(); j++) {
                    if (customerList.get(i).getName().equals(customerList.get(j).getName())) {
                        if (customerList.get(i).compareDateOfBirthAcsending(customerList.get(j)) == 1) {
                            Collections.swap(customerList, i, j);
                        }
                    } else {
                        i = j - 1;
                        break;
                    }
                }
            }
            //In ra màn hình
            int i = 1;
            for (Customer customer : customerList) {
                System.out.print(i++ + ".\t");
                customer.showInfo();
                System.out.println();
            }
        }
        do {
            try {
                Thread.sleep(250);
                System.out.print("Chọn khách hàng: ");
                indexOfCustomer = Integer.parseInt(sc.nextLine());
                if (indexOfCustomer <= 0 || indexOfCustomer > customerList.size() + 1) {
                    System.err.println("---Vui lòng chọn khách hàng trong danh sách---");
                    Thread.sleep(250);
                    continue;
                }
                return customerList.get(indexOfCustomer - 1);
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("---Nhập đúng định dạng là 1 số---");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("---Vui lòng chọn trong danh sách---");
            }
        } while (true);

    }

    public void updateCustomer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        //hiển thị list toàn bộ customer
        System.out.println("---UPDATE CUSTOMER---");
        List<Customer> customerList = showInforAllCustomer();
        //chọn customer trong list để update
        int indexOfCustomer = -1;
        do {
            try {
                System.out.println("\nChoose the customer: ");
                indexOfCustomer = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Nhập định dạng số");
                Thread.sleep(250);
            }
        } while (indexOfCustomer <= 0 || indexOfCustomer > customerList.size());

        //hiển thị thông tin customer dc chọn
        System.out.println("---Thông tin Customer cần update---");
        Customer updateCustomer = customerList.get(indexOfCustomer - 1);
        updateCustomer.showInfo();

        //hiển thị menu các thuộc tính để lựa chọn chỉnh sửa
        System.out.println("Menu chỉnh sửa:");
        System.out.println("\t1. Tên");
        System.out.println("\t2. Giới tính");
        System.out.println("\t3. Số Điện Thoại");
        System.out.println("\t4. Xong");
        int indexOfAttribute = -1;
        do {
            try {
                System.out.println("\nNhập Lựa Chọn: ");
                indexOfAttribute = Integer.parseInt(sc.nextLine());
                switch (indexOfAttribute) {
                    case 1:
                        do {
                            System.out.print(updateCustomer.getName() + " -> ");
                            String updateName = sc.nextLine();
                            if (!validateCustomer.validateName(updateName)) {
                                System.err.println("Tên không hợp lệ");
                                continue;
                            }
                            updateCustomer.setName(updateName);
                            break;
                        } while (true);
                        break;
                    case 2:
                        do {
                            System.out.print(updateCustomer.getGender() + " -> ");
                            String updateGender = sc.nextLine();
                            if (!validateCustomer.validateGender(updateGender)) {
                                System.err.println("Giới tính không hợp lệ");
                                continue;
                            }
                            updateCustomer.setGender(updateGender);
                            break;
                        } while (true);
                        break;
                    case 3:
                        do {
                            System.out.print(updateCustomer.getPhoneNumber() + " -> ");
                            String updatePhoneNumber = sc.nextLine();
                            if (!validateCustomer.validatePhoneNumber(updatePhoneNumber)) {
                                System.err.println("Số Điện Thoại không hợp lệ");
                                continue;
                            }
                            updateCustomer.setPhoneNumber(updatePhoneNumber);
                            break;
                        } while (true);
                        break;
                    default:
                        System.out.println("Vui lòng chọn lại");
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập định dạng số");
                Thread.sleep(250);
            }
        } while (indexOfAttribute != 4);
        writeReadFile.writeToCSVFile(customerList, false);
        System.out.println("UPDATE THÀNH CÔNG");
    }

    public void deleteCustomer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        List<Customer> list = showInforAllCustomer();
        int index = -1;
        do {
            try {
                System.out.print("Chọn Khách Hàng: ");
                index = Integer.parseInt(sc.nextLine());
                if (index > 0 && index <= list.size()){
                    break;
                }
                System.err.println("Không tồn tại khách hàng vừa chọn");
                Thread.sleep(250);
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập định dạng số");
                Thread.sleep(250);
            }
        } while (true);

        System.out.println();
        list.get(index-1).showInfo();
        do {
            System.out.print("Xác nhận xóa: Y/N\t");
            String confirmDel = sc.nextLine();
            if (confirmDel.equals("Y")) {
                list.remove(index - 1);
                writeReadFile.writeToCSVFile(list, false);
                System.out.println("Xóa thành công!");
                return;
            } else {
                if (confirmDel.equals("N")) {
                    return;
                }else {
                    System.err.println("Nhập Y hoặc N!");
                    Thread.sleep(250);
                }
            }
        }while (true);
    }
}
