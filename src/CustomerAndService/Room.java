package CustomerAndService;

public class Room extends Service {
    private String nameofService;// spa,tenis, cassino, food, drink;
    private int unitService;// đơn vị tính
    private int priceService;// tiền dịch vụ

    public Room() {
    }


    public Room(String id, String serviceName, int area, int price, int maxpeople, String renType, int rentime, String nameofService, int unit, int priceService) {
        super(id, serviceName, area, price, maxpeople, renType, rentime);
        this.nameofService = nameofService;
        this.unitService = unit;
        this.priceService = priceService;
    }

    public String getNameofService() {
        return nameofService;
    }

    public void setNameofService(String nameofService) {
        this.nameofService = nameofService;
    }

    public int getUnit() {
        return unitService;
    }

    public void setUnit(int unit) {
        this.unitService = unit;
    }

    public int getPriceService() {
        return priceService;
    }

    public void setPriceService(int priceService) {
        this.priceService = priceService;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + nameofService + "|" + unitService + "|" + priceService;



    }

    @Override
    public void showInfo() {
        String str = "\tID: " + super.getId()
                + ",\tloại dịch vụ thuê: " + super.getServiceName()
                + ",\tdiện tích sử dụng = " + super.getArea() + "m2"
                + ",\tchi phí thuê = " + super.getPrice() + "/h"
                + ",\tsố người tối đa = " + super.getMaxpeople()
                + "\tkiểu thuê = '" + super.getRenType() + "'"
                + ",\tthời gian thuê = " + super.getRentime() + " " + super.getRenType()
                + ",\tdịch vụ đi kèm: " + this.getNameofService()
                + ",\tđơn vị: " + this.getUnit()+
                ",\tgiá tiền: " + this.getPriceService();
        System.out.println(str);
    }
}
