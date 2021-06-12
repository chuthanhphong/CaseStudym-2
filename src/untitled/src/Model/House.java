package Model;


    public class House extends Service {
        private String typeOfRoom;        //Tiêu chuẩn phòng
        private String utilityDescription;  //Mô tả tiện ích khác
        private int floors;                 //Số tầng

        public House() {
        }

        public House(String id, String serviceName, float area, float price, int maxPeople, String rentType, int rentTime, String typeOfRoom, String utilityDescription, int floors) {
            super(id, serviceName, area, price, maxPeople, rentType, rentTime);
            this.typeOfRoom = typeOfRoom;
            this.utilityDescription = utilityDescription;
            this.floors = floors;
        }

        public String getUtilityDescription() {
            return this.utilityDescription;
        }

        public void setUtilityDescription(String utilityDescription) {
            this.utilityDescription = utilityDescription;
        }

        public int getFloors() {
            return floors;
        }

        public void setFloors(int floors) {
            this.floors = floors;
        }

        public String getTypeOfRoom() {
            return typeOfRoom;
        }

        public void setTypeOfRoom(String typeOfRoom) {
            this.typeOfRoom = typeOfRoom;
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
                    + ",\ttiêu chuẩn phòng: " + this.getTypeOfRoom()
                    + ",\tcác tiện ích khác: " + this.getUtilityDescription()
                    + ",\tsố tầng: " + this.getFloors();
            System.out.println(str);
        }

        @Override
        public String toString() {
            return super.toString() + "|" + typeOfRoom + "|" + utilityDescription + "|" + floors;
        }
    }

