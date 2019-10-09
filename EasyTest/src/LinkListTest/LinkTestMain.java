package LinkListTest;
import java.util.*;




class ListNode<Template>{
    ListNode(){

    }
    ListNode(Template val){
        this.val = val;
        this.next = null;
    }
    ListNode next;
    Template val;

    //尾插法
    void addNodeATtail(Template newVal){
        ListNode newNode = new ListNode(newVal);
        ListNode flag;
        if(this.next == null){
            this.next = newNode;
        }else {
            flag = this.next;
            while (flag.next != null){
                flag = flag.next;
            }
            flag.next = newNode;
        }
    }

    //头插法
    void addNodeAThead(Template newVal){
        ListNode newNode = new ListNode(newVal);
        if(this.next == null){
            this.next = newNode;
        }else {
            newNode.next = this.next;
            this.next = newNode;
        }
    }

}




public class LinkTestMain {
    public static void main(String []args){

        //l1 = {3, 13, 12, 11, 4, 21}
        ListNode<Integer> l1 = new ListNode<>(3);
        l1.addNodeATtail(13);
        l1.addNodeATtail(15);
        l1.addNodeATtail(16);
        l1.addNodeATtail(20);
        l1.addNodeATtail(21);

        ListNode<Integer> l2 = new ListNode<>(1);
        l2.addNodeATtail(3);
        l2.addNodeATtail(5);
        l2.addNodeATtail(7);
        l2.addNodeATtail(11);
        l2.addNodeATtail(19);
        l2.addNodeATtail(21);

        //ListNode<Integer> t = null;
        //t = MergeTwoList(l1,l2);

        ListNode<Integer> la = new ListNode<>(11);
        ListNode<Integer> lb = new ListNode<>(12);
        ListNode<Integer> lc = new ListNode<>(33);
        ListNode<Integer> ld = new ListNode<>(51);
        ListNode<Integer> le = new ListNode<>(22);
        la.next = lb;
        lb.next = lc;
        lc.next = ld;
        ld.next = le;
        le.next = lc;
        ListNode<Integer> lhead = la;

        ListNode<Integer> temp = isLoop(lhead);
        System.out.println(temp.val);

        //showAllNodes();





    }

    public static ListNode isLoop(ListNode head){
        if(head == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        if(p2.next != null){
            p2 = p2.next.next;
        }else{return null;}
        p1 = p1.next;

        while (p1 != p2){
            if(p2 != null && p2.next != null){
                p2 = p2.next.next;
            }else {
                return null;
            }
            p1 = p1.next;
        }

        while (head != p1){
            p1 = p1.next;
            head = head.next;
        }
        return head;

    }


    public static ListNode<Integer> MergeTwoList(ListNode<Integer> head1, ListNode<Integer> head2){
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode temp = null;
        if(head1.val > head2.val){
            temp = head2;
            head2.next = MergeTwoList(head1,head2.next);
        }else {
            temp = head1;
            head1.next = MergeTwoList(head1.next, head2);
        }
        return temp;

    }

    //非递归
    public static ListNode ReverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //递归
    public static ListNode ReverseListDigui(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode temp = head.next;
        ListNode newhead = ReverseListDigui(head.next);
        temp.next = head;
        return newhead;

    }


    private static  void showAllNodes(ListNode head){
        if(head == null){
            System.out.println("no NODES!");
        }
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }



    }

}
