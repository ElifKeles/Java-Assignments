/**
 * Interface User is the ancestor of
 * the users of this system, which are employees and personnels
 */
public interface User
{
    //static public String name;
    //static public Branch branchOfUser;

    /**
     * Updates status of the given shipment to given text message
     * @param s shipment that will be changing status
     * @param text the new status message
     */
    public void updateStatus(Shipment s, String text);

}
