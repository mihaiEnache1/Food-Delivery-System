package businessLayer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Order implements Serializable {
    private int orderID;
    private final int clientID;
    private final LocalDateTime orderDate;
    private float price;
    private final ArrayList<MenuItem> products;

    public Order(int orderID, int clientID, LocalDateTime orderDate, float price, ArrayList<MenuItem> products) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.orderDate = orderDate;
        this.price = price;
        this.products = products;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", orderDate=" + orderDate +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderID == order.orderID && clientID == order.clientID && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, orderDate, price);
    }
}
