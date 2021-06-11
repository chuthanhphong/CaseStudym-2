package Setting;

import CustomerAndService.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReadAndWritreFile <E> {
  public void writeTofile(List<E> list, boolean status){
      try {
          if(list.size()==0){
              System.out.println("Danh sách trống");
              return;
          }
          String path;

      if(list.get(0)instanceof House){
          path = "D:\\Module2\\untitled1\\src\\FileSaving\\House.csv";
      }else if(list.get(0)instanceof Room){
          path = "D:\\Module2\\untitled1\\src\\FileSaving\\Room.csv";
      }else if(list.get(0)instanceof Customer){
          path = "D:\\Module2\\untitled1\\src\\FileSaving\\Customer.csv";
      }else {
          System.out.println("Đối tượng đọc phải là :Room,House,Customer");
          return;
      }
      FileWriter fileWriter = new FileWriter(path,status);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      for(E object :list){
          bufferedWriter.write(object.toString()+"\n");
      }
      bufferedWriter.close();
          System.out.println("Đã ghi vào file ");
  }catch (FileNotFoundException fileNotFoundException){
          System.out.println("File không tồn tại");
      }catch (IOException e){
          e.printStackTrace();
      }
}
public boolean isIdExist(String id,String filename){
      switch (filename){
          case "D:\\Module2\\untitled1\\src\\FileSaving\\House.csv":{
              List<House> list = readHouseFile();
              for(House o:list){
                  if(o.getId().equals(id)){
                      return true;
                  }
              }
              break;
          }
          case "D:\\Module2\\untitled1\\src\\FileSaving\\Room.csv":{
              List<Room> list = readRoomFile();
              for(Room o :list){
                  if(o.getId().equals(id)){
                      return true;
                  }
              }
              break;
          }
          case "D:\\Module2\\untitled1\\src\\FileSaving\\Customer.csv":{
              List<Customer> list = readCustomerFile();
              for(Customer o:list){
                  if(o.getId().equals(id)){
                      return true;
                  }
              }
              break;
          }
      }
      return false;
}
public List<Customer>readCustomerFile(){
      final String path ="D:\\Module2\\untitled1\\src\\FileSaving\\Customer.csv";
      List<Customer>list=new ArrayList<>();
      try {
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line="";
          while ((line=bufferedReader.readLine())!=null){
              String[]value =line.split(",");
              if(value[8].equals("null")){
                  list.add(new Customer(value[0],value[1],value[2],value[3],value[4],value[5],value[6],value[7]));
              }else {
                  Service service = searchServicebyId(value[8]);
                  list.add(new Customer(value[0],value[1],value[2],value[3],value[4],value[5],value[6],value[7],service));
              }
          }
           bufferedReader.close();
          fileReader.close();
      }catch (FileNotFoundException e){
          System.out.println("File không tồn tại");
      }catch (Exception e){
          System.out.println("Dữ liệu không được đọc");
      }
      return list;
}
public List<House> readHouseFile(){
      final String path ="D:\\Module2\\untitled1\\src\\FileSaving\\House.csv";
      List<House>list= new ArrayList<>();
      try {
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line;
          while ((line=bufferedReader.readLine())!=null){
              String [] value = line.split(",\t");
              list.add(new House(value[0], value[1], Integer.parseInt(value[2]), Integer.parseInt(value[3]), Integer.parseInt(value[4]), value[5], Integer.parseInt(value[6]), value[7], value[8], Integer.parseInt(value[9])));
          }
          bufferedReader.close();
          fileReader.close();
      }catch (FileNotFoundException e){
          System.out.println("File không tồn tại");
      }catch (Exception e){
          System.out.println("Dữ liệu không khả dụng");
      }
      return list;
}
public List<Room>readRoomFile(){
      final String path ="D:\\Module2\\untitled1\\src\\FileSaving\\Room.csv";
      List<Room>list = new ArrayList<>();
      try {
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line;
          while ((line=bufferedReader.readLine())!=null){
              String[] value = line.split(",\t");
              list.add(new Room(value[0],value[1],Integer.parseInt(value[2]),Integer.parseInt(value[3]),Integer.parseInt(value[4]),value[5],Integer.parseInt(value[6]),value[7],Integer.parseInt(value[8]),Integer.parseInt(value[9])));
          }
          bufferedReader.close();
          fileReader.close();
      }catch (FileNotFoundException e){
          System.out.println("File không tồn tại");
      }catch (Exception e){
          System.out.println("Dữ liệu không khả dụng");
      }
      return list;
}
public  Service searchServicebyId(String id){
      String ty0fService = id.substring(0,4);
      if(ty0fService.equals("YNHO")){
          List<House> list= readHouseFile();
          for(House house : list){
              if(house.getId().equals(id)){
                  return house;
              }
          }
          return null;
      }else if(ty0fService.equals("YNRO")){
          List<Room>list = readRoomFile();
          for(Room room : list){
              if(room.getId().equals(id)){
                  return room;
              }
          }
          return null;
      }else {
          System.out.println("ID không tìm thấy");
          return null;
      }

}
public void writeBookcsv(String idservice,String idCustomer){
      final String path = "D:\\Module2\\untitled1\\src\\FileSaving\\Booking.csv";
      try {
         FileWriter fileWriter = new FileWriter(path);
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
         bufferedWriter.write(idservice +","+idCustomer +"\n");
         bufferedWriter.close();
         fileWriter.close();
          System.out.println("Đặt phòng thành công");
      }catch (IOException e){
          e.printStackTrace();
      }
}
public Map<String,String> readBookcsv(){
      final String path ="D:\\Module2\\untitled1\\src\\FileSaving\\Booking.csv";
      Map<String,String>map = new LinkedHashMap<>();
      try {
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line;
          while ((line=bufferedReader.readLine())!=null){
              String[]value =line.split(",");
              map.put(value[0],value[1]);
          }
          bufferedReader.close();
          fileReader.close();
      }catch (FileNotFoundException e){
          System.out.println("File không tồn tại");
      }catch (IOException e){
          System.out.println("Lỗi đọc file");
      }
      return map;
}
public Map<Integer, Employee> readEmployeecsv(){
      final String path ="D:\\Module2\\untitled1\\src\\FileSaving\\Employee.csv";
      Map<Integer,Employee> map = new LinkedHashMap<>();
      try {
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line="";
          int i =1;
          while ((line=bufferedReader.readLine())!=null){
              String [] value= line.split(",");
              Employee employee = new Employee(value[0],Integer.parseInt(value[1]),value[2],value[3]);
              map.put(i++,employee);
          }
          bufferedReader.close();
          fileReader.close();
      }catch (FileNotFoundException e){
          System.out.println("File không tồn tại");
      }catch (IOException e){
          System.out.println("Lỗi đọc File");
      }
    return map;
}




}
