/*
* Elif Keles - 161044033
* CSE222- HW#3
* Q2
* */
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 • Tests each method of the SimpleTextEditor class.
 • Measures the running time of your implementation for various text sizes.
 • Creates a readable log file of the test.
 */
public class Driver
{
    public static void main(String[] args)
    {
        //For log file
        Logger logger = Logger.getLogger("LogLinkedList");
        FileHandler fh;
        try
        {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("LogFileLists.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        //input file path
        String filename= "input.txt";//can be changed

        ////////////////////linked-list///////////////////////////////////
        List<Character> linkedListOfChar = new LinkedList<Character>();
        List<Character> linkedListOfCharIter = new LinkedList<Character>();

        //Linked-list without iterator
        SimpleTextEditor steL = new SimpleTextEditor(linkedListOfChar);
        long startTimeLinkedlist = System.nanoTime();//start timer
        steL.read(filename);
        steL.add("", 2);
        int a=steL.find("EGEUS");
        System.out.println("Found at:"+ a);
        steL.replace('e', 'z');
        long endTimeLinkedlist = System.nanoTime();//stop timer

        long durationLinkedlist = (endTimeLinkedlist - startTimeLinkedlist);  //divide by 1 000 000 to get milliseconds.
        logger.info("Time of LinkedList without iterator: "+ durationLinkedlist+ "\n");
        System.out.println("Time: "+ durationLinkedlist+"\n");

        //////////////////Linked-list with iterator////////////////////////////

        SimpleTextEditor steLWithIterator= new SimpleTextEditor(linkedListOfCharIter);
        //iterator
        ListIterator<Character> linkedListIter= linkedListOfCharIter.listIterator();

        long startTimeLWithIterator = System.nanoTime();
        steLWithIterator.read(filename, linkedListIter);
        steLWithIterator.add("keles",2, linkedListIter);
        int b= steLWithIterator.find("keles", linkedListIter);
        System.out.println("Found at:"+ b);
        steLWithIterator.replace('e', 'z', linkedListIter);
        long endTimeLWithIterator  = System.nanoTime();

        long durationLWithIterator  = (endTimeLWithIterator  - startTimeLWithIterator );
        logger.info("Time of LinkedList with iterator: "+ durationLinkedlist+ "\n");
        System.out.println("Time: "+ durationLWithIterator+"\n");


        //////////////////arraylist////////////////////////////////////
        List<Character> arrayListOfChar = new ArrayList<Character>();
        List<Character> arrayListOfCharIter = new ArrayList<Character>();

        //arraylist without iterator
        SimpleTextEditor steA = new SimpleTextEditor(arrayListOfChar);

        long startTimeArrayList = System.nanoTime();
        steA.read(filename);
        steA.add("keles", 2);
        int c= steA.find("keles");
        System.out.println("Found at:"+ c);
        steA.replace('e', 'z');
        long endTimeArrayList  = System.nanoTime();

        long durationArrayList  = (endTimeArrayList  - startTimeArrayList );
        logger.info("Time of ArrayList without iterator: "+ durationLinkedlist+ "\n");
        System.out.println("Time: "+ durationArrayList+"\n");


        /////////////arraylist with iterator//////////////////////////////////

        SimpleTextEditor steAWithIterator = new SimpleTextEditor(arrayListOfCharIter);
        //iterator
        ListIterator<Character> arrayListIter= arrayListOfCharIter.listIterator();

        long startTimeAWithIterator = System.nanoTime();
        steAWithIterator.read(filename, arrayListIter);
        steAWithIterator.add("keles", 2, arrayListIter);
        int d= steAWithIterator.find("keles", arrayListIter);
        System.out.println("Found at:"+ d);
        steAWithIterator.replace('e', 'z', arrayListIter);
        long endTimeAWithIterator  = System.nanoTime();

        long durationAWithIterator  = (endTimeAWithIterator  - startTimeAWithIterator );
        logger.info("Time of ArrayList with iterator: "+ durationLinkedlist+ "\n");
        System.out.println("Time: "+ durationAWithIterator+"\n");


        return;
    }
}
