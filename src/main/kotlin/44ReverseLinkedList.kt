/**
 * FROM https://leetcode.com/problems/reverse-linked-list/
 */

object ReverseLinkedList {
    @JvmStatic
    fun main(args: Array<String>) {
        println(reverseList(linkedListNodeRange(5)))
        // Expected [5,4,3,2,1]


        println(reverseList(linkedListNodeRange(2)))
        // Expected [2,1]
    }

    fun reverseList(head: ListNode, previous: ListNode? = null): ListNode {
        head.next?.let { next ->
            return reverseList(next, head)
                .also {
                    next.next = head
                    head.next = previous
                }
        }
        return head
    }
}


fun linkedListNodeRange(size: Int, count: Int = 1): ListNode =
    ListNode(count, if (count < size) linkedListNodeRange(size, count + 1) else null)

