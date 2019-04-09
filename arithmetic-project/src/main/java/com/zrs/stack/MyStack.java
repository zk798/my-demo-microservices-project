package com.zrs.stack;

public class MyStack {

    private Node top;
    private Node bottom;

    void pushTop(Node node){
        node.setNext(this.top);
        top = node;
        if(bottom == null){
            bottom = top;
        }
    }



    void print(){
        while(top != null) {
            System.out.println(top.getValue() +" ");
            top = top.getNext();
        }
        System.out.println();
    }

    Node pop(){
        if(top != null){
            Node t = top;
            top = top.getNext();
            return t;
        }
        return null;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.pushTop(new Node(1));
        myStack.pushTop(new Node(2));
        myStack.pushTop(new Node(3));

//        myStack.print();

        System.out.println("pop="+myStack.pop());
        System.out.println("pop="+myStack.pop());
        System.out.println("pop="+myStack.pop());
    }
}
