/**
 * When the package is delivered,
 * the transportation personnel makes the update.
 */
public class TransportationPersonnel implements User
{
    /*fields*/
    private String name;
    private Branch branchOfPersonnel;

    /**
     * constructor
     * @param tName name of personnel
     * @param br  branch that personnel works in
     */
    public TransportationPersonnel(String tName, Branch br)
    {
        name= tName;
        branchOfPersonnel= br;
    }

    /*methods*/

    /**
     * Updates status of the given shipment to given text message
     * @param s shipment that will be changing status
     * @param text the new status message
     */
    @Override
    public void updateStatus(Shipment s, String text)
    {
        branchOfPersonnel.updateStatus(s, "Delivered to receiver.");//text is "Delivered to receiver."
    }
}
