/**
 * This class represents Node objects
 * of the linked-list
 * Every node has an element of type E
 */
public class Node<E>
{
    //Data Fields
    //data in node
    private E data;

    //references to other nodes
    private Node<E> next;
    private Node<E> previous;

    //Constructors
    public Node(E newData)
    {
        data= newData;
        next=null;
        previous=null;
    }

    public E getData()
    {
        return data;
    }

    public void setData(E data)
    {
        this.data = data;
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
   }
