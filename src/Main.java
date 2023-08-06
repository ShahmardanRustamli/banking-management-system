import managementService.ManagementService;
import managementService.ManagementServiceImpl;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ManagementService managementService = new ManagementServiceImpl();
        managementService.management();
    }
}
