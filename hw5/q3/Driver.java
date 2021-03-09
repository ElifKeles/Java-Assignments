/* Elif Keleş - 161044033 */
/* CSE222 - HW5 Q3 */

/**
 * Driver class for testing methods of Search trees and AgeData class
 */
public class Driver
{
    public static void main(String[] args)
    {
        //Testing
        /*BinarySearchTree<Integer> bst= new BinarySearchTree();
        bst.add(10);
        bst.add(20);
        bst.add(5);
        bst.add(15);
        bst.add(10);

        String s= bst.toString();
        System.out.println(s);
        //System.out.println(bst.find(2));
        //System.out.println(bst.contains(1));
        //bst.toString();
        System.out.println(bst.find(10).toString());*/


        //Create an empty age tree
        AgeSearchTree ageTree= new AgeSearchTree();
        //Add nodes for some ages
        ageTree.add(new AgeData(10));
        ageTree.add(new AgeData(20));
        ageTree.add(new AgeData(5));
        ageTree.add(new AgeData(15));
        ageTree.add(new AgeData(10));
        //ageTree.remove(new AgeData(10));

        //Create a string representing the tree and print it
        String treeStr = ageTree.toString();
        System.out.println(treeStr);
        //This will print:
        //10 - 2
        //5 - 1
        //null
        //null
        //20 - 1
        //15 - 1
        //null
        //null
        //null

        System.out.println(ageTree.youngerThan(20));

        System.out.println(ageTree.olderThan(5));

        //Find the number of people at any age
        System.out.println(ageTree.find(new AgeData(10)).toString());
        //It will print:
        //10 - 2

    }
}
