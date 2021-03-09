/**
 *The information of the sender and receiver
 * are recorded for each shipment/ package.
 */
public class Shipment
{
    /*fields*/
    private Customer sender;// can be a customer
    private Customer receiver;
    private String currentStatus;
    private int trackingNumber;

    /*methods*/

    /**
     * the initial current status of a package is "At branch"
     * @param senderC sender of package
     * @param receiverC name of receiver of the package
     * @param number the tracking number of the package
     */
    public Shipment(Customer senderC, Customer receiverC, int number)
    {
        sender= senderC;
        receiver= receiverC;
        currentStatus= "At branch";
        trackingNumber= number;
    }

    public int getTrackingNumber()
    {
        return trackingNumber;
    }

    /**
     * changes the currant status text to new text message
     * @param newStatus the new current status message
     */
    public void changeCurrentStatus(String newStatus)
    {
        currentStatus= newStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public Customer getSender() {
        return sender;
    }

    public Customer getReceiver() {
        return receiver;
    }
}
