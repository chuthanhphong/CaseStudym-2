package CustomerAndService;

public abstract class Service {
    private String id;
    private String serviceName;
    private int area;
    private int price;
    private int maxpeople;
    private String renType;//loại cho thuê: ngày- tháng - năm
    private int rentime;

    public Service() {
    }

    public Service(String id, String serviceName, int area, int price, int maxpeople,String renType, int rentime) {
        this.id = id;
        this.serviceName = serviceName;
        this.area = area;
        this.price = price;
        this.maxpeople = maxpeople;
        this.renType = renType;
        this.rentime = rentime;
    }

    public String getRenType() {
        return renType;
    }

    public void setRenType(String renType) {
        this.renType = renType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxpeople() {
        return maxpeople;
    }

    public void setMaxpeople(int maxpeople) {
        this.maxpeople = maxpeople;
    }

    public int getRentime() {
        return rentime;
    }

    public void setRentime(int rentime) {
        this.rentime = rentime;
    }

    @Override
    public String toString() {
        return     id +
                "," + serviceName +
                "," + area +
                "," + price +
                "," + renType+
                "," + maxpeople +
                "," + rentime;
    }
    public abstract void showInfo();
}
