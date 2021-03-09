/*
 * Elif Keles - 161044033
 * CSE222- HW#4
 * Q3
 * */

public class Q3
{
    //1)

    /**
     * My helper method for reverseString
     * to find space index
     * @param str string
     * @return space index number, if none return -1
     */
    int spaceAt(String str)
    {
        for(int i=0; i<str.length(); ++i)
        {
            if(str.charAt(i)==' ')
                return i;
        }
        return -1;
    }

    /**
     * reverses a string's words order
     * @param str string to be reversed
     */

    void reverseString(String str)
    {
        if((str==null))
            return;

        int i=spaceAt(str);

        if(i != -1)
        {
            reverseString(str.substring(i+1, str.length()));
            System.out.print(str.substring(0, i+1));
        }
        else
        {
            System.out.print(str + ' ');
            return;
        }
    }

    //2)

    /**
     * A word is considered elfish if it contains
     * the letters: e, l, and f in it, in any order.
     * @param str the word
     * @param numberOfe number of occurrence the letter e
     * @param numberOfl number of occurrence the letter l
     * @param numberOff number of occurrence the letter f
     * @return true if the word is elfish, if not return false
     */
    boolean isElfish(String str, int numberOfe, int numberOfl, int numberOff)
    {
        if(str== null )
            return false;

        if(str.charAt(0)=='e')
            numberOfe++;
        else if( str.charAt(0)=='l' )
            numberOfl++;
        else if(str.charAt(0)=='f')
            numberOff++;

        if(numberOfe>0 && numberOfl>0 && numberOff>0)
            return true;

        else
        {
            if(str.length()==1)
                return false;

            return isElfish(str.substring(1), numberOfe, numberOfl, numberOff);
        }
    }

    //3)

    /**
     * helper method to find the index of minimum element
     * goes to the end of array and checks
     * @param arr the array of ints
     * @param startIndex starting index
     * @return index number of min
     */
    int minAt(int[] arr, int startIndex)
    {
        if(arr.length==startIndex+1)
            return startIndex;

        int min= minAt(arr, startIndex+1);

        if(arr[min] < arr[startIndex])
            return min;
        else
            return startIndex;
    }

    /**
     * swaps two integers
     * @param arr the array of ints
     * @param a int1
     * @param b int2 to be swapped
     */
    void mySwap(int[] arr, int a, int b)
    {
        int temp=arr[a];
        arr[a]= arr[b];
        arr[b]=temp;
    }

    /**
     * sort the array of ints with selection sort
     * @param arr the array
     * @param startIndex starting index to sort
     */
    void sortWithSelection(int[] arr, int startIndex)
    {
        if(arr.length==startIndex+1)
            return;

        int min= minAt(arr, startIndex);
        if(min != startIndex)
            mySwap(arr, startIndex, min);//swap their locations

        sortWithSelection(arr, startIndex+1);
    }

    /**
     * main tests methods above
     * @param args
     */
    public static void main(String[] args)
    {
        //1)
        String str = "this function writes the sentence in reverse";
        Q3 obj = new Q3();
        obj.reverseString(str);

        //2)
        System.out.println();
        /*String str2="unfriendly";//whiteleaf, tasteful, unfriendly, waffles
        System.out.println(obj.isElfish(str2, 0, 0, 0));

        System.out.println(obj.isElfish("elif", 0, 0, 0));
        System.out.println(obj.isElfish("abcd", 0, 0, 0));
        */
        System.out.println(obj.isElfish("elf", 0, 0, 0));


        //3)
        System.out.println();
        int[] arrayOfInt={23, 3, 45, 6, 12, 78, 60, 1};
        obj.sortWithSelection(arrayOfInt, 0);
        for(int j=0; j<arrayOfInt.length; ++j)
            System.out.print(""+ arrayOfInt[j]+ ' ');


        //4)
        System.out.println();

        //5)
        System.out.println();

        //6)
        System.out.println();
    }

}
