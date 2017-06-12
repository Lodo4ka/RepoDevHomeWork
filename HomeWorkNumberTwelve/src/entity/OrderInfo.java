package entity;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class OrderInfo {

    int id;
    String name;
    int product;
    int amount;
    int price;


    public OrderInfo(int id, String name, int product, int amount, int price) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
