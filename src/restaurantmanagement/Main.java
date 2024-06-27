package restaurantmanagement;

import restaurantmanagement.exceptions.EntityAlreadyExistsException;
import restaurantmanagement.exceptions.EntityDoesNotExistException;
import restaurantmanagement.exceptions.TableAlreadyReservedException;
import restaurantmanagement.models.Category;
import restaurantmanagement.models.Customer;
import restaurantmanagement.models.Menu;
import restaurantmanagement.models.MenuItem;
import restaurantmanagement.models.Order;
import restaurantmanagement.models.OrderItem;
import restaurantmanagement.models.PaymentMode;
import restaurantmanagement.models.VegNonveg;
import restaurantmanagement.services.BillService;
import restaurantmanagement.services.MenuService;
import restaurantmanagement.services.OrderService;
import restaurantmanagement.services.TableService;

public class Main {

    public static void main(String[] args) throws EntityAlreadyExistsException, EntityDoesNotExistException, TableAlreadyReservedException {
        Menu menu = new Menu();

        OrderService orderService = new OrderService();
        TableService tableService = new TableService();
        MenuService menuService = new MenuService(menu);
        BillService billService = new BillService(orderService, tableService);

        MenuItem spaghettiCarbonara = new MenuItem("Spaghetti Carbonara", 499, VegNonveg.VEG, Category.STARTER);
        MenuItem frenchFries = new MenuItem("French Fries", 10, VegNonveg.VEG, Category.STARTER);
        MenuItem chickenBiryani = new MenuItem("Chicken Biryani", 100, VegNonveg.NON_VEG, Category.MAIN_COURSE);
        MenuItem margheritaPizza = new MenuItem("Margherita Pizza", 300, VegNonveg.VEG, Category.MAIN_COURSE);
        menuService.addItem(spaghettiCarbonara);
        menuService.addItem(frenchFries);
        menuService.addItem(chickenBiryani);
        menuService.addItem(margheritaPizza);
        System.out.println(menuService.browseMenu());

        System.out.println("---");
        menuService.updateItemPrice("Spaghetti Carbonara", 399);
        System.out.println(menuService.browseMenu());

        System.out.println("---");
        menuService.removeItem("French Fries");
        System.out.println(menuService.browseMenu());

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        System.out.println("---");
        tableService.addTable(1);
        tableService.addTable(2);
        tableService.addTable(3);

        tableService.reserveTable(2, bob);
        tableService.allocateTable(alice);
//        tableService.reserveTable(2, alice); // table already reserved
        System.out.println(tableService.getTables());

        System.out.println("---");
        System.out.println(menuService.browseMenu());
        System.out.println(menuService.browseMenu(VegNonveg.VEG));

        System.out.println("---");
        Order aliceOrder = orderService.addOrder(alice);
        orderService.addOrderItem(alice, new OrderItem(spaghettiCarbonara, 2));
        orderService.addOrderItem(alice, new OrderItem(frenchFries, 3));
        orderService.removeOrderItem(alice, "Spaghetti Carbonara", 1);
        System.out.println(orderService.getOrderByCustomer(alice));
//        orderService.removeOrderItem(alice, "Spaghetti Carbonara", 2); // deleting more than ordered

        System.out.println("---");
        orderService.removeOrderItem(alice, "Spaghetti Carbonara", 1);
        System.out.println(orderService.getOrderByCustomer(alice)); // item itself removed if qty drops to 0

        System.out.println("---");
        System.out.println(orderService.getIncomingOrders()); // bonus

        orderService.markOrderAsPrepared(alice); // bonus
        System.out.println(orderService.getIncomingOrders());

        System.out.println("---");
        System.out.println(billService.payBill(alice, PaymentMode.CREDIT_CARD));

        System.out.println("---");
        System.out.println(orderService.getIncomingOrders());
    }
}
