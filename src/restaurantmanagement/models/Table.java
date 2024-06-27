package restaurantmanagement.models;

public class Table {
    private int id;
    private Customer customer;
    private TableStatus status;

    public Table(int id) {
        this.id = id;
        this.customer = null;
        this.status = TableStatus.VACANT;
    }

    public int getId() {
        return id;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", customer=" + customer +
                ", status=" + status +
                '}';
    }
}
