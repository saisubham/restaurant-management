package restaurantmanagement.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import restaurantmanagement.exceptions.EntityAlreadyExistsException;
import restaurantmanagement.exceptions.EntityDoesNotExistException;
import restaurantmanagement.exceptions.TableAlreadyReservedException;
import restaurantmanagement.models.Customer;
import restaurantmanagement.models.Table;
import restaurantmanagement.models.TableStatus;

public class TableService {
    private Map<Integer, Table> tableMap;

    public TableService() {
        this.tableMap = new HashMap<>();
    }

    public List<Table> getTables() {
        return tableMap.values().stream().toList();
    }

    public Table getTableByCustomer(Customer customer) {
        List<Table> tables = tableMap.values().stream().toList();
        for (Table table : tables) {
            if (table.getCustomer() == customer) {
                return table;
            }
        }
        return null;
    }

    public Table addTable(int id) throws EntityAlreadyExistsException {
        if (tableMap.containsKey(id)) {
            throw new EntityAlreadyExistsException("table " + id);
        }
        Table table = new Table(id);
        tableMap.put(id, table);
        return table;
    }

    public Table vacateTable(int id) throws EntityDoesNotExistException {
        if (!tableMap.containsKey(id)) {
            throw new EntityDoesNotExistException("table " + id);
        }
        Table table = tableMap.get(id);
        table.setStatus(TableStatus.VACANT);
        return table;
    }

    public Table reserveTable(int id, Customer customer) throws EntityDoesNotExistException, TableAlreadyReservedException {
        if (!tableMap.containsKey(id)) {
            throw new EntityDoesNotExistException("table " + id);
        }
        Table table = tableMap.get(id);
        if (table.getStatus() != TableStatus.VACANT) {
            throw new TableAlreadyReservedException(id);
        }
        if (table.getCustomer() == customer) {
            throw new IllegalArgumentException("same customer cannot book another table");
        }
        table.setCustomer(customer);
        table.setStatus(TableStatus.RESERVED);
        return table;
    }

    public Table allocateTable(Customer customer) throws TableAlreadyReservedException, EntityDoesNotExistException {
        List<Table> tables = tableMap.values().stream().toList();
        for (Table table : tables) {
            if (table.getStatus() == TableStatus.VACANT) {
                reserveTable(table.getId(), customer);
                return table;
            }
        }
        return null;
    }
}
