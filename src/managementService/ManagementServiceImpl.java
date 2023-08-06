package managementService;

import model.impl.CardService;
import model.impl.CardServiceImpl;
import model.impl.CustomerService;
import model.impl.CustomerServiceImpl;

import static util.MenuUtil.*;

public class ManagementServiceImpl implements ManagementService {

    @Override
    public void management() {
        CustomerService customerService = new CustomerServiceImpl();
        CardService cardService = new CardServiceImpl();
        while (true){
            byte option = entryMenu();
            switch (option){
                case 0:
                    System.exit(-1);
                case 1:
                    customerService.register();
                    break;
                case 2:
                    customerService.login();
                    while (true){
                        byte loginOption = loginMenu();
                        switch (loginOption) {
                            case 1:
                                cardService.showBalance();
                                break;
                            case 2:
                                customerService.update();
                                break;
                            case 3:
                                byte operationMenu = operationMenu();
                                switch (operationMenu) {
                                    case 1:
                                        cardService.showBalance();
                                        break;
                                    case 2:
                                        cardService.cashOut();
                                        break;
                                }
                                break;
                            case 4:
                                break;
                        }
                    }
                case 3:
                    cardService.increaseTheBalance();
            }
        }
    }
}
