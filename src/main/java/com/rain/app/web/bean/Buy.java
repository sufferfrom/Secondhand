package com.rain.app.web.bean;

public class Buy {
    private int id;
    private int c_id;
    private int s_id;
    private int state;

    public Buy(int c_id, int s_id, int state) {
        this.c_id = c_id;
        this.s_id = s_id;
        this.state = state;
    }

    public Buy() {

    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", c_id=" + c_id +
                ", s_id=" + s_id +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
