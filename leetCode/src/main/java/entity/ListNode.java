package entity;

/**
 * singly-linked list
 * @author hdd
 */
public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
        }

        public ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("(" + this.val);

            while (this.next != null) {
                stringBuffer.append("->").append(this.next.val);
                this.next = this.next.next;
            }
            stringBuffer.append(")");
            return String.valueOf(stringBuffer);
        }
    }