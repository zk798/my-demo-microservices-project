package com.zrs.stack;

public class MyLinked {

    Node<Integer> init(int count){
        Node<Integer> head = null;
        Node<Integer> cur = null;
        for (int i = 1; i <= count ; i++) {
            Node<Integer> node = new Node<>();
            node.setValue(i);
            if(head == null){
                head = node;

            }else{
                cur.setNext(node);
            }
            cur = node;
        }
        return head;
    }

    void print(Node head){
        while(head != null){
            System.out.print(head.getValue() +" ");
            head = head.getNext();
        }
        System.out.println();
    }

    /**取中点*/
    Node mid(Node head){
        Node f = head;
        Node l = head;
        while(f != null && f.getNext() != null){
            f = f.getNext().getNext();
            l = l.getNext();
        }
        System.out.println("l="+l);
        return l;
    }
    /**反转*/
    Node reverse(Node head){
        Node prev = null;
        Node next = null;
        Node cur = null;
        while(head != null){
            next = head.getNext();
            cur = head;
            head.setNext(prev);
            prev = cur;
            head = next;
        }
        return cur;
    }

    /**合并 a < b*/
    Node meger(Node<Integer> a, Node<Integer> b){

        Node<Integer> node = a;
        Node<Integer> cur = a;
        Node<Integer> pre = a;

        while(b != null && a != null){
            if(b.getValue() > a.getValue()){
                pre = a;
                a = a.getNext();
                cur = a;
            }else{
                Node<Integer> next = b.getNext();
                b.setNext(cur);
                pre.setNext(b);
                pre = b;
                b = next;
            }
            if(a ==null && b!= null){
                pre.setNext(b);
            }
        }
        return node;
    }

    /**合并 a < b*/
    Node<Integer> meger2(Node<Integer> a, Node<Integer> b){
        if(a == null){
            return b;
        }if(b == null){
            return a;
        }

        if(a.getValue() < b.getValue()){
            a.setNext(meger2(a.getNext(),b));
            return a;
        }else{
            b.setNext(meger2(a,b.getNext()));
            return b;
        }
    }

    public static void main(String[] args) {
        MyLinked myLinked = new MyLinked();
        Node<Integer> head = myLinked.init(9);
        myLinked.print(head);
        myLinked.mid(head);

        Node reverse = myLinked.reverse(head);
        myLinked.print(reverse);


        Node<Integer> node = new Node<>(1);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        node.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node7);
        node7.setNext(node8);

        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n6 = new Node<>(6);
        n2.setNext(n3);
        n3.setNext(n6);

//        System.out.println("-----");
//        Node meger = myLinked.meger(node, n2);
//        myLinked.print(meger);

        System.out.println("2-----");
        Node meger2 = myLinked.meger2(node, n2);
        myLinked.print(meger2);
    }
}
