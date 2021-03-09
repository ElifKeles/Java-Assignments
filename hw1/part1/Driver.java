/*  Elif KELES - 161044033  */
/*  CSE222 HW#1    */

/**
 *  Driver class for cargo company system automation program
 *
 */
public class Driver
{
    public static void main(String[] args)
    {
        Administrator ad= new Administrator("Ben Franklin");
        //To add employees to branch make sure the admins name is correct!

        Branch br=new Branch("Dunder Mifflin", "Ben Franklin");

        BranchEmployee be= new BranchEmployee("Michael Scott",br);
        TransportationPersonnel tp=new TransportationPersonnel("Pam Beesly", br);

        ad.addBranch(br);

        ad.addBranchEmployee(be, br);
        ad.addTransportationPersonnel(tp, br);
        ad.removeTransportationPersonnel(tp, br);

        ad.removeBranchEmployee(be, br);

        ad.removeBranch(br);

        ad.addBranch(br);

        Branch br2=new Branch("New factory", "Ben Franklin");
        ad.addBranch(br2);

        ad.removeBranch(br);

        Customer c1= new Customer("Elif Keles");
        Customer c2= new Customer("Henry Ford");
        be.addCustomer(c1);
        be.addCustomer(c2);

        Shipment s= new Shipment(c1, c2, 111);
        be.addShipment(s);

        c1.seeInfo(111);//customer only has the tracking number of shipment
        be.updateStatus(s, "On the road.");

        c2.seeInfo(111);
        tp.updateStatus(s);//transportation personnel changes the info if the package is delivered

        c1.seeInfo(111);
        be.removeCustomer(c1);

        be.removeShipment(s);

    }

}
