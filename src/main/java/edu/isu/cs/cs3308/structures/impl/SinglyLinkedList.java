package edu.isu.cs.cs3308.structures.impl;


import edu.isu.cs.cs3308.structures.List;
import java.io.*;
import java.lang.annotation.ElementType;

public class SinglyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size = 0;


    @Override
    public E first() {
        if(isEmpty()) {
            return null;
        }
        else if(head == null){
            head = tail;
            return head.getElement();
        }
        else if(head != null){
            return head.getElement();
        }
       return null;
    }

    @Override
    public E last() {
        if(isEmpty()) {
            return null;
        }
//        else if(tail !=null){
//            return tail.getElement();
//
//        }
//        return null;
        return tail.getElement();
    }

    @Override
    public void addLast(E element) {
        if(element == null){
            return;
        }
        Node<E> newNode = new Node<>(element);
        newNode.setNext(null);
        tail = newNode;
        size++;

    }

    @Override
    public void addFirst(E element) {
        if (element == null){
            return;
        }

        Node<E> newNode = new Node<>(element);
        newNode.setNext(head);
        head= newNode;

        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        else if(head == null){
            head = tail;
            size--;
            return head.getElement();
        }

            Node<E> temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
            return head.getElement();



    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        else if(head==null){
            head = tail;
            size--;
            return tail.getElement();
        }
        else if(head !=null){
            Node<E> temp = head;
            Node<E> temp2 = head.next;

            while(temp2.getNext()!=null){
                temp = temp.getNext();
            }
            temp.next = null;
            tail = temp2;
            size--;

            return tail.getElement();
        }
        return null;
    }

    @Override
    public void insert(E element, int index) {
        if(element !=null && index>0 && head !=null){

            Node<E> prev = head;
            for(int i =0; i< index-1; i++){
                prev = prev.getNext();
            }
            Node<E> nexttemp = prev.getNext();
            Node<E> newtemp = new Node<E>(element);

            newtemp.setNext(nexttemp);
            prev.setNext(newtemp);
            size++;

        } else if(index >= size()){
            addLast(element);
        }


    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        if(index< 0 || index>=size()){
            return null;
        }
        else if(head != null){
            Node<E> temp = head;
            for(int i=0; i< index; i++){
                temp = temp.getNext();
            }
            return temp.getElement();
        }
        return null;
    }

    @Override
    public int size() {

        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(size()==0)
        {
            return true;
        }
        return false;
    }

    @Override
    public void printList() {
        SinglyLinkedList<E> printNode;
        for(int i = 0; i <size(); i++){

            System.out.println(get(i));
        }
    }



    public SinglyLinkedList(){

    };


}
