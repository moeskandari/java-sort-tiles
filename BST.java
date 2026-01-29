class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
class BST {

    // function to search a key in a BST
    static Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at
        // root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    //inoredr traversal to give us the sorted array 
    void inoredr(Node root)
    {
        if (root != null)
        {
            inoredr(root.left);
            System.out.println(root.key + " ");
            inoredr(root.right);
        }
    }

    //tree sort 
    Node treeSort(int[] arr, Node root, int key)
    {
        for (int i =0; i < arr.length; i++)
        {
            if (root == null) {
                return new Node(key);
            }
            
            if (key < root.key) {
                root.left = insert(root.left, key);
            } else if (key > root.key) {
                root.right = insert(root.right, key);
            }
            
            return root;
        }
    }
    
    public static void main(String[] args)
    {
        
        // Creating a hard coded tree for keeping 
        // the length of the code small. We need 
        // to make sure that BST properties are 
        // maintained if we try some other cases.
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        // Searching for keys in the BST
        if (search(root, 19) != null){
            System.out.println("found");
        }
        else{
            System.out.println("not found ");
        }

        if (search(root, 80) != null){
            System.out.println("found");
        }
        else{
            System.out.println("not found ");
        }
    }
}
