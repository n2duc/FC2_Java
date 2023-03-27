/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package n2d;

/**
 *
 * @author N2DUC
 */
import java.util.*;

class Node {
    int data;
    Node next;
    Node (int x) {
        data = x;
        next = null;
    }
    Node (int x, Node t) {
        data = x;
        next = t;
    }
    public String toString() {
        String t = "" + data + " -> ";
        return t;
    }
}
public class Linked {
    Node head;
    void add(int x) {
        head = new Node(x, head);
    }
    void in() {
        Node p = head;
        while (p!=null) {
            System.out.print(p);
            p = p.next;
        }
        System.out.print("null");
    }
    void inputList() {
        Scanner sc = new Scanner(System.in);
        int x;
        Node last = null;
        head = null;
        while(true) {
            x = sc.nextInt();
            if (x == 0) break;
            Node t = new Node(x);
            if (head == null) {
                head = last = t;
            } else {
                last.next = t;
                last = t;
            }
        }
    }
    int countNode() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    int totalNode() {
        int total = 0;
        Node p = head;
        while (p != null) {
            total += p.data;
            p = p.next;
        }
        return total;
    }
    int oddNode() {
        int odd = 0;
        Node p = head;
        while (p != null) {
            if (p.data % 2 != 0) odd++;
            p = p.next;
        }
        return odd;
    }
    int maxNode() {
        int max = 0;
        Node p = head;
        while (p != null) {
            if (p.data > max) max = p.data;
            p = p.next;
        }
        return max;
    }
    void appendNode(int x) {
        Node t = new Node(x);
        if (head == null) {
            head = t;
        } else {
            Node p = head;
            while (p.next != null) p = p.next;
            p.next = t;
        }
    }
    void deleteNode(int k) {
        
    }
    public static void main(String[] args) {
        Linked l = new Linked();
        l.add(3); l.add(5); l.add(6); l.add(9); l.add(1);
//        l.inputList();
        System.out.println("Number of Node: " + l.countNode());
        System.out.println("Total number of Node: " + l.totalNode());
        System.out.println("Odd number of Node: " + l.oddNode());
        System.out.println("Max number of Node: " + l.maxNode());
        l.appendNode(10);
        l.in();
    }
}
