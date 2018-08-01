package com.renguangli.rportal.bean;

import java.io.Serializable;

/**
 * Config
 *
 * @author renguangli 2018/8/1 10:21
 * @since JDK 1.8
 */
public class Config implements Serializable{

    private static final long serialVersionUID = 363429614733927422L;

    private Integer id;

    private String name;

    private String value;

    public Config() {}

    public Config(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Config{" + "id=" + id + ", name=" + name + ", value=" + value + "}";
    }

}
