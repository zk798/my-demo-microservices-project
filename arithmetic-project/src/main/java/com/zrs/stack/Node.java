package com.zrs.stack;

import lombok.Data;

@Data
public class Node <T>{
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node() {
    }

}
