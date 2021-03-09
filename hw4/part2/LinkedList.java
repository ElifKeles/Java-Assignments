import java.util.NoSuchElementException;

/**
 * This class has two Node fields
 * as head and tail references of linked-list
 * Some of the methods parameters changed to Node E
 * instead of E to make Deque class methods work properly.
 * @param <E> to make class generic
 */
public class LinkedList<E>
{
    //Data Fields
    private Node<E> head=null;
    private Node<E> tail=null;
    private int size=0;

    //Constructors
    public LinkedList()
    {
        size=0;
        head=null;
        tail=null;
    }

    public LinkedList(Node head, Node tail)
    {
        size=2;
        this.head=head;
        this.tail=tail;
        head.setPrevNode(null);
        head.setNextNode(tail);
        tail.setNextNode(null);
        tail.setPrevNode(head);
    }

    //Methods
    /**
     * Inserts the specified node at the beginning of this list.
     * @param newNode node to be added
     */
    public void	addFirst(Node<E> newNode)
    {
        newNode.setNextNode(this.head);
        newNode.setPrevNode(null);

        if(this.size !=0)
            this.head.setPrevNode(newNode);
        else if(this.size==0)
            this.tail= newNode;

        this.head= newNode;
        this.size++;
    }

    /**
     *
     Appends the specified node to the end of this list.
     * @param newNode node to be added
     */
    public void	addLast(Node<E> newNode)
    {
        newNode.setNextNode(null);
        newNode.setPrevNode(this.tail);

        if(this.size !=0)
            this.tail.setNextNode(newNode);
        else if(this.size==0)
            this.head= newNode;

        this.tail= newNode;
        this.size++;
    }

    /**
     * Removes and returns the first node from this list.
     * @return removed node
     */
    public Node<E> removeFirst()
    {
        if(this.isEmpty())
            throw new NoSuchElementException();
        else
        {
            Node<E> newNode = this.head;
            if(this.size==1)
                this.head= null;
            else
            {
                this.head.getNextNode().setPrevNode(null);
                this.head=this.head.getNextNode();
            }
            this.size--;
            return newNode;
        }
    }

    /**
     * Removes and returns the last node from this list.
     * @return removed node
     */
    public Node<E> removeLast()
    {
        if(this.isEmpty())
            throw new NoSuchElementException();
        else
        {
            Node<E> newNode = this.tail;
            if(this.size==1)
                this.tail= null;
            else
            {
                this.tail.getPrevNode().setNextNode(null);
                this.tail= this.tail.getPrevNode();
            }
            this.size--;
            return newNode;
        }
    }

    /**
     * Returns the first element in this list.
     * @return first element in this list.
     */
    public Node<E> getFirst()
    {
        return this.head;
    }

    /**
     *
     Returns the last element in this list.
     * @return last element in this list.
     */
    public Node<E> getLast()
    {
        return this.tail;
    }

    /**
     *
     * @return size of the linked-list
     */

    public int size(){return size;}

    /**
     * Removes all of the elements from this list
     * by assigning the nodes null
     */

    public void clear()
    {
        head=null;
        tail=null;
    }

    /**
     *
     * @return true is the linked-list is empty
     */

    public boolean isEmpty()
    {
        return size == 0;
    }
}
