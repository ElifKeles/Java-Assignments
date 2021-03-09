/** Hash table implementation using chaining. */
public class HashtableChainBinaryTree<K extends Comparable<K>, V> implements KWHashMap<K, V>
{
    /** The table */
    private BinaryTree<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 11;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    // Constructor
    public HashtableChainBinaryTree()
    {
        table = new BinaryTree[CAPACITY];
    }

    /** Contains key value pairs for a hash table. */
    private static class Entry<K, V>
    {
        /** The key */
        private final K key;
        /** The value */
        private V value;
        /** Creates a new key value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey()
        {
            return key;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue()
        {
            return value;
        }
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val)
        {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }


    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     * calls binary trees get method
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.
        V value= null;
        value= get(table[index].root, (K)key);
        if(value != null)
            return value;
        // assert: key is not in the table.
        return null;
    }

    /**
     * get the element with the key value
     * @param localRoot
     * @param key
     * @return
     */
    private V get(BinaryTree.Node<Entry<K, V>> localRoot, K key)
    {
        if (localRoot == null)
            return null;
        // Compare the key with the data's key field at the root.
        // If the search is successful, replace the old value
        int compResult= key.compareTo(localRoot.data.key);
        if (compResult == 0)
        {
            return localRoot.data.getValue();
        }
        else if (compResult < 0)
            return get(localRoot.left, key);
        else
            return get(localRoot.right, key);
    }

    /** Returns true if empty */
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /** Method put for class HashtableChain.
      This key value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value)
    {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
        {
            // Create a new binary tree at table[index].
            table[index] = new BinaryTree<>();
        }

        // Search the list at table[index] to find the key.
        V oldVal= null;
        oldVal= findKey(table[index].root, key, value);

        if(oldVal != null)
            return oldVal;

        //if the old value return value is null, continue

        // assert: key is not in the table, add new item.
        table[index].root= addElement(table[index].root, new HashtableChainBinaryTree.Entry<>(key, value) );
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }

    /**
     * removes the specific element with key
     * calls binary trees deleteElement method
     * @param key
     * @return
     */
    public V remove(Object key)
    {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // Key not in table
        V oldVal=null;
        oldVal= deleteElement(table[index].root, (K)key);
        if(oldVal!= null)
            return oldVal;
        return null; // Key not in table
    }

    /**
     * deletes element with the key
     * @param localRoot root of the tree
     * @param key the key to search in tree
     * @return
     */
    private V deleteElement(BinaryTree.Node<Entry<K, V>> localRoot, K key )
    {
        if (localRoot == null) {
            // item is not in the tree.
            return null;
        }
        // Search for item to delete.
        int compResult = key.compareTo(localRoot.data.key);
        if (compResult < 0)
        {
            // item is smaller than localRoot.data.
            localRoot.left.data.setValue(deleteElement(localRoot.left, key) );
            return localRoot.left.data.getValue();
        }
        else if (compResult > 0)
        {
            // item is larger than localRoot.data.
            localRoot.right.data.setValue(deleteElement(localRoot.right, key) );
            return localRoot.data.getValue();
        }
        else
        {
            // item is at local root.
            if (localRoot.left == null)
            {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right.data.getValue();
            }
            else if (localRoot.right == null)
            {
                // If there is no right child, return left child.
                return localRoot.left.data.getValue();
            }
            else
            {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null)
                {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot.data.getValue();
                }
            }
        }
        return null;
    }

    /** Returns the number of entries in the map */
    public int size()
    {
        return numKeys;
    }

    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post: the size of table is doubled and is an
     odd integer. Each non-deleted entry from the original
     table is reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    public void rehash() {
        // Save a reference to oldTable
        BinaryTree <Entry< K, V >> [] oldTable = table;
        // Double capacity of this table
        table = new BinaryTree[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null)
            {
                // Insert entry in expanded table
                putTree(oldTable[i].root);
            }
        }
    }

    /**
     * For rehash, copies the binary tree at a specific index
     * @param localRoot the root of the tree
     * @return null for simplicity
     */
    public BinaryTree<Entry<K, V>> putTree(BinaryTree.Node<Entry<K, V>> localRoot)
    {
        if(localRoot == null)
        {
            return null;
        }
        else
        {
            put(localRoot.data.getKey(), localRoot.data.getValue());
            if(localRoot.right != null)
                putTree(localRoot.right);
            else if(localRoot.left != null)
                putTree(localRoot.left);
            return null;
        }
    }

    private V findKey(BinaryTree.Node<Entry<K, V>> localRoot, K key, V value)
    {
        if (localRoot == null)
            return null;
        // Compare the key with the data's key field at the root.
        // If the search is successful, replace the old value
        int compResult= key.compareTo(localRoot.data.key);
        if (compResult == 0)
        {
            // Replace value for this key.
            V oldVal = localRoot.data.getValue();
            localRoot.data.setValue(value);
            return oldVal;
        }
        else if (compResult < 0)
            return findKey(localRoot.left, key, value);
        else
            return findKey(localRoot.right, key, value);
    }

    /**
     * adds element to the binary tree
     *
     * @param localRoot
     * @param element the new entry to be added
     * @return a new tree if the root is empty
     */
    private BinaryTree.Node<Entry<K, V>> addElement(BinaryTree.Node<Entry<K, V>> localRoot, HashtableChainBinaryTree.Entry<K, V> element)
    {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            return new BinaryTree.Node<>(element);
        }
        else if (element.key.compareTo(localRoot.data.key) == 0)
        {
            // item is equal to localRoot.data
            return localRoot;
        }
        else if (element.key.compareTo(localRoot.data.key) < 0)
        {
            // item is less than localRoot.data
            localRoot.left = addElement(localRoot.left, element);
            return localRoot;
        }
        else
        {
            // item is greater than localRoot.data
            localRoot.right = addElement(localRoot.right, element);
            return localRoot;
        }
    }
}
