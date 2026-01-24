package StoreManagement;

import StoreManagement.menu.Menu;
import StoreManagement.menu.StoreMenu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new StoreMenu();
        menu.run();
    }
}