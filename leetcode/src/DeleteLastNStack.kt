import com.sun.jmx.remote.internal.ArrayQueue
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.util.*

class DeleteLastNStack {
    fun removeNthFromEnd(head: ListNodes?, n: Int): ListNodes? {
        val s = ArrayList<ListNodes>(n)
        var cursor = head
        var former:ListNodes? = null
        while (cursor != null) {
            if (s.size >= n) {
                former = s[0]
                s.removeAt(0)
            }
            s.add(cursor)
            cursor = cursor.next
        }
        if(head == s[0]){
            cursor = head.next
            return cursor
        }
        s.removeAt(0)
        if(former ==null){
            return null
        }
        if(s.isEmpty()){
            former.next = null
        }else{
            former.next = s[0]
        }
        return head
    }

    open class ListNodes(var `val`: Int) {
        var next: ListNodes? = null
    }
}

fun main(args: Array<String>) {
    val testData = listOf(1, 2)
    val head = DeleteLastNStack.ListNodes(-1);
    var cursour = head
    for (num in testData) {
        cursour.next = DeleteLastNStack.ListNodes(num)
        cursour = cursour.next!!
    }
    val deleteLastNStack = DeleteLastNStack()
    deleteLastNStack.removeNthFromEnd(head.next, 2);
}