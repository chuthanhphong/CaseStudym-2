package Model;

public abstract class Service {

        protected String id;
        protected String serviceName;   //Tên dịch vụ
        protected float area;           //Diện tích sử dụng
        protected float price;          //Chi phí thuê
        protected int maxPeople;        //Số người tối đa
        protected String rentType;      //thuê theo năm - tháng - ngày - giờ
        protected int rentTime;      //Thời gian thuê

        public Service() {
        }

        public Service(String id, String serviceName, float area, float price, int maxPeople, String rentType, int rentTime) {
            this.id = id;
            this.serviceName = serviceName;
            this.area = area;
            this.price = price;
            this.maxPeople = maxPeople;
            this.rentType = rentType;
            this.rentTime = rentTime;
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

        public float getArea() {
            return area;
        }

        public void setArea(float area) {
            this.area = area;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getMaxPeople() {
            return maxPeople;
        }

        public void setMaxPeople(int maxPeople) {
            this.maxPeople = maxPeople;
        }

        public String getRentType() {
            return rentType;
        }

        public void setRentType(String rentType) {
            this.rentType = rentType;
        }

        public int getRentTime() {
            return rentTime;
        }

        public void setRentTime(int rentTime) {
            this.rentTime = rentTime;
        }

        @Override
        public String toString() {
            return      id +
                    "|" + serviceName +
                    "|" + area +
                    "|" + price +
                    "|" + maxPeople +
                    "|" + rentType +
                    "|" + rentTime;
        }

        //Phương thức
        public abstract void showInfo();
    }

