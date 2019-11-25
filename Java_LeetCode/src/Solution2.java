//第二题
/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例：

        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807*/

/**
 * @ClassName: Solution2
 * @Auther: zzf
 * @Date: 2019/11/25 22:59
 * @Description:
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //构建列表
        ListNode li = new ListNode(0);
        ListNode cur = li;
        //高位
        int height = 0;
        //只要节点不为null
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //计算和
            int sum = x + y + height;

            //可能存在大于10的情况
            height = sum / 10;
            sum = sum % 10;
            //构建下个节点
            cur.next = new ListNode(sum);

            //自增
            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //判断height是否大于1
        if (height == 1) {
            cur.next = new ListNode(1);
        }
        return li.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l1 = new Solution2().addTwoNumbers(l1, l2);
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


