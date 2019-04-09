package com.zrs.queue;

public class MyQueue {

    Integer[]  arrays;
    int front;
    int rear;

    public MyQueue(Integer[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    boolean isFull(){
        return (this.rear + 1)%(this.arrays.length) == this.front;
    }

    boolean isEmpty(){
        return this.front == this.rear;
    }

    void print(){
        int i = this.front%this.arrays.length;
        while(i != this.rear%this.arrays.length){
            System.out.print(arrays[i]+" ");
            i = (i+1)%this.arrays.length;
        }
        System.out.println();
    }

    void add(int i){
        if(!isFull()){
            this.arrays[this.rear] = i;
            this.rear = (this.rear + 1)%this.arrays.length;
        }
    }

    int poll(){
        if(!isEmpty()){
             int v = this.arrays[this.front];
             this.front = (this.front+1)%this.arrays.length;
             return v;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(new Integer[6],0,0);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        queue.print();

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.print();
        queue.add(7);
        queue.print();
        System.out.println(queue.poll());

    }
}
