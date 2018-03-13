package medium;

import entity.ListNode;

/**
 * 给你两个非空链表，表示两个非负整数。数字以相反的顺序存储，每个节点都包含一个数字。
 * 添加这两个数字并将其作为链接列表返回。
 * 您可以假设这两个数字不包含任何前导零，除了数字0本身。
 * 例:
 * 输入：（2→4→3）+（5→6→4）
 * 输出： 7→0→8
 * 说明： 342 + 465 = 807。
 *
 * @author hdd
 */
public class AddTwoNumbers {
    /**
     * key:引用
     * ll 为结果
     * qq 为指针
     * qq = ll.next 当qq改变时，ll.next同步改变
     * qq = qq.next qq.next即ll.next.next，赋值后qq的改变ll.next.next同步改变
     * 一直到 ll 最后的 next == null 结束
     *
     * @param l1 singly-linked list A
     * @param l2 singly-linked list B
     * @return singly-linked list  A + B
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode ll = new ListNode(0);
        ListNode qq = ll;
        int sum;
        int add = 0;
        while (l1 != null || l2 != null) {
            sum = l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            sum += add;
            qq.next = new ListNode(sum % 10);
            add = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            qq = qq.next;
        }
        if (add > 0) {
            qq.next = new ListNode(add);
        }
        return ll.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}


