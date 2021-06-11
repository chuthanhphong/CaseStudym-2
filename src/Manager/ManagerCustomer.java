package Manager;

import CustomerAndService.Customer;
import Setting.NameCustomerComparator;
import Setting.ReadAndWritreFile;
import Setting.ValidateCustomer;

import java.util.*;

public class ManagerCustomer {
    ValidateCustomer validateCustomer = new ValidateCustomer();
    ReadAndWritreFile readAndWritreFile = new ReadAndWritreFile();

    public void addnewCustomer() throws InterruptedException {//thêm một khách hàng mới
        Scanner sc = new Scanner(System.in);
        String name, dateofBirth, email, typeCustomer, address, gender, id, phonenumber;
        do {
            System.out.println("Nhập tên của bạn");
            name = sc.nextLine().trim();
            if (!validateCustomer.ValidateName(name)) {
                System.out.println("Tên khách hàng không đúng theo mẫu Aa Aa Aa");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.println("Nhập Ngày sinh của bạn (DD/MM/YY)");
            dateofBirth = sc.nextLine().trim();
            if (!validateCustomer.ValidateDateOfBirth(dateofBirth)) {
                continue;
            }
            break;
        } while (true);
        do {
            System.out.println("Nhập giới tính");
            gender = sc.nextLine().trim();
            if (!validateCustomer.validateGender(gender)) {
                System.out.println("Nhập giới tính Nam-Nữ - Không xác định");
                continue;
            }
            break;

        } while (true);
        do {
            System.out.println("Nhập số chứng minh nhân dân");
            id = sc.nextLine().trim();
            if (!validateCustomer.validateID(id)) {
                System.out.println("Số chứng minh nhân dân phải có 9 chữ số XXX XXX XXX");
                continue;
            }
            List<Customer> list = readAndWritreFile.readCustomerFile();
            boolean iscontinue = false;
            for (Customer customer : list) {
                if (customer.getId().equals(id)) {
                    System.out.println("Số chứng minh nhân dân đã tồn tại");
                    iscontinue = true;
                    break;
                }
            }
            if (!iscontinue) {
                break;
            }
        } while (true);
        do {
            System.out.println("Nhập số điện thoại");
            phonenumber = sc.nextLine().trim();
            if (!validateCustomer.validatePhoneNumber(phonenumber)) {
                System.out.println("Số điện thoại là 10 chữ số bắt đầu từ số 0");
                continue;
            }
            break;
        } while (true);
        do {
            System.out.println("Nhập địa chỉ Email");
            email = sc.nextLine().trim();
            if (!validateCustomer.validaEmail(email)) {
                System.out.println("Email không đúng định dạng abc@abc.abc");
            }
            break;
        } while (true);

        do {
            System.out.println("Bạn thuộc loại khách hàng nào : vip-bình dân-vãng lai");
            typeCustomer = sc.nextLine().trim();
            if (!validateCustomer.validateTypeOfCustomer(typeCustomer)) {
                System.out.println("Kiểu khách hàng là vip ,bình dân, vãng lai");
            }
            break;
        } while (true);
        System.out.println("Nhập địa chỉ ");
        address = sc.nextLine();
        Customer customer = new Customer(name, dateofBirth, gender, id, phonenumber, email, typeCustomer, address);
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        readAndWritreFile.writeTofile(list, true);
    }

    public List<Customer> showInforAllCustomer() {
        List<Customer> list = readAndWritreFile.readCustomerFile();
        Collections.sort(list, new NameCustomerComparator());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getName().equals(list.get(j).getName())) {
                    if (list.get(i).compareDateofBirth(list.get(j)) == 1) {
                        Collections.swap(list, i, j);
                    }
                } else {
                    i = j - 1;
                    break;
                }
            }
        }
        int i = 1;
        for (Customer customer : list) {
            System.out.println(i+".\t");
            customer.showInfo();
            System.out.println();
        }
        return list;
    }

    public Customer selectCustomerFromFile() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Danh Sách khách Hàng là : ");
        int indexOfCustomer;
        List<Customer> customerList = readAndWritreFile.readCustomerFile();
        Map map = readAndWritreFile.readBookcsv();
        customerList.removeIf(customer -> map.containsValue(customer.getId()));
        if (customerList.size() == 0) {
            System.out.println("Không còn khách hàng nào khả dụng");
            Thread.sleep(250);
            return null;
        } else {
            Collections.sort(customerList, new NameCustomerComparator());
            for (int i = 0; i < customerList.size(); i++) {
                for (int j = i + 1; j < customerList.size(); j++) {
                    if (customerList.get(i).getName().equals(customerList.get(j).getName())) {
                        if (customerList.get(i).compareDateofBirth(customerList.get(j)) == 1) {
                            Collections.swap(customerList, i, j);
                        }
                    } else {
                        i = j - 1;
                        break;
                    }
                }
            }
            int i = 1;
            for (Customer customer : customerList) {
                System.out.println(i++ + ".\t");
                customer.showInfo();
                System.out.println();
            }
        }
        do {
            try {
                System.out.println("Chọn Khách Hàng");
                indexOfCustomer = Integer.parseInt(sc.nextLine());
                if (indexOfCustomer <= 0 || indexOfCustomer > customerList.size()) {
                    System.out.println("Khách Hàng không nằm trong danh sách");
                }
                return customerList.get(indexOfCustomer - 1);

            }catch (NumberFormatException exception){
                System.out.println("Nhập đúng định dạng là 1 số");}
            catch (IndexOutOfBoundsException e){
                System.out.println("Chọn khách hàng trong danh sách");
            }
        }while (true);

    }
    public void EditCustomer()throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Chỉnh Sửa Danh Sách");
        List<Customer> customerList = showInforAllCustomer();
        int indexOfCustomer = -1;
        do {
            try {
                System.out.println("Chọn Khách Hàng :");
                indexOfCustomer = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Nhập định đạng số");
            }
        }while (indexOfCustomer<=0||indexOfCustomer>customerList.size());
        //hiển thị thông tin customer dc chọn
        System.out.println("Thông tin khách hàng cần chỉnh sửa");
        Customer updateCustomer = customerList.get(indexOfCustomer-1);
        updateCustomer.showInfo();
        //hiển thị menu chỉnh sửa
        System.out.println("Edit");
        System.out.println("1.Họ Và Tên");
        System.out.println("2.Giới Tính");
        System.out.println("3.Số Điện Thoại");
        System.out.println("4. Xong");
        int index = -1;
        do {
            try {
                System.out.println("Nhập Lựa Chọn");
                index =Integer.parseInt(sc.nextLine());
                switch (index){
                    case 1:
                        do {
                            System.out.println(updateCustomer.getName() + "->");
                            String updameName = sc.nextLine();
                            if(!validateCustomer.ValidateName(updameName)){
                                System.out.println("Tên không hợp lệ");
                                continue;
                            }
                            updateCustomer.setName(updameName);
                            break;
                        }while (true);
                        break;
                    case 2:
                        do {
                            System.out.println(updateCustomer.getGender()+ "->");
                            String updateGender = sc.nextLine();
                            if(!validateCustomer.validateGender(updateGender)){
                                System.out.println("Giới tính không hợp lệ");
                                continue;
                            }
                            updateCustomer.setGender(updateGender);
                            break;
                        }while (true);
                        break;
                    case 3:
                        do {
                            System.out.println(updateCustomer.getPhoneNumber()+"->");
                            String updatephonenumber = sc.nextLine();
                            if(!validateCustomer.validatePhoneNumber(updatephonenumber)){
                                System.out.println("Số điện thoại không đúng");
                            }
                            updateCustomer.setPhoneNumber(updatephonenumber);
                            break;
                        }while (true);
                        break;
                    default:
                        System.out.println("Vui Lòng chọn lại");

                }
            }catch (NumberFormatException e){
                System.out.println("Nhập định dạng là số");
            }
        }while (index!=4);
        readAndWritreFile.writeTofile(customerList,false);
        System.out.println("Chỉnh Sửa thành công");
    }
    public void deleteCustomer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        List<Customer> list = showInforAllCustomer();
        int index = -1;
        do {
            try {
                System.out.print("Chọn Customer: ");
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
            System.out.print("Xác nhận xóa: 1.Xóa ;2.Không");
            int confirmDel = sc.nextInt();
            if (confirmDel==1) {
                list.remove(index - 1);
                readAndWritreFile.writeTofile(list, false);
                System.out.println("Xóa thành công!");
                return;
            } else {
                if (confirmDel==2) {
                    return;
                }else {
                    System.err.println("Nhập 1 hoặc 2!");
                    Thread.sleep(250);
                }
            }
        }while (true);
    }
}
