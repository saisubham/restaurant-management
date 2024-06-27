package restaurantmanagement.models;

public class MenuItem {
    String name;
    double price;
    VegNonveg vegNonveg;
    Category category;

    public MenuItem(String name, double price, VegNonveg vegNonveg, Category category) {
        this.name = name;
        this.price = price;
        this.vegNonveg = vegNonveg;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public VegNonveg getVegNonveg() {
        return vegNonveg;
    }

    public Category getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", vegNonveg=" + vegNonveg +
                ", category=" + category +
                '}';
    }
}
