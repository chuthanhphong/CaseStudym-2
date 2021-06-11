package CustomerAndService;

public class Customer {
    private String name;
    private String dateofBirth;
    private String gender;
    private String id;
    private String phoneNumber;
    private String email;
    private String typeofCustomer; // loại khách hàng: vip, bình dân, vãng lai
    private String address;
    private Service serviceUsing;

    public Customer(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
    }

    public Customer(String name, String dateofBirth, String gender, String id, String phoneNumber, String email, String typeofCustomer, String address, Service serviceUsing) {
        this.name = name;
        this.dateofBirth = dateofBirth;
        this.gender = gender;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeofCustomer = typeofCustomer;
        this.address = address;
        this.serviceUsing = serviceUsing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
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

    public String getTypeofCustomer() {
        return typeofCustomer;
    }

    public void setTypeofCustomer(String typeofCustomer) {
        this.typeofCustomer = typeofCustomer;
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
                "," + dateofBirth +
                "," + gender +
                "," + id +
                "," + phoneNumber +
                "," + email +
                "," + typeofCustomer +
                "," + address +
                "," + (this.serviceUsing == null ? "null" : this.serviceUsing.getId());
    }
    public void showInfo(){
        String str = "-----KHÁCH HÀNG: " + this.name + "-----" +
                "\nNgày sinh: " + this.dateofBirth +
                ", giới tính: " + this.gender +
                ", số CMND: " + this.id +
                ", số ĐT: " + this.phoneNumber +
                ", email: " + this.email +
                ", địa chỉ: " + this.address +
                ",\n\tloại KH: " + this.typeofCustomer;
        System.out.println(str);
        if(this.serviceUsing==null){
            System.out.println("Khách hàng chưa sử dụng dịch vụ nào");
        }else {
            System.out.println("Khách hàng đang sử dụng dịch vụ :");
            this.serviceUsing.showInfo();
        }
    }
    public int compareDateofBirth(Customer customer){
        // dd//mm//yy
        int thisyear = Integer.parseInt(this.dateofBirth.substring(6,10));
        int customerYear = Integer.parseInt(customer.getDateofBirth().substring(6,10));
        if(thisyear>customerYear){
            return 1;
        }else if(thisyear==customerYear) {
            int thisMounth = Integer.parseInt(this.getDateofBirth().substring(3, 5));
            int customerMounth = Integer.parseInt(customer.getDateofBirth().substring(3, 5));
            if(thisMounth>customerMounth){
                return 1;
            }else if(thisMounth==customerMounth){
                int thisDay =Integer.parseInt(this.getDateofBirth().substring(0,2));
                int customerDay = Integer.parseInt(customer.getDateofBirth().substring(0,2));
                if(thisDay>customerDay){
                    return 1;
                }
            }
        }
        return -1;
    }
}
