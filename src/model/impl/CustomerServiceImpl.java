package model.impl;

import enums.ExceptionEnum;
import enums.StatusEnum;
import exceptions.ApplicationException;
import model.Card;
import model.Customer;

import java.time.LocalDate;

import static data.GlobalData.customers;
import static helper.Helper.fillCustomer;
import static util.InputUtil.inputString;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void register() {
        if (customers == null) {
            customers = new Customer[1];
            while (customers[0] == null) {
                customers[0] = fillCustomer();
            }
        } else {
            Customer tempData[] = customers;
            customers = new Customer[customers.length + 1];
            for (int i = 0; i < customers.length; i++) {
                if (i > tempData.length - 1) {
                    customers[i] = tempData[i];

                } else {
                    while (customers[i] == null) {
                        customers[i] = fillCustomer();
                    }
                }

            }
        }
    }

    public static Customer login;
    @Override
    public Customer login() {
        String email = inputString("Enter the email:");
        String password = inputString("Enter the password:");
        byte attempts = 0;
        while (true) {
            for (int i = 0; i < customers.length; i++) {
                if (email.equalsIgnoreCase(customers[i].getEmail())) {
                    if (password.equals(customers[i].getPassword())) {
                        System.out.println("Welcome dear," + customers[i].getName());
                        login = customers[i];
                        return customers[i];
                    } else {
                        attempts++;
                    }
                }
                if (attempts == 3) {
                    customers[i].setBlockStatus(true);
                    throw new ApplicationException(ExceptionEnum.FAILED_ATTEMPTS_EXCEPTION);
                }
            }
        }
    }

    @Override
    public void showDetails() {

        System.out.println(
                "Name:" + login().getName() + "\n" +
                        "Surname" + login().getSurname() + "\n" +
                        "Email" + login().getEmail() + "\n" +
                        "Card Number" + login().getCard().getCardNumber() + "\n" +
                        "Your Current Balance" + login().getCard().getCurrentBalance() + "\n"

        );


    }

    @Override
    public void update() {
        boolean update = false;
        String name = inputString("Name:");
        String surname = inputString("Surname: ");
        String email = inputString("Email: ");
        String oldPassword = inputString("Old password: ");
        if (!oldPassword.isBlank() && oldPassword.equals(login().getPassword())) {
            if (!name.isBlank()) {
                login().setName(name);
                update = true;
            }
            if (!surname.isBlank()) {
                login().setSurname(surname);
                update = true;
            }
            if (!email.isBlank()) {
                login().setEmail(email);
                update = true;
            }
            String newPassword = inputString("New password");
            if (!newPassword.isBlank()) {
                login().setPassword(newPassword);
                update = true;
            }
        } else {
            System.out.println("Not updated!");
        }
        if (update) {
            login().setUpdateDate(LocalDate.now());
            System.out.println(StatusEnum.UPDATE_SUCCESSFULLY.name());
        }
    }
}
