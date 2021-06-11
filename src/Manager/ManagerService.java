package Manager;

import CustomerAndService.House;
import CustomerAndService.Room;
import Setting.ReadAndWritreFile;
import Setting.ValidateService;

import java.util.*;

public class ManagerService {
    public final String House = "D:\\Module2\\untitled1\\src\\FileSaving\\House.csv";
    public final String Room = "D:\\Module2\\untitled1\\src\\FileSaving\\Room.csv";

    ValidateService validateService = new ValidateService();
    ReadAndWritreFile readAndWritreFile = new ReadAndWritreFile();

    public void addHouse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm một Căn Hộ mới");
        String addId;
        try {


            do {
                System.out.println("Nhập Id");
                addId = sc.nextLine();
                if (!validateService.validaId(addId, "house")) ;
                {
                    System.out.println("Id không đúng theo định dạng");

                }
                if (readAndWritreFile.isIdExist(addId, House)) {
                    System.out.println("ID Đã Tồn Tại");
                }
                break;

            } while (true);
            String addServiceName;
            do {
                System.out.println("Nhập tên dịch vụ");
                addServiceName = sc.nextLine();
                if (!validateService.validateNameofService(addServiceName)) {
                    System.out.println("Không có dịch vụ này");
                }
                break;
            } while (true);
            int addarea;
            do {
                System.out.println("Nhập diện tích bạn muốn sử dụng");
                addarea = Integer.parseInt(sc.nextLine());
                if (!validateService.validateArea(addarea)) {
                    System.out.println("Diện tích sử dụng phải trên 30m2");
                }
                break;
            } while (true);
            int addmaxpeople;
            do {
                System.out.println("Nhập số người tối đa");
                addmaxpeople = Integer.parseInt(sc.nextLine());
                if (!validateService.validateMaxPeople(addmaxpeople)) {
                    System.out.println("Số người tối đa là 20");
                }
                break;
            } while (true);
            String addrentype = null;
            do {
                System.out.println("Bạn muốn thuê theo hình thức nào");
                System.out.println("1.Thuê theo năm");
                System.out.println("2.Thuê theo tháng");
                System.out.println("3.Thuê theo ngày");
                System.out.println("4.Thuê theo giờ");
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        addrentype = "năm";
                        break;
                    case 2:
                        addrentype = "tháng";
                        break;
                    case 3:
                        addrentype = "ngày";
                        break;
                    case 4:
                        addrentype = "giờ";
                        break;
                }
            } while (addrentype == null);
            System.out.println("Thời gian thuê theo " + addrentype);
            int addrentTime = Integer.parseInt(sc.nextLine());
            int addprice;
            do {
                System.out.println("giá tiền thuê theo " + addrentype);
                addprice = Integer.parseInt(sc.nextLine());
                if (!validateService.validatePrice(addprice)) {
                    System.out.println("Gía tiền không hợp lệ");
                }
                break;

            } while (true);
            String addTypeofRoom;
            System.out.println("Loại phòng");
            addTypeofRoom = sc.nextLine();
            int addFloor;

            System.out.println("Nhập số tầng");
            addFloor = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập các tiện ích khác");
            String adduntiliti = sc.nextLine();

