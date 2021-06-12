package Model;

public class Customer {
    private String name;            //tên
    private String dateOfBirth;     //ngày sinh
    private String gender;         //giới tính
    private String id;                 //số CMND
    private String phoneNumber;        //số điện thoại
    private String email;           //email
    private String typeCustomer;    //loại khách: Diamond, Platinium, Gold, Silver, Member
    private String address;         //địa chỉ
    private Service serviceUsing;  //dịch vụ sử dụng

    public Customer(String name, String dateOfBirth, String gender, String id, String phoneNumber, String email, String typeCustomer, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.serviceUsing = null;
    }

    public Customer(String name, String dateOfBirth, String gender, String id, String phoneNumber, String email, String typeCustomer, String address, Service serviceUsing) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.serviceUsing = serviceUsing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getServiceUsing() {
        return serviceUsing;
    }

    public void setServiceUsing(Service serviceUsing) {
        this.serviceUsing = serviceUsing;
    }

    @Override
    public String toString() {
        return name +
                "|" + dateOfBirth +
                "|" + gender +
                "|" + id +
                "|" + phoneNumber +
                "|" + email +
                "|" + typeCustomer +
                "|" + address +
                "|" + (this.serviceUsing == null ? "null" : this.serviceUsing.getId());
    }

    public void showInfo() {
        System.out.println("-----KHÁCH HÀNG: " + this.name + "-----" +
                "\nNgày sinh: " + this.dateOfBirth +
                ", giới tính: " + this.gender +
                ", số CMND: " + this.id +
                ", số ĐT: " + this.phoneNumber +
                ", email: " + this.email +
                ", địa chỉ: " + this.address +
                ",\n\tloại KH: " + this.typeCustomer);
        if (this.serviceUsing == null) {
            System.out.println("\tHiện tại chưa sử dụng bất cứ dịch vụ nào");
        } else {
            System.out.println("\tDịch vụ đang sử dụng:");
            this.serviceUsing.showInfo();
        }
    }

    public int compareDateOfBirthAcsending(Customer customer) {
        //dd/mm/yyyy
        int thisYear = Integer.parseInt(this.dateOfBirth.substring(6, 10));
        int customerYear = Integer.parseInt(customer.getDateOfBirth().substring(6, 10));
        if (thisYear > customerYear) {
            return 1;
        } else if (thisYear == customerYear) {
            int thisMonth = Integer.parseInt(this.dateOfBirth.substring(3, 5));
            int customerMonth = Integer.parseInt(customer.getDateOfBirth().substring(3, 5));
            if (thisMonth > customerMonth) {
                return 1;
            } else if (thisMonth == customerMonth) {
                int thisDay = Integer.parseInt(this.dateOfBirth.substring(0, 2));
                int customerDay = Integer.parseInt(customer.getDateOfBirth().substring(0, 2));
                if (thisDay > customerDay) {
                    return 1;
                }
            }
        }
        return -1;
    }


}

