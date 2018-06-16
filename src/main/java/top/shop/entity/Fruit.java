package top.shop.entity;

import java.io.Serializable;

/**
 * 水果实体
 * @author 1
 */
public class Fruit implements Serializable {
    /**
     * 水果ID
     */
    private String id;
    /**
     * 水果名称
     */
    private String name;
    /**
     * 价格
     */
    private double price;
    /**
     * 图片地址
     */
    private String address;
    /**
     * 水果类别ID
     */
    private String typeId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
