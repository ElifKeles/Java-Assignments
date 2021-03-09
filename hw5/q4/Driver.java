/* Elif Keleş - 161044033 */
/* CSE222 - HW5 Q4 */

/**
 * Driver class for testing methods of AgeData class and maxheap
 * the age which the highest number of people is at, will be at the root.
 */
public class Driver
{
    public static void main(String[] args)
    {
        //Create an empty heap
        MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
        //Add nodes
        heap.add(new AgeData(10));
        heap.add(new AgeData(5));
        heap.add(new AgeData(70));
        heap.add(new AgeData(10));
        heap.add(new AgeData(50));
        heap.add(new AgeData(5));
        heap.add(new AgeData(5));
        heap.add(new AgeData(5));

        //Create a string representing the heap and print it
        String heapStr= heap.toString();
        System.out.println(heapStr);

        System.out.println(heap.youngerThan(10));

        System.out.println(heap.find(new AgeData(10)).toString());
        //It will print:
        //10 - 2

    }
}
