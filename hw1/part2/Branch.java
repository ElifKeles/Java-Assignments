import java.util.ArrayList; // import the ArrayList class

/**
 * Branch class of the cargo company
 * has all arraylists of employees, personnels, customers and shipments
 *
 */
public class Branch
{
    /*fields*/
    private String branchName;
    private String adminName;//every branch has an administrator
    /*arraylists*/

    private ArrayList<BranchEmployee> employees= new ArrayList<BranchEmployee>();
    private ArrayList<TransportationPersonnel> personnels= new ArrayList<TransportationPersonnel>();
    private ArrayList<Customer> customers= new ArrayList<Customer>();
    private ArrayList<Shipment> shipments= new ArrayList<Shipment>();


    /**
     * constructor
     * @param brName name of the branch
     * @param adName name of the branch administrator
     */
    public Branch(String brName, String adName)
    {
        branchName= brName;
        adminName= adName;
    }

    /*methods*/

    /**
     * This method is used only when seeInfo() method is called by a customer
     * since a customer only has tracking number of shipment
     * @return shipments arraylist
     */
    public ArrayList<Shipment> getShipments()
    {
        return shipments;
    }

    /**
     * getter method to check admin names of branches
     * @return name of administrator of branch
     */
    public String getAdminName()
    {
        return adminName;
    }

    /**
     * adds a new employee to arraylist
     * @param be employe to be added
     */
    public void addBranchEmployee(BranchEmployee be)
    {
        ArrayList<BranchEmployee> ba= new ArrayList<BranchEmployee>(employees.size()+1);
        //ba is a temporary arraylist to add old employees to new employee arraylist
        for (int i = 0; i < employees.size(); i++) {
            ba.add(i, employees.get(i));
        }
        ba.add(employees.size(), be);
        employees=ba;
    }

    /**
     * removes employee from arraylist
     * @param be employee to be removed
     */
    public void removeBranchEmployee(BranchEmployee be)
    {
        if(employees.size()==1)
        {
            employees= new ArrayList<BranchEmployee>(0);
        }

        else
        {
            int flag=0;
            for(int i=0; i<employees.size(); i++)
            {
                if(employees.get(i)== be)
                    flag=i;
            }

            ArrayList<BranchEmployee> beArray= new ArrayList<BranchEmployee>(employees.size()-1);
            for(int i=0; i<employees.size()-1; i++)
            {
                if(i< flag)
                {
                    beArray.add(i, employees.get(i));
                }
                else //i==flag or i>flag
                {
                    beArray.add(i, employees.get(i+1) );
                }
            }
            employees=beArray;
        }
    }

    /**
     * adds a new personnel to arraylist
     * @param tp personnel to be added
     */
    public void addTransportationPersonnel(TransportationPersonnel tp)
    {
        ArrayList<TransportationPersonnel> ta= new ArrayList<TransportationPersonnel>(personnels.size()+1);
        //ta is a temporary arraylist to add old personnels to new personel arraylist
        for(int i=0; i< personnels.size(); i++)
        {
            ta.add(i, personnels.get(i));
        }
        ta.add(personnels.size(), tp);
        personnels=ta;
    }

    /**
     * removes personnel from arraylist
     * @param tp personnel to be removed
     */
    public void removeTransportationPersonnel(TransportationPersonnel tp)
    {
        if(personnels.size()==1)
        {
            personnels= new ArrayList<TransportationPersonnel>(0);
        }

        else
        {
            int flag=0;
            for(int i=0; i<personnels.size(); i++)
            {
                if(personnels.get(i)== tp)
                    flag=i;
            }

            ArrayList<TransportationPersonnel> tpArray= new ArrayList<TransportationPersonnel>(personnels.size()-1);
            for(int i=0; i<personnels.size()-1; i++)
            {
                if(i< flag)
                {
                    tpArray.add(i, personnels.get(i));
                }
                else //i==flag or i>flag
                {
                    tpArray.add(i, personnels.get(i+1));
                }
            }
            personnels=tpArray;
        }
    }

    /**
     * adds a new Customer to arraylist
     * @param c Customer to be added
     */
    public void addCustomer(Customer c)
    {
        ArrayList<Customer> cArray= new ArrayList<Customer>(customers.size()+1);
        //cArray is a temporary arraylist to add old customers to new customers arraylist
        for (int i = 0; i < customers.size(); i++) {
            cArray.add(i, customers.get(i) );
        }
        cArray. add(customers.size(), c);
        customers=cArray;
    }

    /**
     * removes Customer from arraylist
     * @param c Customer to be removed
     */
    public void removeCustomer(Customer c)
    {
        if(customers.size()==1)
        {
            customers= new ArrayList<Customer>(0);
        }

        else
        {
            int flag=0;
            for(int i=0; i<customers.size(); i++)
            {
                if(customers.get(i)== c)
                    flag=i;
            }

            ArrayList<Customer> cArray= new ArrayList<Customer>(customers.size()-1);
            for(int i=0; i<customers.size()-1; i++)
            {
                if(i< flag)
                {
                    cArray.add(i, customers.get(i));
                }
                else //i==flag or i>flag
                {
                    cArray.add(i, customers.get(i+1));
                }
            }
            customers=cArray;
        }
    }

    /**
     * adds a new Shipment to arraylist
     * @param s Shipment to be added
     */
    public void addShipment(Shipment s)
    {
        ArrayList<Shipment> sArray= new ArrayList<Shipment>(shipments.size()+1);
        //sArray is a temporary arraylist to add old shipments to new shipment arraylist
        for (int i = 0; i < shipments.size(); i++) {
            sArray.add(i, shipments.get(i));
        }
        sArray.add(shipments.size(), s);
        shipments=sArray;
    }

    /**
     * removes Shipment from arraylist
     * @param s Shipment to be removed
     */
    public void removeShipment(Shipment s)
    {
        if(shipments.size()==1)
        {
            shipments= new ArrayList<Shipment>(0);
        }

        else
        {
            int flag=0;
            for(int i=0; i<shipments.size(); i++)
            {
                if(shipments.get(i)== s)
                    flag=i;
            }

            ArrayList<Shipment> sArray= new ArrayList<Shipment>(shipments.size()-1);
            for(int i=0; i<shipments.size()-1; i++)
            {
                if(i< flag)
                {
                    sArray.add(i, shipments.get(i));
                }
                else //i==flag or i>flag
                {
                    sArray.add(i, shipments.get(i+1));
                }
            }
            shipments=sArray;
        }
    }

    /**
     * Updates status of the given shipment to given text message
     * @param s shipment that will be changing status
     * @param text the new status message
     */
    public void updateStatus(Shipment s, String text)
    {
        for (int i=0; i<shipments.size(); i++)
        {
            if(shipments.get(i).getTrackingNumber()==s.getTrackingNumber())
                shipments.get(i).changeCurrentStatus(text);
        }
    }

}
