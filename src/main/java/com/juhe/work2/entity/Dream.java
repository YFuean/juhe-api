package com.juhe.work2.entity;

/**
 * 周公解梦
 */
public class Dream {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dream{" +
                "name='" + name + '\'' +
                '}';
    }
}
