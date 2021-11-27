package at.htl.josephus.control;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.UUID;

public class Josephusring{

    private Node head;

    private int fatalNo;

    private UUID uuid;

    private StringBuilder output;

  //TODO: Code vereinfacht

    public Josephusring() {
        this.uuid = UUID.randomUUID();
    }

    public Josephusring(int noOfPersons, int fatalNo) {
        this();
        this.fatalNo = fatalNo;
        initRing(noOfPersons);
    }

    public Node findLastPerson() {

        Node act = null;
        Node prev = null;
        int i = 2;

        prev = head;
        act = head.getNext();

        do {
                if (i == fatalNo) {
                    prev.removeNext();
                    if (act.getNext().getNext() == head){
                        act.getNext().setNext(head);
                    }
                    if (act == head) {
                        head = act.getNext();
                    }
                    i = 0;
                    act = act.getNext();
                }else {
                    prev = act;
                    act = act.getNext();
                }
                i++;
        }while (act != prev);

        return prev;
    }

    private void addLineToOutput(String line){
        output.append(line.toString() + "\n");
    }

    void initRing(int noOfPersons){
        Node node = null;
        Node prev = null;
        char name = 'A';
        //TODO: Code vereinfacht
//        if (noOfPersons > 25){
//            noOfPersons = 25;
//        }
        noOfPersons = Math.min(noOfPersons,25);

        if (noOfPersons != 0) {
            for (int i = 0; i <= noOfPersons; i++) {
                node = new Node(new Person(Character.toString(name)), null, i);
                if (i == noOfPersons) {
                    prev.setNext(getHead());
                } else {
                    if (prev != null) {
                        prev.setNext(node);
                    }
                }
                if (i == 0) {
                    this.head = node;
                }
                name++;
                prev = node;
            }

        }


    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getFatalNo() {
        return fatalNo;
    }

    public void setFatalNo(int fatalNo) {
        this.fatalNo = fatalNo;
    }

    public StringBuilder getOutput() {
        return output;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        StringBuilder list;
        Node next = null;

        if (head == null){
            list = new StringBuilder("empty ring");
        }else {
            list = new StringBuilder(head.getPerson().getName() + " (" + head.getPosition() + ")");

            next = head.getNext();

            while (next != null && next != head) {
                list.append(" - ").append(next.getPerson().getName()).append(" (").append(next.getPosition()).append(")");
                next = next.getNext();
            }
        }

        return list.toString();
    }
}

