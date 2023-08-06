package model.impl;

import model.Customer;

public interface CustomerService {
    void register();
    Customer login();
    void showDetails();
    void update();
}
