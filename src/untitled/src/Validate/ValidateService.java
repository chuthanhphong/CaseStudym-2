package Validate;


import java.util.regex.Pattern;

public class ValidateService {

    public boolean validateServiceName(String str) {
        String regexString = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}[\\p{Ll}\\d]*)*(\\s\\d*)*";
        return Pattern.matches(regexString, str);
    }

    public boolean validateId(String str, String type) {
        String regexString;
        switch (type) {
            case "villa":
                regexString = "^YNVL-[0-9]{4}$";
                break;
            case "house":
                regexString = "^YNHO-[0-9]{4}$";
                break;
            case "room":
                regexString = "^YNRO-[0-9]{4}$";
                break;
            default:
                return false;
        }
        return Pattern.matches(regexString, str);
    }

    public boolean validateArea(float area) {
        return area > 30f;
    }

    public boolean validateSwimmingPool(float area) {
        return area > 30f;
    }

    public boolean validatePrice(float price) {
        return price > 0;
    }

    public boolean validateMaxPeople(int people) {
        return people > 0 && people < 20;
    }

    public boolean validateEnclosedService(String str) {
        String[] arrString = {"massage", "karaoke", "food", "drink", "car","spa"};
        for (String v : arrString) {
            if (v.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateAmountService(int amount) {
        return amount > 0;
    }

    public boolean validateFloors(int floor) {
        return floor > 0;
    }

    public boolean validateRentType(String str) {
        String regexString = "^[A-Z]+[a-z0-9\\s]*$";
        return Pattern.matches(regexString, str);
    }

}

