/*
 * Elif Keles - 161044033
 * CSE222- HW#3
 * Q1
 * */

/**
 * Driver class for question1
 * LinkedArrayList class testing
 */
public class Driver
{
    public static void main(String[] args)
    {
        Node<Integer> n1= new Node<>();
        Node<Integer> n2= new Node<>();
        Node<Integer> n3= new Node<>();

        LinkedArrayList<Integer> lAl;
        lAl=new LinkedArrayList<Integer>(n1, n2);

        LinkedArrayList<Integer> lAl2= new LinkedArrayList<Integer>(n3);

        LinkedArrayList<Integer> lAl3= new LinkedArrayList<Integer>();

        lAl2.add(1);
        lAl2.add(2);
        lAl2.add(3);
        lAl2.add(4);
        lAl2.add(5);
        lAl2.add(6);
        lAl2.add(7);

        lAl2.remove((Integer)7);//casting to avoid assigning as index

        lAl2.set(4, 10);

        lAl2.remove(4);

        lAl2.remove(0);
        System.out.println("element at 4: "+ lAl2.get(4));


        /*Testing*/
        /*Node<Character> cnode= new Node<>();
        LinkedArrayList<Character> clist= new LinkedArrayList<>(cnode);

        clist.add('E');
        clist.add('L');
        clist.add('w');
        clist.add('F');

        clist.set(2, 'İ');

        System.out.println(lAl.get(4));*/


        return ;
    }
}

