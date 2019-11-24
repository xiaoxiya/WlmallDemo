package redis.cart;

import java.io.Serializable;

/**
 * @author luopeng
 * @date 2019/11/24 21:37
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sku;
    private String name;
    private float price;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
