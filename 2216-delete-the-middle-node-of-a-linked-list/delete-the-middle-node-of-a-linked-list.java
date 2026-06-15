class Solution {
    ListNode prev, fakeHead;
    void traverse(ListNode p, ListNode q, boolean isOdd){
        if(q==null) prev.next=prev.next.next;
        else{
            if(isOdd) {
                prev=p;
                p=p.next;
            }
            traverse(p,q.next,!isOdd);
        }
    }
    public ListNode deleteMiddle(ListNode head) {
        fakeHead=prev=new ListNode(0,head);
        traverse(head,head,false);
        return fakeHead.next;
    }
}