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
        System.out.print("null\n");
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
    void insert(int x, int k) {
        if (k < 1) System.out.println("Vi tri chen khong hop le!");
        else if (k == 1) head = new Node(x, head);
        else {
            int vt = 1;
            Node p = head;
            while(p!=null && vt < k - 1) {
                vt++; p = p.next;
            }
            if (p == null) System.out.println("Vi tri chen khong hop le!");
            else {
                Node t = new Node(x, p.next); p.next = t;
            }
        }
    }
    void deleteFirst() {
        if (head == null) System.out.println("Khong xoa duoc 1");
        else head = head.next;
    }
    void deleteEnd() {
        if (head == null) System.out.println("Khong xoa duoc");
        else if (head.next == null) head = null;
        else {
            Node p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            p.next = null;
        }
    }
    void deleteK (int k) {
        if (head == null) System.out.println("Khong xoa duoc");
        else if (k == 1) {
            head = head.next;
        } else {
            int vt = 1;
            Node p = head;
            while (p != null && vt < k - 1) {
                vt++;
                p = p.next;
            }
            if (p == null || p.next == null) {
                System.out.println("Khong xoa duoc");
            } else {
                p.next = p.next.next;
            }
        }
    }
    void reverse() {
        if (head == null) System.out.println("Khong the dao mang");
        else {
            Node current = head, p = null;
            while (current != null) {
                Node temp = current.next;
                current.next = p;
                p = current;
                current = temp;
            }
            while (p != null) {
                System.out.print(p);
                p = p.next;
            }
            System.out.print("null\n");
        }
    }
    boolean checkIncrease() {
        if (head == null) {
            return true;
        }
        for (Node p = head; p.next != null; p = p.next) {
            if (p.data > p.next.data) {
                return false;
            }
        }
        return true;
    }
    void deleteOddElement() {
        if (head == null) System.out.println("Khong the xoa");
        else {
            while (head != null && head.data % 2 == 1) {
                head = head.next;
            }
            Node p = head;
            while (p != null && p.next != null) {
                if (p.next.data % 2 == 1) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
        }
    }
    void sortList() {
        Node p = head, t = null;
        int temp;
        if (head == null) {
            System.out.println("Khong the sap xep duoc");
        } else {
            while (p != null) {
                t = p.next;
                while (t != null) {
                    if (p.data > t.data) {
                        temp = p.data;
                        p.data = t.data;
                        t.data = temp;
                    }
                    t = t.next;
                }
                p = p.next;
            }
        }
    }
    void insertIncreaseList(Node x) {
        if(!checkIncrease()) {
            System.out.println("Danh sach chua tang dan!");
        } else {
            Node t;
            if (head == null || head.data >= x.data) {
                x.next = head;
                head = x;
            } else {
                t = head;
                while (t.next != null && t.next.data < x.data) {
                    t = t.next;
                }
                x.next = t.next;
                t.next = x;
            }
        }
    }
    void printMidleNode() {
        if (head == null) System.out.println("Mang rong khong the thuc hien!");
        else {
            int count = 0;
            Node mid = head;
            while (head != null) {
                if ((count % 2) == 1) mid = mid.next;
                ++count;
                head = head.next;
            }
            if (mid != null) {
                System.out.println("Middle Node: " + mid.data);
            }
        }
    }
    public static void main(String[] args) {
        Linked l = new Linked();
//        l.add(3); l.add(5); l.add(6); l.add(9); l.add(1);
        l.inputList();
        System.out.println("Number of Node: " + l.countNode());
        System.out.println("Total number of Node: " + l.totalNode());
        System.out.println("Odd number of Node: " + l.oddNode());
        System.out.println("Max number of Node: " + l.maxNode());
//        l.appendNode(10);
//        l.insert(8, 3);
//        l.in();
//        l.deleteFirst();
//        l.deleteEnd();
//        l.deleteK(2);
//        l.reverse();
        l.sortList();
        l.in();
        l.insertIncreaseList(4);
        l.in();
//        l.deleteOddElement();
//        if (l.checkIncrease()) {
//            System.out.println("Tang");
//        } else {
//            System.out.println("Khong tang");
//        }
//        l.in();
//        l.printMidleNode();        
    }
}

