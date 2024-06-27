package restaurantmanagement.services;

import java.util.List;
import java.util.Map;

import restaurantmanagement.exceptions.EntityAlreadyExistsException;
import restaurantmanagement.exceptions.EntityDoesNotExistException;
import restaurantmanagement.models.Menu;
import restaurantmanagement.models.MenuItem;
import restaurantmanagement.models.VegNonveg;

public class MenuService {
    private final Menu menu;
    private final Map<String, MenuItem> menuItemMap;

    public MenuService(Menu menu) {
        this.menu = menu;
        menuItemMap = menu.getMenuItemMap();
    }

    public MenuItem addItem(MenuItem menuItem) throws EntityAlreadyExistsException {
        if (menuItemMap.containsKey(menuItem.getName())) {
            throw new EntityAlreadyExistsException("menuItem = " + menuItem.getName());
        }
        menuItemMap.put(menuItem.getName(), menuItem);
        return menuItem;
    }

    public MenuItem updateItemPrice(String itemName, double price) throws EntityDoesNotExistException {
        if (!menuItemMap.containsKey(itemName)) {
            throw new EntityDoesNotExistException("menuItem = " + itemName);
        }
        MenuItem menuItem = menuItemMap.get(itemName);
        menuItem.setPrice(price);
        return menuItem;
    }

    public MenuItem removeItem(String itemName) throws EntityDoesNotExistException {
        if (!menuItemMap.containsKey(itemName)) {
            throw new EntityDoesNotExistException("menuItem = " + itemName);
        }
        MenuItem menuItem = menuItemMap.get(itemName);
        menuItemMap.remove(itemName);
        return menuItem;
    }

    public List<MenuItem> browseMenu() {
        return menuItemMap.values().stream().toList();
    }

    public List<MenuItem> browseMenu(VegNonveg vegNonveg) {
        return menuItemMap.values()
                .stream()
                .filter(menuItem -> menuItem.getVegNonveg() == vegNonveg)
                .toList();
    }
}
