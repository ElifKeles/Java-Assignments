/*  Elif KELES - 161044033  */
/*  CSE222 HW#1  PART2  */

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
        Branch br2=new Branch("New factory", "Ben Franklin");

        BranchEmployee be= new BranchEmployee("Michael Scott",br);
        TransportationPersonnel tp=new TransportationPersonnel("Pam Beesly", br);

        User u1= be;
        User u2= tp;

        ad.addBranch(br);
        ad.addBranch(br2);


        ad.addBranchEmployee(be, br);
        ad.addTransportationPersonnel(tp, br);
        ad.removeTransportationPersonnel(tp, br);

        ad.removeBranchEmployee(be, br);
        ad.removeBranch(br);
        ad.addBranch(br);

        ad.addBranch(br2);
        ad.removeBranch(br);

        Customer c1= new Customer("Elif Keles");
        Customer c2= new Customer("Henry Ford");
        be.addCustomer(c1);
        be.addCustomer(c2);

        Shipment s= new Shipment(c1, c2, 111);
        be.addShipment(s);

        c1.seeInfo(111);//customer only has the tracking number of shipment
        //be.updateStatus(s, "On the road.");
        u1.updateStatus(s, "On the road.");

        c2.seeInfo(111);
        u2.updateStatus(s, "Delivered to receiver.");
        //tp.updateStatus(s, "Delivered to receiver.");//transportation personnel changes the info if the package is delivered

        c1.seeInfo(111);
        be.removeCustomer(c1);

        be.removeShipment(s);
    }
}
