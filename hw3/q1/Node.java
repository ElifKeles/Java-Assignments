/**
 * This class represents Node objects
 * of the linked-list
 * Every node has an array of elements
 */
public class Node<E>
{
    //Data Fields
    //initial capacity
    private int capacity;//default capacity is 3
    //array of elements
    private E[] arrayOfElements;
    //number of elements in the array
    private int size;
    //references to other nodes
    private Node<E> next;
    private Node<E> previous;

    //Constructors
    public Node()
    {
        capacity=3;//default capacity is 3
        size=0;
        arrayOfElements=(E[]) new Object[capacity];
        next=null;
        previous=null;
    }

    /**
     * adds new element to array
     * @param newElement element to be added
     * @return true if adding is successful
     */
    public boolean add(E newElement)
    {
        arrayOfElements[size]=newElement;
        size++;
        return true;
    }

    /**
     *
     * @param index
     * @throws ArrayIndexOutOfBoundsException
     * if the index is negative or bigger than size
     * @return the indexed element in array
     */
    public E get(int index)
    {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arrayOfElements[index];
    }

    /**
     * sets the index with the new element
     * @param index
     * @param newElement to be set
     * @return the replaced element
     */
    public E set(int index, E newElement)
    {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException(index);
        E oldElement= arrayOfElements[index];
        arrayOfElements[index]=newElement;
        return oldElement;
    }

    /**
     * removes element from array
     * @throws ArrayIndexOutOfBoundsException
     * if the index is negative or bigger than size
     * @param index index of the element to be deleted
     * @return the removed element
     */
    public E remove(int index)
    {
        if(index<0 || index>=size)
            throw new ArrayIndexOutOfBoundsException(index);
        E element=arrayOfElements[index];
        for(int i=index+1; i<size; ++i)
        {
            arrayOfElements[i-1]= arrayOfElements[i];
        }
        size--;
        return element;
    }

    /**
     *
     * @return true if the array is full
     */
    public boolean isArrayFull()
    {
        return (size==capacity);
    }

    /**
     *
     * @return true if the array is empty
     */
    public boolean isArrayEmpty()
    {
        return (size==0);
    }

    /**
     * sets the nodes next node as new node
     * @param next new node
     */
    public void setNextNode(Node<E> next)
    {
        this.next = next;
    }

    /**
     * sets the nodes previous node as new node
     * @param prev new node
     */
    public void setPrevNode(Node<E> prev)
    {
        this.previous = prev;
    }

    /**
     *
     * @return next node of the node
     */
    public Node<E> getNextNode()
    {
        return this.next;
    }

    /**
     *
     * @return previous node of the node
     */
    public Node<E> getPrevNode()
    {
        return this.previous;
    }

    /**
     * returns the amount of elements in array
     * @return size of the array
     */
    public int getSize()
    {
        return this.size;
    }

    /**
     * returns the capacity of the array
     * @return capacity
     */
    public int getCapacity()
    {
        return capacity;
    }
}
