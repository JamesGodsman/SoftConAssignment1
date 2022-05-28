/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queuemanager;

/**
 *
 * @author James
 */
public class QueueNode<T> {
    private T item;
    private int priority;
    private QueueNode<T> next;
    
    public QueueNode(T item, int priority, QueueNode<T> next) {
        this.item = item;
        this.priority = priority;
        this.next = next;
        
    }
    
    public T getItem() {
        return item;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int input) {
        priority = input;
    }
    

    
    public QueueNode<T> getNext() {
        return next;
    }
    
    public void setNext(QueueNode<T> input) {
        next = input;
    }
}