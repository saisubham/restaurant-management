package restaurantmanagement.exceptions;

public class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(int id) {
        super("table already reserved = " + id);
    }
}
