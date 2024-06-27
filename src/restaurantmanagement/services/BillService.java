package restaurantmanagement.services;

import restaurantmanagement.exceptions.EntityDoesNotExistException;
import restaurantmanagement.models.Customer;
import restaurantmanagement.models.Order;
import restaurantmanagement.models.OrderItem;
import restaurantmanagement.models.OrderStatus;
import restaurantmanagement.models.PaymentMode;
import restaurantmanagement.models.Table;
import restaurantmanagement.models.TableStatus;

public class BillService {
    private final OrderService orderService;
    private final TableService tableService;

    public BillService(OrderService orderService, TableService tableService) {
        this.orderService = orderService;
        this.tableService = tableService;
    }

    public double payBill(Customer customer, PaymentMode paymentMode) throws EntityDoesNotExistException {
        Order order = orderService.getOrderByCustomer(customer);
        double totalCost = 0.0;
        for (OrderItem orderItem : order.getOrderItemMap().values()) {
            totalCost += orderItem.getMenuItem().getPrice() * orderItem.getQuantity();
        }
        if (paymentMode == PaymentMode.CREDIT_CARD) {
            totalCost = 1.01 * totalCost;
        }
        Table table = tableService.getTableByCustomer(customer);
        table.setStatus(TableStatus.VACANT);
        order.setStatus(OrderStatus.CLOSED);
        return totalCost;
    }
}
