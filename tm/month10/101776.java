/**
 * 力扣234.回文链表
 * 
 */


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){//先用快慢指针找到中间位置
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode p=slow,q=null;//翻转后半段链表
        while(p!=null){
            ListNode r=p.next;
            p.next=q;
            q=p;
            p=r;
        }

        p=head;
        while(q!=null){//判断是否为回文
            if(q.val!=p.val)return false;
            q=q.next;
            p=p.next;
        }

        return true;
    }
}