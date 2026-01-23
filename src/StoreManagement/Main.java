package StoreManagement;

import StoreManagement.Menu.Menu;
import StoreManagement.Menu.StoreMenu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new StoreMenu();
        menu.run();
    }
}