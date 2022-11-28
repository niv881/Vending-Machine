package utilities;

import java.util.Objects;

public abstract class Product {

    private final String name;

    private final int cost;

    private int capacity;


    public Product(String name, int cost, int capacity) {
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return
                "name : " + name +
                " , cost : " + cost +
                " , capacity : " + capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