            House addhouse = new House(addId, addServiceName, addarea, addprice, addmaxpeople, addrentype, addrentTime, addTypeofRoom, adduntiliti, addFloor);
            List<House> list = new ArrayList<>();
            list.add(addhouse);
            readAndWritreFile.writeTofile(list, true);

        } catch (NumberFormatException exception) {
            System.out.println("Lỗi , Kiểm tra và nhập lại");
        }
    }

    public void addRoom() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm một phòng mới");
        try {
            String addID;
            do {
                System.out.println("Nhập ID");
                addID = sc.nextLine();
                if (!validateService.validaId(addID, "room")) {
                    System.out.println("Id không hợp lệ");
                    continue;
                }
                if (readAndWritreFile.isIdExist(addID, Room)) {
                    System.out.println("Id đã tồn tại");
                }
                break;
            } while (true);
            String addServiceName;
            do {
                System.out.println("Nhập tên dịch vụ");
                addServiceName = sc.nextLine();
                if (!validateService.validateNameofService(addServiceName)) {
                    System.out.println("Không có loại dịch vụ này");
                    continue;
                }
                break;
            } while (true);
            int addArea;
            do {
                System.out.println("Nhập diện tích phòng: m2");
                addArea = Integer.parseInt(sc.nextLine());
                if (!validateService.validateArea(addArea)) {
                    System.out.println("Diện tích phải lớn hơn 30m2");
                    continue;
                }
                break;
            } while (true);
            int addMaxpeople;
            do {
                System.out.println("Nhập số người tối đa");
                addMaxpeople = Integer.parseInt(sc.nextLine());
                if (!validateService.validateMaxPeople(addMaxpeople)) {
                    System.out.println("Số người tối đa dưới 20 ");
                    continue;
                }
                break;
            } while (true);
            String addRentype = null;
            do {
                System.out.println("\tHình thức thuê: ");
                System.out.println("\t\t1. Thuê theo năm");
                System.out.println("\t\t2. Thuê theo tháng");
                System.out.println("\t\t3. Thuê theo ngày");
                System.out.println("\t\t4. Thuê theo giờ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addRentype = "năm";
                        break;
                    case 2:
                        addRentype = "tháng";
                        break;
                    case 3:
                        addRentype = "ngày";
                        break;
                    case 4:
                        addRentype = "giờ";
                        break;
                    default:
                        System.out.println("vui lòng chọn dịch vụ");
                }
            } while (addRentype == null);
            System.out.println("Thời gian thuê theo " + addRentype);
            int addrenTime = Integer.parseInt(sc.nextLine());
            int addPrice;
            do {
                addPrice = Integer.parseInt(sc.nextLine());
                if(!validateService.validatePrice(addPrice)){
                    System.out.println("Gía tiền không hợp lệ");
                    continue;
                }break;
            }while (true);
            String addOtherService;
            do {
                System.out.println("Nhập dịch vụ đi kèm");
                addOtherService = sc.nextLine();
                if(!validateService.validateNameofService(addOtherService)){
                    System.out.println("Dịch vụ đi kèm không có ");
                    continue;
                }break;
            }while (true);
           int addUnitService;
            do {
                System.out.println("Nhập số lượng");
                addUnitService = Integer.parseInt(sc.nextLine());
                if(!validateService.validateUnitService(addUnitService)){
                    System.out.println("Lỗi số lượng không đúng");
                    continue;
                }break;
            }while (true);
            int addPriceservice;
            do {
                System.out.println("Gía tiền dịch vụ phòng");
                addPriceservice = Integer.parseInt(sc.nextLine());
                if(!validateService.validatePrice(addPriceservice)){
                    System.out.println("Gía tiền không đúng");
                    continue;
                }break;
            }while (true);
            Room addRoom = new Room(addID,addServiceName,addArea,addPrice,addMaxpeople,addRentype,addrenTime,addOtherService,addUnitService,addPriceservice);
            List<Room > list= new ArrayList<>();
            list.add(addRoom);
            readAndWritreFile.writeTofile(list,true);
        }catch (NumberFormatException exception){
            System.out.println("Kiểm tra lại nhập vào");
        }
    }
    public List<House> showAllHouse(){
        System.out.println("House :");
        List<House> list = readAndWritreFile.readHouseFile();
        int i =1;
        for(House o :list){
            System.out.println(i++ +".\t");
            o.showInfo();
        }
        return list;
    }
    public List<Room> showAllRoom(){
        System.out.println("Room:");
        List<Room> list = readAndWritreFile.readRoomFile();
        int i = 1;
        for(Room room :list){
            System.out.println(i++ + ".\t");
            room.showInfo();
        }
        return list;
    }
    public TreeSet<String> showHousenotDulipcateName(){
        System.out.println("Danh sách các House không trùng nhau :");
        List<House> list= readAndWritreFile.readHouseFile();
        TreeSet<String> nameHouse = new TreeSet<>();
        for(House house:list){
            if(!nameHouse.contains(house.getServiceName())){
                nameHouse.add(house.getServiceName());
            }
        }
        int i =1;
        for(String name:nameHouse){
            System.out.println(i++ +"."+name);
        }
        return nameHouse;
    }
    public TreeSet<String> showRoomnotDulipcateName(){
        System.out.println("Danh sách các room không trùng nhau");
        List<Room> list = readAndWritreFile.readRoomFile();
        TreeSet<String> nameRoom = new TreeSet<>();
        for(Room room:list){
            if(!nameRoom.contains(room.getServiceName())){
                nameRoom.add(room.getServiceName());
            }
        }
        int i=1;
        for(String name:nameRoom){
            System.out.println(i++ + "." + name);
        }
        return nameRoom;
    }
    public House bookHouse(){
        Scanner sc = new Scanner(System.in);
        int index ;
        List<House> houseList = showHousetoBook();
        if(houseList.size()==0){
            return null;
        }else
            do {
                try {
                    System.out.println("Chọn phòng để đặt");
                    index =Integer.parseInt(sc.nextLine());
                    if(index<=0|index>houseList.size()){
                        System.out.println("Chọn House trong danh sách");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Nhập định dang là 1 số");
                }
            }while (true);
            return houseList.get(index-1);
    }
    public Room bookRoom(){
        Scanner sc = new Scanner(System.in);
        int index ;
        List<Room> roomList = showRoomtoBook();
        if(roomList.size()==0){
            return null;
        }else
            do {
                try {
                    System.out.println("Chọn phòng để đặt");
                    index = Integer.parseInt(sc.nextLine());
                    if(index<=0||index>roomList.size()){
                        System.out.println("Chọn phòng có trong danh sách");
                        continue;
                    }break;
                }catch (NumberFormatException e){
                    System.out.println("Nhập định dạng là 1 số");
                }
            }while (true);
            return roomList.get(index-1);
    }
    public List<House> showHousetoBook(){
        System.out.println("Danh sách Houses khả dụng");
        Map map = readAndWritreFile.readBookcsv();
        List<House> list = readAndWritreFile.readHouseFile();
        list.removeIf(house -> map.containsValue(house.getId()));
        int i =1;
        for(House house : list){
            System.out.println(i++ +".\t");
            house.showInfo();
        }
        return list;
    }
    public List<Room> showRoomtoBook(){
        System.out.println("Danh sách Room khả dụng");
        Map map = readAndWritreFile.readBookcsv();
        List<Room> list = readAndWritreFile.readRoomFile();
        list.removeIf(room -> map.containsValue(room.getId()));
        int i =1;
        for(Room room :list){
            System.out.println(i++ +".\t");
            room.showInfo();;
        }
        return list;
    }
}
