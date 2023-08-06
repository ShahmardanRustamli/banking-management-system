package helper;

import model.Card;
import model.Customer;

import java.time.LocalDate;
import java.util.Random;

import static util.InputUtil.inputString;

public class Helper {


    public static Card fillCard(){
        long id = 0;
        Random random = new Random();
        int first = random.nextInt(1000, 9999);
        int last = random.nextInt(1000,9999);
        String cardNumber = "4169 7388 " + first+" "+last;
        int currentBalance = 0;
        return new Card(id++, cardNumber, currentBalance, LocalDate.now());

    }
    public static Customer fillCustomer(){
        long id = 0;
        String name = inputString("Enter the name:");
        String surname = inputString("Enter the surname:");
        String email = inputString("Enter the Email:");
        String password = inputString("Enter the password");
        boolean status = true;
        boolean blockStatus = false;
        LocalDate registerDate = LocalDate.now();
        LocalDate updateDate = null;

        return new Customer(id++,name,surname,email,password,status,blockStatus,registerDate,updateDate,fillCard());
    }



}
