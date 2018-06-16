package top.shop.entity;

import java.io.Serializable;

/**
 * 水果类别
 */
public class FruitType implements Serializable {
    /**
     * 类别ID
     */
    private String id;
    /**
     * 类别名
     */
    private String name;

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
}
