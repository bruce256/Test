package linked;

/**
 * @author LvSheng
 * @date 2020/5/15
 **/
class Node<ItemType> {
    ItemType data;    // 数据域
    Node     next;    // 指针域
}


class LinkedList<ItemType> {
    Node<ItemType> head = new Node<>();     // 头结点

}


public class LinkedListDemo {
    Node<Integer> head = new Node<>();     // 头结点

    // 前插法创建
    public void createAfterHead(Node<Integer> node) {
        node.next = head.next;
        head.next = node;
    }

    public void traverse() {
        Node p = head.next;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public void delete(int index) {
        Node p   = head;
        int  num = 0;

        // 右移index个节点,找到要删除的节点的前一个节点
        while (num < index && p != null) {
            num++;
            p = p.next;
        }

        // index超出范围
        if (num < index || p == null) throw new IndexOutOfBoundsException();

        // 执行删除操作
        p.next = p.next.next;
    }

    // 将节点插入到指定下标
    public void insert(int index, Node node) {
        Node p   = head;
        int  num = 0;

        // 右移index个节点,找到要插入的节点的前一个节点
        while (num < index && p != null) {
            num++;
            p = p.next;
        }

        // index超出范围
        if (num < index || p == null) throw new IndexOutOfBoundsException();

        node.next = p.next;
        p.next = node;
    }
}
