package com.renguangli.rportal.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    private String description;

    private LocalDateTime updateDatetime;

    public Config() {}

    public Config(String name) {
        this.name = name;
    }

    public Config(Integer id, String name, String value, String description, LocalDateTime updateDatetime) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.updateDatetime = updateDatetime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", updateDatetime='" + updateDatetime + '\'' +
                '}';
    }

}
