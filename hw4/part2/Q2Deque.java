import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Q2Deque<E> extends AbstractCollection<E> implements Deque<E>
{
    private LinkedList<E> listOfElements;
    private LinkedList<E> deletedNodes;

    public Q2Deque()
    {
        listOfElements= new LinkedList<E>();
        deletedNodes= new LinkedList<E>();
    }

    public Q2Deque(LinkedList<E> list, LinkedList<E> deleted)
    {
        listOfElements= list;
        deletedNodes= deleted;
    }

    /* Rule For Adding/Offering A New Node To The List:
     *
     * use a removed node, if any available
     * when a new node is needed
     * instead of creating a new node.
     */

    /**
     * Inserts the specified element at the front of this deque
     * unless it would violate capacity restrictions.
     * @param element  the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offerFirst(E element)
    {
        if(deletedNodes.isEmpty())
            return false;
        if(element==null)
            throw new NullPointerException();
        else
        {
            Node<E> newNode = deletedNodes.removeLast();
            newNode.setData(element);
            listOfElements.addFirst(newNode);
            return true;
        }
    }

    /**
     * Inserts the specified element at the end of this deque
     * unless it would violate capacity restrictions.
     * @param element  the element to add
     * @return true if the element was added to this deque, else false
     */
    @Override
    public boolean offerLast(E element)
    {
        if(deletedNodes.isEmpty())
            return false;
        if(element==null)
            throw new NullPointerException();
        else
        {
            Node<E> newNode = deletedNodes.removeLast();
            newNode.setData(element);
            listOfElements.addLast(newNode);
            return true;
        }
    }

    /**
     * Inserts the specified element at the front of this deque
     * if it is possible to do so immediately without violating capacity restrictions.
     * @param element  the element to add
     * @throws NullPointerException  if the specified element is null
     */
    @Override
    public void addFirst(E element)
    {
        if( !(deletedNodes.isEmpty()))
        {
            if(element==null)
                throw new NullPointerException();
            else
            {
                Node<E> newNode = deletedNodes.removeLast();
                newNode.setData(element);
                listOfElements.addFirst(newNode);
             }
        }
        else
            System.out.println("THERE'S NO NODE LEFT TO ADD");
    }

    /**
     * Inserts the specified element at the end of this deque
     * if it is possible to do so immediately without violating capacity restrictions.
     * @param element  the element to add
     * @throws NullPointerException  if the specified element is null
     */
    @Override
    public void addLast(E element)
    {
        if(!(deletedNodes.isEmpty()))
        {
            if(element==null)
                throw new NullPointerException();
            else
            {
                Node<E> newNode = deletedNodes.removeLast();
                newNode.setData(element);
                listOfElements.addLast(newNode);
            }
        }
        else
            System.out.println("THERE'S NO NODE LEFT TO ADD1");
    }

    /**
     * Retrieves and removes the first element of this deque, or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E pollFirst()
    {
        if(listOfElements.isEmpty())
            return null;
        else
        {
            Node<E> newNode=listOfElements.removeFirst();
            deletedNodes.addLast(newNode);
            return newNode.getData();
        }
    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E pollLast()
    {
        if(listOfElements.isEmpty())
            return null;
        else
        {
            Node<E> newNode= listOfElements.removeLast();
            deletedNodes.addLast(newNode);
            return newNode.getData();
        }
    }

    /**
     * Retrieves and removes the first element of this deque.
     * This method differs from pollFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E removeFirst()
    {
        if(listOfElements.isEmpty())
            throw new NoSuchElementException();

        else
        {
            Node<E> newNode=listOfElements.removeFirst();
            deletedNodes.addLast(newNode);
            return newNode.getData();
        }
    }

    /**
     * Retrieves and removes the last element of this deque.
     * This method differs from pollLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public E removeLast()
    {
        if(listOfElements.isEmpty())
            throw new NoSuchElementException();
        else
        {
            Node<E> newNode= listOfElements.removeLast();
            deletedNodes.addLast(newNode);
            return newNode.getData();
        }
    }

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns null if this deque is empty.
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E peekFirst()
    {
        if(listOfElements.isEmpty())
            return null;
        else
            return listOfElements.getFirst().getData();
    }

    /**
     * Retrieves, but does not remove, the last element of this deque,
     * or returns null if this deque is empty.
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E peekLast()
    {
        if(listOfElements.isEmpty())
            return null;
        else
            return listOfElements.getLast().getData();
    }

    /**
     * Retrieves, but does not remove, the first element of this deque.
     * This method differs from peekFirst only in that it throws an exception if this deque is empty.
     * @return the head of this deque
     * @throws NoSuchElementException  if this deque is empty
     */
    @Override
    public E getFirst()
    {
        if(listOfElements.isEmpty())
           throw new NoSuchElementException();
        else
            return listOfElements.getFirst().getData();
    }

    /**
     * Retrieves, but does not remove, the last element of this deque.
     * This method differs from peekLast only in that it throws an exception if this deque is empty.
     * @return the tail of this deque
     * @throws NoSuchElementException  if this deque is empty
     */
    @Override
    public E getLast()
    {
        if(listOfElements.isEmpty())
            throw new NoSuchElementException();
        else
            return listOfElements.getLast().getData();
    }

    /**
     * Returns the number of elements in this deque.
     * @return the number of elements in this deque
     */
    @Override
    public int size()
    {
        return listOfElements.size();
    }

    //not implemented
    @Override
    public boolean removeFirstOccurrence(Object o)
    {
        return false;
    }

    //not implemented
    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    //not implemented
    @Override
    public Iterator<E> iterator()
    {
        return null;
    }

    //not implemented
    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    //not implemented
    @Override
    public boolean offer(E e) {
        return false;
    }

    //not implemented
    @Override
    public E remove() {
        return null;
    }

    //not implemented
    @Override
    public E poll() {
        return null;
    }

    //not implemented
    @Override
    public E element() {
        return null;
    }

    //not implemented
    @Override
    public E peek() {
        return null;
    }

    //not implemented
    @Override
    public void push(E e) {    }

    //not implemented
    @Override
    public E pop() {
        return null;
    }
}
