package restaurantmanagement.models;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, MenuItem> menuItemMap;

    public Menu() {
        menuItemMap = new HashMap<>();
    }

    public Map<String, MenuItem> getMenuItemMap() {
        return menuItemMap;
    }
}
