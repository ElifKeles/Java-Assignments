/**
 * Binary Search Tree for Nodes of AgeData type
 * overrides find, add, remove
 */
public class AgeSearchTree extends BinarySearchTree
{
    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected AgeData deleteReturn;

    public AgeData find(AgeData target)
    {
        return find(root, target);
    }

    private AgeData find(Node<AgeData> localRoot, AgeData target)
    {
        if (localRoot == null)
            return null;
        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    public boolean add(AgeData item)
    {
        root = add(root, item);
        return addReturn;
    }

    private Node<AgeData> add(Node<AgeData> localRoot, AgeData item)
    {
        if(contains(item))
        {
            find(item).increment();
            return localRoot;
        }
        else
        {
            if (localRoot == null)
            {
                // item is not in the tree — insert it.
                addReturn = true;
                return new Node<>(item);
            }
            else if (item.compareTo(localRoot.data) == 0)
            {
                // item is equal to localRoot.data
                addReturn = false;
                return localRoot;
            }
            else if (item.compareTo(localRoot.data) < 0)
            {
                // item is less than localRoot.data
                localRoot.left = add(localRoot.left, item);
                return localRoot;
            }
            else
            {
                // item is greater than localRoot.data
                localRoot.right = add(localRoot.right, item);
                return localRoot;
            }
        }
    }

    public boolean contains(AgeData target)
    {
        return find(root, target)!=null;
    }

    public AgeData delete(AgeData target)
    {
        root = delete(root, target);
        return deleteReturn;
    }

    public boolean remove(AgeData target)
    {
        if(contains(target))
        {
            AgeData temp= find(target);
            if(temp.number > 1)
            {
                find(target).decrement();
                return true;
            }
            else if(temp.number==1)
            {
                return delete(root, target)!=null;
            }
        }
        return false;
    }

    private Node<AgeData> delete(Node<AgeData> localRoot, AgeData item)
    {
        if (localRoot == null)
        {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0)
        {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult > 0)
        {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else
        {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null)
            {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            }
            else if (localRoot.right == null)
            {
                // If there is no right child, return left child.
                return localRoot.left;
            }
            else
            {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else
                {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    private AgeData findLargestChild(Node<AgeData> parent)
    {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null)
        {
            AgeData returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
        {
            return findLargestChild(parent.right);
        }
    }

    /**
     * Starter for youngerThan
     * @param age the age to compare
     * @return number of people younger than age
     */
    public int youngerThan(int age)
    {
        AgeData temp= new AgeData(age);
        return youngerThan(root, temp, 0);
    }

    /**
     *
     * @param localRoot root
     * @param age AgeData obj
     * @param sum number of people younger than age
     * @return sum
     */
    private int youngerThan(Node<AgeData> localRoot, AgeData age, int sum)
    {
        if (localRoot == null)
            return sum;

        // Compare the age with the data field at the root.
        int compResult = localRoot.data.compareTo(age);

        if (compResult > 0 || compResult==0)
        {
            return youngerThan(localRoot.left, age, sum);
        }
        else if(compResult < 0)//root is smaller
        {
            sum= sum+ localRoot.data.number;
            sum= youngerThan(localRoot.left, age, sum);

            if (localRoot.right!=null)
                return youngerThan(localRoot.right, age, sum);
        }
        return sum;
    }

    /**
     * Starter for olderThan
     * @param age the age to compare
     * @return number of people older than age
     */
    public int olderThan(int age)
    {
        AgeData temp= new AgeData(age);
        return olderThan(root, temp, 0);
    }

    /**
     *
     * @param localRoot root
     * @param age AgeData obj
     * @param sum number of people older than age
     * @return sum
     */
    private int olderThan(Node<AgeData> localRoot, AgeData age, int sum)
    {
        if (localRoot == null)
            return sum;

        // Compare the age with the data field at the root.
        int compResult = localRoot.data.compareTo(age);

        if (compResult < 0 || compResult==0)//root is smaller
        {
            return olderThan(localRoot.right, age, sum);
        }
        else if(compResult > 0)
        {
            sum= sum+ localRoot.data.number;
            sum= olderThan(localRoot.right, age, sum);

            if (localRoot.left!=null)
                return olderThan(localRoot.left, age, sum);
        }
        return sum;
    }
}
