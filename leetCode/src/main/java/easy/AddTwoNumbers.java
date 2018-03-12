package easy;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = l3;
        ListNode l1 = new ListNode(2);
        l1.next = l2;

        ListNode q3 = new ListNode(4);
        ListNode q2 = new ListNode(6);
        q2.next = q3;
        ListNode q1 = new ListNode(5);
        q1.next = q2;
        System.out.println(addTwoNumbers(l1,q1));

//        ListNode q3 = new ListNode(4);
//        ListNode q2 = new ListNode(6,q3);
//        ListNode q1 = new ListNode(5,q2);
//        System.out.println(addTwoNumbers(l1,q1));
    }

    /**
     * 给你两个非空链表，表示两个非负整数。数字以相反的顺序存储，每个节点都包含一个数字。添加这两个数字并将其作为链接列表返回。
     * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
     * 例:
     * 输入：（2→4→3）+（5→6→4）
     * 输出： 7→0→8
     * 说明： 342 + 465 = 807。
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode qq;
        ListNode ll = null;
        int sum;
        int add;
        while (true){
            sum = l1.val + l2.val;
            if (sum >= 10) {
                qq = new ListNode(sum %10);
                add = sum/10;
            } else {
                qq = new ListNode(sum);
                add = 0;
            }
            if(l1.next != null){
                l1.next.val = add + l1.next.val;
            }else if(add > 0){
                l1.next = new ListNode(add);
            }
            l1 = l1.next;
            l2 = l2.next;
            if(ll == null){
                ll = qq;
            }else {
                ll.next = qq;
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

//    @Override
//    public String toString() {
//        StringBuffer stringBuffer = new StringBuffer("(" + this.val);
//
//        while (this.next != null) {
//            stringBuffer.append("->").append(this.next.val);
//            this.next = this.next.next;
//        }
//        stringBuffer.append(")");
//        return String.valueOf(stringBuffer);
//    }
}
