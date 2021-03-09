import java.io.Serializable;
import java.util.Scanner;
import java.util.function.BiConsumer;

/** Class for a binary tree that stores type E objects. */
public class BinaryTree<E>implements Serializable {

    //Nested Class Node

    /**
     * Class to encapsulate a tree node.
     */
    protected static class Node<E> implements Serializable {
        // Data Fields
        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;
        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        /* toString method deleted */
    }

    /*Data Fields*/
    /**
     * The root of the binary tree
     */
    protected Node<E> root;//Reference to the root of the tree
    /*Constructors*/

    /**
     * Constructs an empty binary tree
     */
    public BinaryTree()
    {
        root = null;
    }

    /**
     * Constructs a binary tree with the given node as the root
     *
     * @param root
     */
    protected BinaryTree(Node<E> root)
    {
        this.root = root;
    }

    /**
     * Constructs a binary tree with the given data at the root and the two given subtrees
     *
     * @param data
     * @param leftTree
     * @param rightTree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
    {
        root = new Node<>(data);
        if (leftTree != null)
        {
            root.left = leftTree.root;
        }
        else
        {
            root.left = null;
        }
        if (rightTree != null)
        {
            root.right = rightTree.root;
        }
        else
        {
            root.right = null;
        }
    }
    /*Methods*/

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root
     * or the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    /**
     * @return Returns the right subtree
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }

    /**
     * @return Returns the data in the root
     */
    public E getData()
    {
        return root.data;
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf()
    {
        return (root.left == null && root.right == null);
    }

    /**
     * Converts a subtree to a string.
     * Performs a preorder traversal.
     *
     * @param node  The local root
     * @param depth The depth
     * @param sb    The StringBuilder to save the output
     */
    private void toString(Node<E> node, int depth, StringBuilder sb)
    {
        for (int i = 1; i < depth; i++)
        {
            sb.append(" ");
        }
        if (node == null)
        {
            sb.append("null\n");
        }
        else
        {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }

    /**
     * The binaryTree implementation of the book includes a toString method which creates a string of the tree structure in preorder.
     * You will add a toString2 method which will create a string of the tree structure in post order.
     * This method will use the postOrderTaverse method.
     * @param node
     * @param depth
     * @param sb
     */
    private void toString2(Node<E> node, int depth, StringBuilder sb)
    {
        for (int i = 1; i < depth; i++)
        {
            sb.append(" ");
        }
        if (node == null) {
            sb.append("null\n");
        }
        else
        {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }

    /**
     * @return Returns a String representation of the tree
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }

    /**
     * Starter method for pre-order traversal
     *
     * @param consumer an object that instantiates
     *                 the BiConsumer interface. Its method implements
     *                 abstract method apply.
     */
    public void preOrderTraverse(BiConsumer<E, Integer> consumer) {
        preOrderTraverse(root, 1, consumer);
    }

    /**
     * Performs a recursive preorder traversal of the tree,
     * applying the action specified in the consumer object.
     *
     * @param consumer object whose accept method specifies
     *                 the action to be performed on each node
     */
    private void preOrderTraverse(Node<E> node, int depth, BiConsumer<E, Integer> consumer) {
        if (node == null)
        {
            consumer.accept(null, depth);
        }
        else
        {
            consumer.accept(node.data, depth);
            preOrderTraverse(node.left, depth + 1, consumer);
            preOrderTraverse(node.right, depth + 1, consumer);
        }
    }

    /**
     * The binaryTree postOrderTraverse version of the preOrderTraverse implementation from book
     * method to traverse the tree post order.
     * @param node
     * @param depth
     * @param consumer
     */
    private void postOrderTraverse(Node<E> node, int depth, BiConsumer<E, Integer> consumer) {
        if (node == null)
        {
            consumer.accept(null, depth);
        }
        else
        {
            postOrderTraverse(node.left, depth + 1, consumer);
            postOrderTraverse(node.right, depth + 1, consumer);
            consumer.accept(node.data, depth);
        }
    }

    /**
     * Method to read a binary tree.
     * pre: The input consists of a pre-order traversal
     * of the binary tree. The line "null" indicates a null tree.
     *
     * ADDED hasNext control to prevent NullPointerExceptions
     * @param scan the Scanner attached to the input file.
     * @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan)
    {
        // Read a line and trim leading and trailing spaces.
        if(scan.hasNext())
        {
            String data = scan.nextLine().trim();

            if (data.equals("null"))
            {
                return null;
            }
            else
            {
                BinaryTree<String> leftTree = readBinaryTree(scan);
                BinaryTree<String> rightTree = readBinaryTree(scan);
                return new BinaryTree<>(data, leftTree, rightTree);
            }
        }
        return null;
    }
}

