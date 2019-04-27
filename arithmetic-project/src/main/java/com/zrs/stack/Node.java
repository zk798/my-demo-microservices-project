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


    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        node.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node7);
        node7.setNext(node8);

        while(node !=null){
            System.out.println(node.value);
            node = node.getNext();
        }

    }


}
