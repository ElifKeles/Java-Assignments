import java.util.Comparator;

public class MaxHeap<E> implements Comparator<AgeData>
{
    /*Data fields*/
    private KWArrayList<AgeData> arrayList;

    public MaxHeap()
    {
        arrayList= new KWArrayList<>();
    }

    /*Methods*/
    /**
     * @param pos of child
     * @return the parent's position of the child
     */
    private int parent(int pos)
    {
        return pos / 2;
    }

    /**
     * @param pos position of root
     * @return the left child's index position
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
    /**
     * @param pos position of root
     * @return the right child's index position
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    /**
     * checks if an element is in the list or not
     * @param obj object
     * @return returns the index number if object can be found in array
     * -1 otherwise
     */
    private int contains(AgeData obj)
    {
        for (int i=0; i<arrayList.getSize(); ++i)
        {
            if(obj.age== arrayList.get(i).age)
                return i;
        }
        return -1;
    }

    /**
     * starter for find
     * @param target element to look for
     * @return null if the arrayList is empty
     */
    public AgeData find(AgeData target)
    {
        if (arrayList == null)
            return null;
        else
            return find(arrayList.get(0), target);
    }

    /**
     *
     * @param root root of maxheap
     * @param target element to search for
     * @return null if the arrayList is empty, or the AgaDta object if its found
     */
    private AgeData find(AgeData root, AgeData target)
    {
        // Compare the target with the data field at the root.
        for(int i=0; i<arrayList.getSize(); ++i)
        {
            if(target.age==arrayList.get(i).age)
                return arrayList.get(i);
        }
        //element not found
        return null;
    }

    /**
     * swap two elements
     * @param pos1 index of object1
     * @param pos2 index of object2
     */
    private void swap(int pos1, int pos2)
    {
        AgeData temp;
        temp = arrayList.get(pos1);
        arrayList.set(pos1, arrayList.get(pos2));
        arrayList.set(pos2, temp );
    }

    /**
     * starter for add
     * @param item data to be added
     * @return true if the first element is added
     * else, return the return value of add
     */
    public boolean add(AgeData item)
    {
        if(arrayList.getSize()==0)
        {
            arrayList.add(0, item);
            return true;
        }
        else
            return add(arrayList.get(0), item)!=null;
    }

    /**
     * add method to insert elements to arrayList
     * after adding, traverse
     * @param localRoot root
     * @param item to be added
     * @return root if the element is added
     */
    private AgeData add(AgeData localRoot, AgeData item)
    {
        int pos= contains(item);
        if(pos !=-1)
        {
            arrayList.get(pos).increment();
            if(pos==0)
            {
                // item is equal to localRoot.data
                return localRoot;
            }
        }
        else
            arrayList.add(arrayList.getSize(), item);

        // Traverse up and fix violated property
        int current = contains(item);
        while (arrayList.get(current).number > arrayList.get( parent(current)).number )
        {
            swap(current, parent(current));
            current= parent(current);
        }
        return localRoot;
    }

    /**
     * starter for remove
     * @param target element to be deleted
     * @return return of remove
     */
    public boolean remove(AgeData target)
    {
        return remove(arrayList.get(0), target)!=null;
    }

    /**
     * remove, after traverse arrayList
     * @param item to be deleted
     * @param localRoot root
     * @return null if the arrayList is empty, else return root
     */
    private AgeData remove(AgeData localRoot, AgeData item)
    {
        if (localRoot == null)
        {
            // item is not in the tree.
            return localRoot;
        }

        int pos= contains(item);
        if(pos != -1)
        {
            if(arrayList.get(pos).number > 1)
                find(item).decrement();

            else if(arrayList.get(pos).number==1)
            {
                swap(pos, arrayList.getSize());
                arrayList.remove(arrayList.getSize());
            }

            // Traverse up and fix violated property
            int current = arrayList.getSize();
            while (arrayList.get(current).number > arrayList.get( parent(current)).number )
            {
                swap(current, parent(current));
                current= parent(current);
            }
        }
        return localRoot;
    }


    /**
     *
     * @param age the age to compare
     * @return number of people younger than age
     */
    public int youngerThan(int age)
    {
        int sum=0;
        for(int i=0; i<arrayList.getSize(); ++i)
        {
            if(arrayList.get(i).age < age)
                sum = sum+ arrayList.get(i).number;
        }
        return sum;
    }

    /**
     *
     * @param age the age to compare
     * @return number of people older than age
     */
    public int olderThan(int age)
    {
        int sum=0;
        for(int i=0; i<arrayList.getSize(); ++i)
        {
            if(arrayList.get(i).age > age)
                sum = sum+ arrayList.get(i).number;
        }
        return sum;
    }

    /**
     * Compares two AgeData objects due to their number field
     * @param o1 object1
     * @param o2 object2
     * @return bigger number value of o1 and o2
     */
    @Override
    public int compare(AgeData o1, AgeData o2)
    {
        if(o1.number < o2.number)
            return o2.number;
        else
            return o1.number;
    }

    /**
     * toString method to print arrayList
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arrayList.getSize(); i++)
        {
            sb.append(arrayList.get(i).toString() );
            sb.append("\n");
        }

        return sb.toString();
    }
}
