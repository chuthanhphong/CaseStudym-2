package Model;

public class Employee {
    private String name;            //họ tên
    private int age;                //tuổi
    private String address;         //địa chỉ

    public Employee() {
    }

    public Employee(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + "\t\t\t " + age + " tuổi\t\t\t " + address;
    }
}
