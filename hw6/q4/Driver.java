public class Driver
{
    public static void main(String[] args)
    {
        /* Comparing chaining with linked list and Binary tree */
        long t0, t_linked=0, t_bintree =0;

        t0= System.currentTimeMillis();
        HashtableChain<Integer, Character> linkedTable= new HashtableChain<>();

        linkedTable.put(1,'a');
        linkedTable.put(2,'b');
        linkedTable.put(3,'c');
        linkedTable.put(4,'d');
        linkedTable.put(5,'e');
        linkedTable.put(6,'f');
        linkedTable.put(7,'g');
        linkedTable.put(8,'h');
        linkedTable.put(9,'i');
        linkedTable.put(10,'j');
        linkedTable.put(11,'k');
        linkedTable.put(12,'l');
        linkedTable.put(13,'m');
        linkedTable.put(14,'n');
        linkedTable.put(15,'o');
        linkedTable.put(16,'p');
        linkedTable.put(17,'q');
        linkedTable.put(18,'r');
        linkedTable.put(19,'s');
        linkedTable.put(20,'t');
        linkedTable.put(21,'u');
        linkedTable.put(22,'v');
        linkedTable.put(23,'w');
        linkedTable.put(24,'x');
        linkedTable.put(25,'y');
        linkedTable.put(26,'z');
        linkedTable.put(27,'a');
        linkedTable.put(28,'b');
        linkedTable.put(29,'c');
        linkedTable.put(30,'d');
        linkedTable.put(31,'e');
        linkedTable.put(32,'f');
        linkedTable.put(33,'g');
        linkedTable.put(34,'h');
        linkedTable.put(35,'i');

        t_linked += System.currentTimeMillis()-t0;

        t0= System.currentTimeMillis();
        HashtableChainBinaryTree<Integer, Character> treeTable= new HashtableChainBinaryTree<>();

        treeTable.put(1,'a');
        treeTable.put(2,'b');
        treeTable.put(3,'c');
        treeTable.put(4,'d');
        treeTable.put(5,'e');
        treeTable.put(6,'f');
        treeTable.put(7,'g');
        treeTable.put(8,'h');
        treeTable.put(9,'i');
        treeTable.put(10,'j');
        treeTable.put(11,'k');
        treeTable.put(12,'l');
        treeTable.put(13,'m');
        treeTable.put(14,'n');
        treeTable.put(15,'o');
        treeTable.put(16,'p');
        treeTable.put(17,'q');
        treeTable.put(18,'r');
        treeTable.put(19,'s');
        treeTable.put(20,'t');
        treeTable.put(21,'u');
        treeTable.put(22,'v');
        treeTable.put(23,'w');
        treeTable.put(24,'x');
        treeTable.put(25,'y');
        treeTable.put(26,'z');
        treeTable.put(27,'a');
        treeTable.put(28,'b');
        treeTable.put(29,'c');
        treeTable.put(30,'d');
        treeTable.put(31,'e');
        treeTable.put(32,'f');
        treeTable.put(33,'g');
        treeTable.put(34,'h');
        treeTable.put(35,'i');

        t_bintree+= System.currentTimeMillis()-t0;

        System.out.println("\nlinked list took "+t_linked+" ms\nbinary tree took "+t_bintree+" ms");


        /* Comparing open addressing with one and double hashing */

        long t, t1=0, t2 =0;

        t= System.currentTimeMillis();
        HashtableOpen<Integer, Character> oneHashing= new HashtableOpen<>();
        oneHashing.put(1,'a');
        oneHashing.put(2,'b');
        oneHashing.put(3,'c');
        oneHashing.put(4,'d');
        oneHashing.put(5,'e');
        oneHashing.put(6,'f');
        oneHashing.put(7,'g');
        oneHashing.put(8,'h');
        oneHashing.put(9,'i');
        oneHashing.put(10,'j');
        oneHashing.put(11,'k');
        oneHashing.put(12,'l');
        oneHashing.put(13,'m');
        oneHashing.put(14,'n');
        oneHashing.put(15,'o');
        oneHashing.put(16,'p');
        oneHashing.put(17,'q');
        oneHashing.put(18,'r');
        oneHashing.put(19,'s');
        oneHashing.put(20,'t');
        oneHashing.put(21,'u');
        oneHashing.put(22,'v');
        oneHashing.put(23,'w');
        oneHashing.put(24,'x');
        oneHashing.put(25,'y');
        oneHashing.put(26,'z');
        oneHashing.put(27,'a');
        oneHashing.put(28,'b');
        oneHashing.put(29,'c');
        oneHashing.put(30,'d');
        oneHashing.put(31,'e');
        oneHashing.put(32,'f');
        oneHashing.put(33,'g');
        oneHashing.put(34,'h');
        oneHashing.put(35,'i');

        t1 += System.currentTimeMillis()-t;

        t= System.currentTimeMillis();

        HashtableOpenDoubleHashing<Integer, Character> doubleHashing= new HashtableOpenDoubleHashing<>();
        doubleHashing.put(1,'a');
        doubleHashing.put(2,'b');
        doubleHashing.put(3,'c');
        doubleHashing.put(4,'d');
        doubleHashing.put(5,'e');
        doubleHashing.put(6,'f');
        doubleHashing.put(7,'g');
        doubleHashing.put(8,'h');
        doubleHashing.put(9,'i');
        doubleHashing.put(10,'j');
        doubleHashing.put(11,'k');
        doubleHashing.put(12,'l');
        doubleHashing.put(13,'m');
        doubleHashing.put(14,'n');
        doubleHashing.put(15,'o');
        doubleHashing.put(16,'p');
        doubleHashing.put(17,'q');
        doubleHashing.put(18,'r');
        doubleHashing.put(19,'s');
        doubleHashing.put(20,'t');
        doubleHashing.put(21,'u');
        doubleHashing.put(22,'v');
        doubleHashing.put(23,'w');
        doubleHashing.put(24,'x');
        doubleHashing.put(25,'y');
        doubleHashing.put(26,'z');
        doubleHashing.put(27,'a');
        doubleHashing.put(28,'b');
        doubleHashing.put(29,'c');
        doubleHashing.put(30,'d');
        doubleHashing.put(31,'e');
        doubleHashing.put(32,'f');
        doubleHashing.put(33,'g');
        doubleHashing.put(34,'h');
        doubleHashing.put(35,'i');

        t2+= System.currentTimeMillis()-t;
        System.out.println("\none hashing took + "+t1+" ms\ndouble hashing took "+t2+" ms");

    }
}
