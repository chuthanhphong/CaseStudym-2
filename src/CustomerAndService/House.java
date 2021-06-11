package CustomerAndService;

public class House extends Service {
    private String kinhOfRoom; // loại phòng
    private String otherService;// tiện ích khác
    private int floor; // số tầng

    public House() {
    }

    public House(String id, String serviceName, int area, int price, int maxpeople, String renType, int rentime, String kinhOfRoom, String otherService, int floor) {
        super(id, serviceName, area, price, maxpeople, renType, rentime);
        this.kinhOfRoom = kinhOfRoom;
        this.otherService = otherService;
        this.floor = floor;
    }

    public String getKinhOfRoom() {
        return kinhOfRoom;
    }

    public void setKinhOfRoom(String kinhOfRoom) {
        this.kinhOfRoom = kinhOfRoom;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + kinhOfRoom + "|" + otherService + "|" + floor;
    }

    @Override
    public void showInfo() {
        String str = "\tID: " + super.getId()
                + ",\tloại dịch vụ thuê: " + super.getServiceName()
                + ",\tdiện tích sử dụng = " + super.getArea() + "m2"
                + ",\tchi phí thuê = " + super.getPrice() + "/h"
                + ",\tsố người tối đa = " + super.getMaxpeople()
                + ",\tkiểu thuê = '" + super.getRenType() + "'"
                + ",\tthời gian thuê = " + super.getRentime() + " " + super.getRenType()
                + ",\ttiêu chuẩn phòng: " + this.getKinhOfRoom()
                + ",\tcác tiện ích khác: " + this.getOtherService()
                + ",\tsố tầng: " + this.getFloor();
        System.out.println(str);
    }
}
