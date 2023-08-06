package model.impl;

import enums.ExceptionEnum;
import exceptions.ApplicationException;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static data.GlobalData.customers;
import static model.impl.CustomerServiceImpl.login;
import static util.InputUtil.inputInt;
import static util.InputUtil.inputString;

public class CardServiceImpl implements CardService {
    @Override
    public void increaseTheBalance() {
        if (customers.length > 0) {
            String cardNumber = inputString("Enter the card number: ");
            if (cardNumber.length() == 16) {
                for (int i = 0; i < customers.length; i++) {
                    if (cardNumber.equals(customers[i].getCard().getCardNumber())) {
                        int amount = inputInt("Enter the amount: ");
                        if (amount > 0) {
                            customers[i].getCard().setCurrentBalance(customers[i].getCard().getCurrentBalance() + amount);
                            String cardNo[] = customers[i].getCard().getCardNumber().split(" ");
                            String maskedNumber = customers[i].getCard().getCardNumber().replace(cardNo[1], "*").replace(cardNo[2], "*");
                            System.out.println(
                                    "-----------CASH RECEIPT-----------" + "\n" +
                                            "Date&Time: " + LocalDateTime.now() + "\n" +
                                            "Card No: " + maskedNumber + "\n" +
                                            "Add amount: " + amount + " AZN" + "\n" +
                                            "Total remain balance: " + customers[i].getCard().getCurrentBalance() + " AZN"
                            );
                        }
                    }
                }
            }
        }
    }

    @Override
    public void showBalance() {
        System.out.println(
                "Dear Customer your Balance:" + login.getCard().getCurrentBalance()
        );

    }

    @Override
    public void cashOut() {
        int cash[] = {500, 200, 100, 50, 20, 10, 5, 1};
        int amount = inputInt("Enter the withdraw amount:");
        if (amount > 0 && amount < login.getCard().getCurrentBalance()) {
            for (int i = 0; i < cash.length; i++) {
                byte cashAmount = 0;
                while (amount / cash[i] > 0) {
                    cashAmount++;
                    login.getCard().setCurrentBalance(login.getCard().getCurrentBalance() - cash[i]);

                }
            }
            login.getCard().setCurrentBalance(login.getCard().getCurrentBalance() + amount);
            String cardNo[] = login.getCard().getCardNumber().split(" ");
            String maskedNumber = login.getCard().getCardNumber().replace(cardNo[1], "*").replace(cardNo[2], "*");
            System.out.println(
                    "-----------CASH RECEIPT-----------" + "\n" +
                            "Date&Time: " + LocalDateTime.now() + "\n" +
                            "Card No: " + maskedNumber + "\n" +
                            "Add amount: " + amount + " AZN" + "\n" +
                            "Total remain balance: " + login.getCard().getCurrentBalance() + " AZN"
            );
        }else {
            throw new ApplicationException(ExceptionEnum.INSUFFICIENT_BALANCE_EXCEPTION);
        }

    }
}
