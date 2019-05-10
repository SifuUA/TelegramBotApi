package com.okres.garbagecleaner;

import java.util.StringJoiner;

public class Model {
    private String name;
    private Double temp;
    private Double humidity;
    private String icon;
    private String main;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Model.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("temp=" + temp)
                .add("humidity=" + humidity)
                .add("icon='" + icon + "'")
                .add("main='" + main + "'")
                .toString();
    }
}
