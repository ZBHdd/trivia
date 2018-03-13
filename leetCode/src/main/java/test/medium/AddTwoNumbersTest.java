package test.medium;

import entity.ListNode;
import medium.AddTwoNumbers;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    private ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    private ListNode q1 = new ListNode(5, new ListNode(6, new ListNode(4)));

    @Test
    void addTwoNumbers1() {
        System.out.println(addTwoNumbers.addTwoNumbers1(l1, q1));
    }

    @Test
    void addTwoNumbers2() {
        System.out.println(addTwoNumbers.addTwoNumbers2(l1, q1));
    }
}