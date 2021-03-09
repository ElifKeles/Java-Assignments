/**
 * Represents the type of Nodes of AgeSearchTree
 */
public class AgeData implements Comparable<AgeData>
{
    /*Data Fields*/
    int age;
    int number;

    /*Constructors*/
    public AgeData(int age )
    {
        this.age= age;
        this.number= 1;
    }

    /**
     * Increments the age number by one
     * @return the increased value of number
     */
    public int increment ()
    {
        number++;
        return number;
    }


    /**
     * Decrements the age number by one
     * @return the decreased value of number
     */
    public int decrement ()
    {
        number--;
        return number;
    }

    /**
     * toString method for printing AgeData values
     * @return the age and number of people at that age
     */
    @Override
    public String toString()
    {
        return age+" - "+ number;
    }

    /**
     * CompareTo
     * method of AgeData class will be used and the comparison
     * will be done considering the age only.
     * @param obj
     * @return
     */
    @Override
    public int compareTo(AgeData obj)
    {
        return Integer.compare(age, obj.age);
    }

}
