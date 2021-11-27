package at.htl.josephus.control;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Node extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "NODE_ID")
    private Node next;

    private int position;

    public Node() {
    }

    public Node(Person person) {
        this.person = person;
    }

    public Node(Person person, Node next) {
        this.person = person;
        this.next = next;
    }

    public Node(Person person, Node next, int position) {
        this.person = person;
        this.next = next;
        this.position = position;
    }

    Node removeNext(){
        return next = next.getNext();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", getPerson().getName(), getPosition());
    }
}
