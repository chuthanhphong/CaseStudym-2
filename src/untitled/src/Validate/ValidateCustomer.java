package Validate;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateCustomer {
    public boolean validateName(String name){
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";//tên đầy đủ có dấu
        return Pattern.matches(regex,name);
    }

    public boolean validateDateOfBirth(String str) throws InterruptedException {
        String formatDOB = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        if (!Pattern.matches(formatDOB, str)) {
            System.err.println("---Sai định dạng dd/mm/yyyy---");
            Thread.sleep(250);
            return false;
        }
        int yearDOB = Integer.parseInt(str.substring(6, 10)); //năm sinh
        int monthDOB = Integer.parseInt(str.substring(3, 5)); //tháng sinh
        int dayDOB = Integer.parseInt(str.substring(0, 2));   //ngày sinh
        //tháng sinh < 0 || tháng sinh > 12
        if (monthDOB < 0 || monthDOB > 12){
            System.err.println("---Sai tháng sinh---");
            Thread.sleep(250);
            return false;
        }
        //kiểm tra tháng 2
        if (monthDOB == 2 && (dayDOB < 1 || dayDOB > 29)){
            System.err.println("---Tháng " + monthDOB + " chỉ có nhiều nhất 29 ngày---");
            Thread.sleep(250);
            return false;
        }
        //tháng có 31 ngày
        if (monthDOB == 1 ||monthDOB == 3 || monthDOB == 5 ||monthDOB == 7 ||monthDOB == 8 ||monthDOB == 10 ||monthDOB == 12){
            if (dayDOB < 1 || dayDOB > 31){
                System.err.println("---Tháng " + monthDOB + " chỉ có 31 ngày---");
                Thread.sleep(250);
                return false;
            }
        }
        //tháng 30 ngày
        if (monthDOB == 4 ||monthDOB == 6 || monthDOB == 9 ||monthDOB == 11){
            if (dayDOB < 1 || dayDOB > 30){
                System.err.println("---Tháng " + monthDOB + " chỉ có 30 ngày---");
                Thread.sleep(250);
                return false;
            }
        }
        String time = String.valueOf(LocalDate.now());
        int yearNow = Integer.parseInt(time.substring(0, 4)); //năm hiện tại
        int monthNow = Integer.parseInt(time.substring(5, 7)); //tháng hiện tại
        int dayNow = Integer.parseInt(time.substring(8, 10)); //ngày hiện tại

        if (yearNow - yearDOB < 18 || yearDOB < 1950) {
            System.err.println("---Năm sinh phải >1950 và nhỏ hơn năm hiện tại 18 năm---");
            Thread.sleep(250);
            return false;
        }
        if (yearNow - yearDOB == 18) {
            if (monthDOB > monthNow) {
                System.err.println("---Năm sinh phải >1950 và nhỏ hơn năm hiện tại 18 năm---");
                Thread.sleep(250);
                return false;
            }
            if (monthDOB == monthNow) {
                if (dayDOB > dayNow) {
                    System.err.println("---Năm sinh phải >1950 và nhỏ hơn năm hiện tại 18 năm---");
                    Thread.sleep(250);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateGender(String str){
        str = str.toLowerCase();
        str = str.replace(str.charAt(0), (char) (str.charAt(0)-32));
        return str.equals("Nam") || str.equals("Nữ") || str.equals("Không Xác Định");
    }

    public boolean validateTypeOfCustomer(String str){
        //Diamond, Platinium, Gold, Silver, Member
        str = str.toLowerCase();
        str = (char)(str.charAt(0) - 32) + str.substring(1);
        return str.equals("Vip1") || str.equals("Normal") || str.equals("Vip2") || str.equals("Vip3") || str.equals("Vip4");
    }

    public boolean validateID(String id) {
        String regex = "^[0-9]{3} [0-9]{3} [0-9]{3} [0-9]{3}$";
        return Pattern.matches(regex, id);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        String regex = "^0[0-9]{9}$";
        return Pattern.matches(regex,phoneNumber);
    }

    public boolean validateEmail(String email){
        String regex = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]+$";
        return Pattern.matches(regex, email);
    }
}

