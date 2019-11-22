class BST{
    Node root;

static class Node{
    Node left;
    Node right;
    int key;
    int value;

    public Node(int k){
        left =null;
        key = k;
        value = 0;
        right = null;
    }
}

private boolean isBST() {
    return isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
}

private boolean isBST(Node x, int min, int max) {
    if (x == null) 
    {
        return true;
    }
    if (min != 0 && x.key - (min) <= 0)
    {
     return false;
    }
    if (max != 0 && x.key - (max) >= 0){
         return false;
    }
    return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
} 
public static void main(String[] args) {
    BST obj = new BST();
    obj.root = new Node(5);
    obj.root.left = new Node(3);
    obj.root.right = new Node(10);
    obj.root.left.left = new Node(1);
    obj.root.left.right = new Node(4);
    obj.root.right.left = new Node(9);
    obj.root.right.right = new Node(12);
    System.out.println(obj.isBST());

}
}