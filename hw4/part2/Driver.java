/*
 * Elif Keles - 161044033
 * CSE222- HW#4
 * Q2
 * */

/**
 * Driver class for question2
 * Q2Deque class testing
 */
public class Driver
{
    public static void main(String[] args)
    {
        Node<Integer> a= new Node<>(1);
        Node<Integer> b= new Node<>(2);
        Node<Integer> c= new Node<>(3);
        Node<Integer> d= new Node<>(4);

        LinkedList<Integer> myLinkedList= new LinkedList<Integer>();
        LinkedList<Integer> deletedList= new LinkedList<Integer>(c, d);

        deletedList.addLast(b);//add elements to deleted list
                               //in order to add some elements to actual linked list
        deletedList.addFirst(a);

        Q2Deque<Integer> myDeque=  new Q2Deque<Integer>(myLinkedList, deletedList);//Deque object

        //myDeque.addFirst(5); //add and offer almost do the same thing
        myDeque.offerFirst(5);
        //myDeque.addFirst(6);
        myDeque.offerFirst(6);

        //myDeque.addLast(7);
        myDeque.offerLast(7);

        //list: 6-5-7
        //test0
        System.out.println(myDeque.getFirst() );//6
        System.out.println(myDeque.size());//3
        System.out.println(myDeque.removeFirst() );//6
        System.out.println(myDeque.size());//2
        System.out.println(myDeque.peekFirst() );//5
        System.out.println(myDeque.size());//2
        System.out.println(myDeque.peekLast() );//7
        System.out.println(myDeque.removeLast());//7
        System.out.println(myDeque.peekLast());//5
        System.out.println(myDeque.size());//1

        /*
        //test1
        System.out.println(myDeque.pollFirst());//6
        System.out.println(myDeque.size());//2
        System.out.println(myDeque.pollFirst());//5
        System.out.println(myDeque.size());//1
        System.out.println(myDeque.pollLast());//7
        System.out.println(myDeque.size());//0
        */

        //Q2Deque<String> dequestring= new Q2Deque<>();


        return ;
    }
}

