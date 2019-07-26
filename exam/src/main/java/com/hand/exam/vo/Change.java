package com.hand.exam.vo;

import java.io.Serializable;

public class Change implements Serializable {
private short custom_id;

    public short getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(short custom_id) {
        this.custom_id = custom_id;
    }

    @Override
    public String toString() {
        return "Change{" +
                "custom_id=" + custom_id +
                '}';
    }
}
