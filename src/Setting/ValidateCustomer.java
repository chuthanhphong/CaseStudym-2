package Setting;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateCustomer {
    public boolean ValidateName(String name){
        String REGEX = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";//Đinh Huy Chương
        return Pattern.matches(REGEX,name);
    }
    public boolean ValidateDateOfBirth(String str) throws InterruptedException {
        String RegexDOB = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";//00/00/00;
        if(!Pattern.matches(RegexDOB,str)) {
            System.out.println("Sai định dạng, vui lòng nhập theo mẫu DD/MM/YY");
            Thread.sleep(250);
            return false;
        }
        int yearDOB= Integer.parseInt(str.substring(6,10));
        int mounthDOB= Integer.parseInt(str.substring(3,5));
        int dayDOB = Integer.parseInt(str.substring(0,2));
        if(mounthDOB<0||mounthDOB>12){
            System.out.println("Sai tháng sinh");
            Thread.sleep(250);
            return false;
        }
        if(mounthDOB==2&&(dayDOB<1||dayDOB>29)){
            System.out.println("Tháng :" +mounthDOB +"Chỉ có tối đa 29 ngày");
            Thread.sleep(250);
            return false;
        }
        if(mounthDOB==1||mounthDOB==3||mounthDOB==5||mounthDOB==7||mounthDOB==8||mounthDOB==10||mounthDOB==12){
            if(dayDOB<1||dayDOB>31){
                System.out.println("Tháng :" + mounthDOB + " có tối đa 31 ngày");
                Thread.sleep(250);
                return false;
            }
        }
        String time = String.valueOf(LocalDate.now());
        int yearNow = Integer.parseInt(time.substring(0,4));
        int mounthNow = Integer.parseInt(time.substring(5,7));
        int dayNow = Integer.parseInt(time.substring(8,10));
        if(yearNow-yearDOB<18||yearDOB<1900){
            System.out.println("Năm sinh phải trước 1900 và tuổi của bạn phải trên 18");
            Thread.sleep(250);
            return false;
        }
        if(yearNow-yearDOB==18){
            if(mounthDOB>mounthNow){
                System.out.println("Năm sinh phải trước 1900 và tuổi của bạn phải trên 18");
                Thread.sleep(250);
                return false;
            }
            if(mounthDOB==mounthNow){
                if(dayDOB>dayNow){
                    System.out.println("Năm sinh phải trước 1900 và tuổi của bạn phải trên 18");
                    Thread.sleep(250);
                    return false;
                }
            }
        }
        return true;
    }
    public boolean validateGender(String str){
        str= str.toLowerCase();
        str = str.replace(str.charAt(0),(char) (str.charAt(0)-32));
        return str.equals("Nam")||str.equals("Nữ")||str.equals("Không Xác Định");
    }
    public boolean validateTypeOfCustomer(String str){
        //vip,bình dân, vãng lai
        str =str.toLowerCase();
        str = (char)(str.charAt(0) - 32) + str.substring(1);
        return str.equals("vip")||str.equals("bình dân")||str.equals("vãng lai");
    }
    public boolean validateID(String id){
        String Regex ="^[0-9]{3} [0-9]{3} [0-9]{3}$";
        return Pattern.matches(Regex,id);
    }
    public boolean validatePhoneNumber(String phoneNumber){
        String regex = "^0[1-9]{9}$";//0123456789;
        return Pattern.matches(regex,phoneNumber);
    }
    public boolean validaEmail(String email){
        String regex = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]+$";//abc@abc.abc
        return Pattern.matches(regex,email);
    }
}
