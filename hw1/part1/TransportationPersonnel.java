/**
 * When the package is delivered,
 * the transportation personnel makes the update.
 */
public class TransportationPersonnel
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
     * changes shipment object status to "Delivered to receiver"
     * @param s reference to shipment that is delivered
     */
    public void updateStatus(Shipment s)
    {
        branchOfPersonnel.updateStatus(s, "Delivered to receiver.");
    }

}
