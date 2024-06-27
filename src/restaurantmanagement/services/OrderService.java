package restaurantmanagement.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import restaurantmanagement.exceptions.EntityDoesNotExistException;
import restaurantmanagement.models.Customer;
import restaurantmanagement.models.Order;
import restaurantmanagement.models.OrderItem;
import restaurantmanagement.models.OrderStatus;

public class OrderService {
    private final Map<Customer, Order> orderMap;

    public OrderService() {
        orderMap = new HashMap<>();
    }

    public Order getOrderByCustomer(Customer customer) throws EntityDoesNotExistException {
        if (!orderMap.containsKey(customer)) {
            throw new EntityDoesNotExistException("customer = " + customer);
        }
        return orderMap.get(customer);
    }

    public Order addOrder(Customer customer) {
        Order order = new Order(customer);
        orderMap.put(customer, order);
        return order;
    }

    public void addOrderItem(Customer customer, OrderItem orderItem) throws EntityDoesNotExistException {
        Map<String, OrderItem> orderItemMap = getOrderItemMap(customer);
        orderItemMap.put(orderItem.getMenuItem().getName(), orderItem);
    }

    public void removeOrderItem(Customer customer, String itemName, int quantity) throws EntityDoesNotExistException {
        Map<String, OrderItem> orderItemMap = getOrderItemMap(customer);
        if (!orderItemMap.containsKey(itemName)) {
            throw new EntityDoesNotExistException("orderItem = " + itemName);
        }
        OrderItem orderItem = orderItemMap.get(itemName);
        if (quantity > orderItem.getQuantity()) {
            throw new IllegalArgumentException("can't remove more quantity than ordered");
        }
        if (quantity == orderItem.getQuantity()) {
            orderItemMap.remove(itemName);
        }
        orderItem.setQuantity(orderItem.getQuantity() - quantity);
    }

    public void updateOrderItemQuantity(Customer customer, String itemName, int quantity) throws EntityDoesNotExistException {
        Map<String, OrderItem> orderItemMap = getOrderItemMap(customer);
        if (!orderItemMap.containsKey(itemName)) {
            throw new EntityDoesNotExistException("orderItem = " + itemName);
        }
        OrderItem orderItem = orderItemMap.get(itemName);
        if (quantity == 0) {
            orderItemMap.remove(itemName);
        }
        orderItem.setQuantity(quantity);
    }

    public void closeOrder(Customer customer) throws EntityDoesNotExistException {
        if (!orderMap.containsKey(customer)) {
            throw new EntityDoesNotExistException("order for customer " + customer);
        }
        Order order = orderMap.get(customer);
        order.setStatus(OrderStatus.CLOSED);
    }

    private Map<String, OrderItem> getOrderItemMap(Customer customer) throws EntityDoesNotExistException {
        if (!orderMap.containsKey(customer)) {
            throw new EntityDoesNotExistException("order for customer = " + customer);
        }
        return orderMap.get(customer).getOrderItemMap();
    }

    public void markOrderAsPrepared(Customer customer) throws EntityDoesNotExistException {
        if (!orderMap.containsKey(customer)) {
            throw new EntityDoesNotExistException("order for customer " + customer);
        }
        Order order = orderMap.get(customer);
        order.setStatus(OrderStatus.PREPARED);
    }

    public List<Order> getIncomingOrders() {
        return orderMap.values()
                .stream()
                .filter(order -> order.getStatus() == OrderStatus.IN_PROGRESS)
                .toList();
    }

}
