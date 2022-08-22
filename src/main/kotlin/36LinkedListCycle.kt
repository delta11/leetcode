/**
 * FROM https://leetcode.com/problems/linked-list-cycle/
 */

object LinkedListCycle {
    @JvmStatic
    fun main(args: Array<String>) {
        val firstList = ListNode(3,
            ListNode(2, null)
                .also {
                    it.next = ListNode(0, ListNode(-4, it))
                }
        )
        println(hasCycle(firstList))
        // Expected true

        val secondList = ListNode(1, null)
            .also { it.next = ListNode(2, it) }
        println(hasCycle(secondList))
        // Expected true

        val thirdList = ListNode(1, null)
        println(hasCycle(thirdList))
        // Expected false
    }

    fun hasCycle(head: ListNode, listNodesProcessed: List<ListNode> = listOf()): Boolean {
        if (head in listNodesProcessed) {
            return true
        }

        return if (head.next != null) {
            hasCycle(head.next!!, listNodesProcessed + head)
        } else false
    }
}

data class ListNode(val value: Int, var next: ListNode?)
