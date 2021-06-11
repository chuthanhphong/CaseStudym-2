package Setting;

import java.util.regex.Pattern;

public class ValidateService {
  public boolean validaId(String str,String type){
    String regexString ;
    switch (type){
        case "house":
            regexString= "^YNHO-[0-9]{3}$";// YNHO-1234;
            break;
        case "room":
            regexString ="^YNRO-[0-9]{4}$";// YNRO-1234;
            break;
        default:
            return false;
    }
    return Pattern.matches(regexString,str);
}
public boolean validateArea(int area){
      return area>30;
}
public boolean validateSwimmingPool(int area){
      return area>30;
}
public boolean validatePrice(int price){
      return price>0;
}
public boolean validateMaxPeople(int people){
      return people>0&&people<20;
}
public boolean validateNameofService(String str){
      String[] arr = {"spa","tenis", "cassino", "food", "drink","car"};
      for(String str1 :arr){
          if(str1.equals(str)){
              return true;
          }
      }
      return false;
}
public boolean validateUnitService(int unitService){
      return unitService>0;
}
public boolean validateRentype(String str){
      String regexString ="^[A-Z]+[a-z0-9\\s]*$";
      return Pattern.matches(regexString,str);
}


}
