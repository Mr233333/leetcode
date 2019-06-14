/**
 * 初次准备用递归的方法解决
 * 提交之后卡在了第 70/75 cases passed (N/A)
 * 具体用列是[10,5,15,null,null,6,20] 原因在于 6 6应该在第5个位置时正确的递归的办法需要解决与父元素的父元素大小比较的问题
 * 之后 准备用树的前序遍历解决 因为 二叉搜索树 前序遍历结果一定是有序的
 */
class BST {

    val result = ArrayList<Int>()
    fun isValidBST(root: TreeNode?): Boolean {
        LMRThrough(root)
        var index = 1
        var former = result[0]
        var finalResult = true
        while (index < result.size) {
            if (former >= result[index]) {
                finalResult = false
            }else{
                former = result[index]
            }
            index += 1
        }
        return finalResult
    }

    fun LMRThrough(root: TreeNode?) {
        if (root == null) {
            return
        }
        LMRThrough(root.left)
        result.add(root.`val`)
        LMRThrough(root.right)
    }

    open class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main() {
    //val testCase = arrayListOf<Int?>(5,1,4,null,null,3,6)
    val testCase = BST.TreeNode(5)
    testCase.left = BST.TreeNode(1)
    testCase.right = BST.TreeNode(4)
    testCase.right!!.left = BST.TreeNode(3)
    testCase.right!!.right = BST.TreeNode(6)
    val bst = BST()
    bst.isValidBST(testCase)
}