package CustomerAndService;

import Setting.ValidateCustomer;

public class test {
    public static void main(String[] args) throws InterruptedException {
        ValidateCustomer validateCustomer = new ValidateCustomer();
        boolean b =validateCustomer.validaEmail("phongnhi@mail.com");
        System.out.println(b);
    }
}
