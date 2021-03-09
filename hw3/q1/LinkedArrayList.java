import java.util.*;

public class LinkedArrayList<E> extends AbstractList<E> implements List<E>
{
    //Data Fields
    private Node<E> head=null;
    private Node<E> tail=null;
    private int size=0;

    //Constructors
    public LinkedArrayList()
    {
        size=0;
        head=null;
        tail=null;
    }

    public LinkedArrayList(Node firstNode)
    {
        size=1;
        this.head=firstNode;
        this.tail=firstNode;
        head.setPrevNode(null);
        head.setNextNode(null);
        tail.setNextNode(null);
        tail.setPrevNode(null);
    }

    public LinkedArrayList(Node head, Node tail)
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
     * Appends the specified element to the end of this list
     * first check if the array is full or not
     * if not full add the element to the end of the list
     * if its full create a new node then add the new element to new node
     * @param element
     * @return true if adding is successful
     */
    @Override
    public boolean add(E element)
    {
        Node<E> tempNode= this.head;

        for(int i=0; i<this.size; ++i)
        {
           if(tempNode.isArrayFull() && tempNode==tail)//must create a new node
           {
               Node<E> newNode= new Node<E>();//create a new node
               newNode.setPrevNode(this.tail);
               newNode.setNextNode(null);
               this.tail.setNextNode(newNode);
               this.tail=newNode;//new node is at the end of linked-list now
               newNode.add(element);//adds the element to new node's array
               this.size++;//new node created
               return true;
           }
           else if(tempNode.isArrayFull()==false)
           {
               tempNode.add(element);//adds the element to the end of the array
               return true;
           }

           // if the array is already full and its not tail node
           tempNode = tempNode.getNextNode(); //go to the next node
        }
        return false;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * @param index index number of the node in list
     * @param element object reference to be added to array of indexed node
     */
    @Override
    public void add(int index, E element)
    {
        Node<E> tempNode= this.head;
        if(this.size* tempNode.getCapacity() < index || size==0)
            throw new IndexOutOfBoundsException("No such index number");
        int nodeIndex= index/ tempNode.getCapacity();
        int elemIndex= index% tempNode.getCapacity();

        for(int i=0; i<nodeIndex; i++)
        {
            tempNode= tempNode.getNextNode();
        }
        E oldElem=null;
        if(tempNode.get(elemIndex)!=null)
            oldElem= tempNode.get(elemIndex);
        tempNode.set(elemIndex, element);
        this.add(oldElem);//replaced element added again
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index index to replace element
     * @param element
     * @return  the element previously at the specified position
     */
    @Override
    public E set(int index, E element)
    {
        Node<E> tempNode= this.head;
        if(this.size* tempNode.getCapacity() < index || size==0)
            throw new IndexOutOfBoundsException("No such index number");

        int nodeIndex= index/ tempNode.getCapacity();
        int elemIndex= index% tempNode.getCapacity();

        for(int i=0; i<nodeIndex; i++)
        {
            tempNode= tempNode.getNextNode();
        }
        E oldElem= tempNode.get(elemIndex);
        tempNode.set(elemIndex, element);
        return oldElem;
    }


    /**
     * looks for the element in the whole list
     * @param index index of the element in linked-list
     * @return
     */
    @Override
    public E get(int index)
    {
        Node<E> tempNode= this.head;
        if(this.size* tempNode.getCapacity() < index || size==0)
            throw new IndexOutOfBoundsException("No such index number");

        int nodeIndex= index/ tempNode.getCapacity();
        int elemIndex= index% tempNode.getCapacity();

        for(int i=0; i<nodeIndex; i++)
        {
            tempNode= tempNode.getNextNode();
        }
        return tempNode.get(elemIndex);
    }


    /**
     * finds the array of the element in list, first
     * then shifts elements
     * if the size of array is zero, deletes the node itself
     * @param element object reference to be deleted
     * @return true if the elements is successfully deleted
     * false if the element is not on the list or not deleted
     */
    @Override
    public boolean remove(Object element)
    {
        Node<E> tempNode= this.head;

        for(int i=0; i<this.size; ++i)
        {
            for(int j=0; j<tempNode.getSize(); ++j)
            {
                if(element== tempNode.get(j))//if the element is in the array
                {
                    tempNode.remove(j);//shifts elements

                    if(tempNode.isArrayEmpty() && tempNode==this.tail)//last node
                    {
                        tempNode.getPrevNode().setNextNode(null);
                        this.tail= tempNode.getPrevNode();
                        this.size--;
                    }
                    else if(tempNode.isArrayEmpty() && tempNode!=this.tail)//the node must be deleted now
                    {
                        tempNode.getPrevNode().setNextNode(tempNode.getNextNode());
                        tempNode.getNextNode().setPrevNode(tempNode.getPrevNode());
                        this.size--;
                    }
                    return true;
                }
            }
            tempNode= tempNode.getNextNode();//go to next node's array
        }
        return false;
    }

    /**
     * Removes the element at the specified position in this list
     * @param index
     * @return
     */
    @Override
    public E remove(int index)
    {
        Node<E> tempNode= this.head;
        if(this.size* tempNode.getCapacity() < index || size==0)
            throw new IndexOutOfBoundsException("No such index number");

        int nodeIndex= index/ tempNode.getCapacity();
        int elemIndex= index% tempNode.getCapacity();

        for(int i=0; i<nodeIndex; i++)
        {
            tempNode= tempNode.getNextNode();
        }
        return tempNode.remove(elemIndex);//removes the element and shifts others
    }

    /**
     *
     * @return size of the linked-list
     */
    @Override
    public int size(){return size;}

    /**
     * Removes all of the elements from this list
     * by assigning the nodes null
     */
    @Override
    public void clear()
    {
        head=null;
        tail=null;
    }

    /**
     *
     * @return true is the linked-list is empty
     */
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }
}
