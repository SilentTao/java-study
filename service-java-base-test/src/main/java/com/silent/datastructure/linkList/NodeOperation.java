package com.silent.datastructure.linkList;

public class NodeOperation {


    public static LinkNode add(LinkNode linkNodeList, LinkNode linkNode) {

        LinkNode lastNode=linkNodeList;
        while (lastNode.getNext()!=null){
            lastNode=lastNode.getNext();
        }
        System.out.println("the last node value is "+lastNode.getValue());
        lastNode.setNext(linkNode);
        return linkNodeList;
    }

    public static void printLinkNode(LinkNode linkNodeList) {
        LinkNode linkNode = linkNodeList;
        System.out.println("start print linkNodeList");
        while (linkNode.getNext() != null) {
            System.out.print(linkNode.getValue() + "--");
            linkNode = linkNode.getNext();
        }
        System.out.print(linkNode.getValue() + "--");
        System.out.println("");
        System.out.println("end print LinkNodeList");


    }

    /**
     * 获取链表长度
     *
     * @param linkNodeList
     * @return
     */
    public static int getLinkNodeLength(LinkNode linkNodeList) {
        int length = 1;
        LinkNode linkNode = linkNodeList;
        while (linkNode.getNext() != null) {
            length++;
            linkNode = linkNode.getNext();
        }
        System.out.println("linknode length is : " + length);
        return length;
    }

    public static void main(String[] args) {
        LinkNode a = new LinkNode();
        a.setValue(1);
        LinkNode b = new LinkNode();
        b.setValue(2);
        a.setNext(b);
        LinkNode c = new LinkNode();
        c.setValue(3);
        b.setNext(c);

        printLinkNode(a);
        LinkNode d =new LinkNode();
        d.setValue(4);
        add(a,d);
        printLinkNode(a);
    }

}
