package com.eugene.exception;

public class OrderOperationException extends Exception {

    private String key;
    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public OrderOperationException(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public OrderOperationException() {}
}
