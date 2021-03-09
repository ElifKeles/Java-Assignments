/**
 * The customer entering the system with the
 * tracking number is only authorized to see the name and surname information of the sender
 * and receiver and the current status of the cargo.
 */
public class Customer
{
    /*fields*/
    private String name;
    private Branch branchOfCustomer;

    /**
     * constructor
     * @param cName name of new Customer
     */
    public Customer(String cName)
    {
        name= cName;
    }

    /*methods*/

    public String getName()
    {
        return name;
    }

    /**
     * this method is called after an employe adds the customer to a branch
     * @param br branch of customer
     */
    public void setBranch(Branch br)
    {
        branchOfCustomer= br;
    }

    /**
     * customer can see the information of shipment if he/she has
     * the tracking number of the package
     * this information includes sender and receiver names,
     * and the current status text of the package
     * @param trackingNumber tracking number of the package
     */
    public void seeInfo(int trackingNumber)
    {
        for(int i=0; i< branchOfCustomer.getShipments().length; i++)
        {
            if(branchOfCustomer.getShipments()[i].getTrackingNumber()== trackingNumber)
            {
                System.out.println("\nSender: "+ branchOfCustomer.getShipments()[i].getSender().getName()+
                                    "\nReceiver:"+  branchOfCustomer.getShipments()[i].getReceiver().getName()+
                                    "\nCurrent Status: "+ branchOfCustomer.getShipments()[i].getCurrentStatus());
            }

        }
    }
}
