package restaurantmanagement.models;

import java.util.HashMap;
import java.util.Map;

import restaurantmanagement.exceptions.EntityDoesNotExistException;

public class Order {
    private final Customer customer;
    private final Map<String, OrderItem> orderItemMap;
    private OrderStatus status;

    public Order(Customer customer) {
        this.customer = customer;
        orderItemMap = new HashMap<>();
        this.status = OrderStatus.IN_PROGRESS;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<String, OrderItem> getOrderItemMap() {
        return orderItemMap;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", orderItemMap=" + orderItemMap +
                ", status=" + status +
                '}';
    }
}
