/**
 * Branch employees can enter and remove information about the shipments sent from that branch,
 * add and remove users (customers) to the system.
 *
 * When the package arrives at a branch or leaves the branch,
 * its current status is entered into the system by the branch employee.
 */
public class BranchEmployee implements User
{
    private String name;
    private Branch branchOfEmployee;

    /**
     * constructor
     * @param brName name of employee
     * @param br branch that employee works in
     */
    public BranchEmployee(String brName, Branch br)
    {
        name= brName;

        branchOfEmployee =br;
    }

    /*methods*/

    /**
     * adds Customer to employees branch
     * @param c customer object to be added
     */
    public void addCustomer(Customer c)
    {
        branchOfEmployee.addCustomer(c);

        //add the branch info to new customer
        c.setBranch(branchOfEmployee);
    }

    /**
     * removes Customer from employees branch
     * @param c customer object to be removed
     */
    public void removeCustomer(Customer c)
    {
        branchOfEmployee.removeCustomer(c);
    }

    /**
     * adds Shipment to employees branch
     * @param s shipment object to be added
     */
    public void addShipment(Shipment s)
    {
        branchOfEmployee.addShipment(s);
    }

    /**
     * removes Shipment from employees branch
     * @param s shipment object to be removed
     */
    public void removeShipment(Shipment s)
    {
        branchOfEmployee.removeShipment(s);
    }

    /**
     * Updates status of the given shipment to given text message
     * @param s shipment that will be changing status
     * @param text the new status message
     */
    @Override
    public void updateStatus(Shipment s, String text)
    {
        branchOfEmployee.updateStatus(s, text);
    }


}
