package Model;

public class Room extends Service {
    private String nameEnclosedService;     //Tên dịch vụ kèm theo(massage, kara, thức ăn, nước uống, thuê xe)
    private int amount;                   //Đơn vị
    private float priceService;                    //Giá tiền

    public Room() {
    }

    public Room(String id, String serviceName, float area, float price, int maxPeople, String rentType, int rentTime, String nameEnclosedService, int amount, float priceService) {
        super(id, serviceName, area, price, maxPeople, rentType, rentTime);
        this.nameEnclosedService = nameEnclosedService;
        this.amount = amount;
        this.priceService = priceService;
    }

    public String getNameEnclosedService() {
        return nameEnclosedService;
    }

    public void setNameEnclosedService(String nameEnclosedService) {
        this.nameEnclosedService = nameEnclosedService;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPriceService() {
        return priceService;
    }

    public void setPriceService(float priceService) {
        this.priceService = priceService;
    }

    @Override
    public void showInfo() {
        String str = "\tID: " + super.getId()
                + ",\tloại dịch vụ thuê: " + super.getServiceName()
                + ",\tdiện tích sử dụng = " + super.getArea() + "m2"
                + ",\tchi phí thuê = " + super.getPrice() + "/h"
                + ",\tsố người tối đa = " + super.getMaxPeople()
                + "\n\tkiểu thuê = '" + super.getRentType() + "'"
                + ",\tthời gian thuê = " + super.getRentTime() + " " + super.getRentType()
                + ",\n\tdịch vụ đi kèm: " + this.getNameEnclosedService()
                + ",\tđơn vị: " + this.getAmount()
                + ",\tgiá tiền: " + this.getPriceService();
        System.out.println(str);
    }

    @Override
    public String toString() {
        return super.toString() +"|" + nameEnclosedService + "|" + amount + "|" + priceService;
    }
}
