package util;

import static util.InputUtil.inputByte;

public class MenuUtil {
    public static byte entryMenu(){
        System.out.println("[0] - > Exit System\n"+
                           "[1] - > Register\n"+
                           "[2] - > Login\n"+
                           "[3] - > Increase balance\n");
        return inputByte("Choose the option:");
    }

    public static byte loginMenu(){
        System.out.println(
                """
                        [1] -> Show my details
                        [2] -> Update my details
                        [3] -> Operations
                        [4] -> Log out
                """
        );
        return inputByte("Choose the option: ");
    }

    public static byte operationMenu(){
        System.out.println(
                """
                        [1] - > show balance
                        [2] - > cashing out 
                """
        );
        return inputByte("Choose the option: ");
    }
}
