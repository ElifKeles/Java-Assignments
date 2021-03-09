/**
 * Branch class of the cargo company
 * has all arrays of employees, personnels, customers and shipments
 *
 */
public class Branch
{
    /*fields*/
    private String branchName;
    private String adminName;//every branch has an administrator
    /*arrays*/
    private BranchEmployee[] employees= new BranchEmployee[0];
    private TransportationPersonnel[] personnels= new TransportationPersonnel[0];
    private Customer[] customers= new Customer[0];
    private Shipment[] shipments= new Shipment[0];

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
     * @return shipments array
     */
    public Shipment[] getShipments()
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
     * adds a new employee to array
     * @param be employe to be added
     */
    public void addBranchEmployee(BranchEmployee be)
    {
        BranchEmployee[] ba= new BranchEmployee[employees.length+1];
        //ba is a temporary array to add old employees to new employee array
        for (int i = 0; i < employees.length; i++) {
            ba[i] = employees[i];
        }
        ba[employees.length]=be;
        employees=ba;
    }

    /**
     * removes employee from array
     * @param be employee to be removed
     */
    public void removeBranchEmployee(BranchEmployee be)
    {
        if(employees.length==1)
        {
            employees= new BranchEmployee[0];
        }

        else
        {
            int flag=0;
            for(int i=0; i<employees.length; i++)
            {
                if(employees[i]== be)
                    flag=i;
            }

            BranchEmployee[] beArray = new BranchEmployee[employees.length-1];
            for(int i=0; i<employees.length-1; i++)
            {
                if(i< flag)
                {
                    beArray[i]= employees[i];
                }
                else //i==flag or i>flag
                {
                    beArray[i]=employees[i+1];
                }
            }
            employees=beArray;
        }
    }

    /**
     * adds a new personnel to array
     * @param tp personnel to be added
     */
    public void addTransportationPersonnel(TransportationPersonnel tp)
    {
        TransportationPersonnel[] ta= new TransportationPersonnel[personnels.length+1];
        //ta is a temporary array to add old personnels to new personel array
        for(int i=0; i< personnels.length; i++)
        {
            ta[i]= personnels[i];
        }
        ta[personnels.length]=tp;
        personnels=ta;
    }

    /**
     * removes personnel from array
     * @param tp personnel to be removed
     */
    public void removeTransportationPersonnel(TransportationPersonnel tp)
    {
        if(personnels.length==1)
        {
            personnels= new TransportationPersonnel[0];
        }

        else
        {
            int flag=0;
            for(int i=0; i<personnels.length; i++)
            {
                if(personnels[i]== tp)
                    flag=i;
            }

            TransportationPersonnel[] tpArray = new TransportationPersonnel[personnels.length-1];
            for(int i=0; i<personnels.length-1; i++)
            {
                if(i< flag)
                {
                    tpArray[i]= personnels[i];
                }
                else //i==flag or i>flag
                {
                    tpArray[i]=personnels[i+1];
                }
            }
            personnels=tpArray;
        }
    }

    /**
     * adds a new Customer to array
     * @param c Customer to be added
     */
    public void addCustomer(Customer c)
    {
        Customer[] cArray= new Customer[customers.length+1];
        //cArray is a temporary array to add old customers to new customers array
        for (int i = 0; i < customers.length; i++) {
            cArray[i] = customers[i];
        }
        cArray[customers.length]=c;
        customers=cArray;
    }

    /**
     * removes Customer from array
     * @param c Customer to be removed
     */
    public void removeCustomer(Customer c)
    {
        if(customers.length==1)
        {
            customers= new Customer[0];
        }

        else
        {
            int flag=0;
            for(int i=0; i<customers.length; i++)
            {
                if(customers[i]== c)
                    flag=i;
            }

            Customer[] cArray = new Customer[customers.length-1];
            for(int i=0; i<customers.length-1; i++)
            {
                if(i< flag)
                {
                    cArray[i]= customers[i];
                }
                else //i==flag or i>flag
                {
                    cArray[i]=customers[i+1];
                }
            }
            customers=cArray;
        }
    }

    /**
     * adds a new Shipment to array
     * @param s Shipment to be added
     */
    public void addShipment(Shipment s)
    {
        Shipment[] sArray= new Shipment[shipments.length+1];
        //sArray is a temporary array to add old shipments to new shipment array
        for (int i = 0; i < shipments.length; i++) {
            sArray[i] = shipments[i];
        }
        sArray[shipments.length]=s;
        shipments=sArray;
    }

    /**
     * removes Shipment from array
     * @param s Shipment to be removed
     */
    public void removeShipment(Shipment s)
    {
        if(shipments.length==1)
        {
            shipments= new Shipment[0];
        }

        else
        {
            int flag=0;
            for(int i=0; i<shipments.length; i++)
            {
                if(shipments[i]== s)
                    flag=i;
            }

            Shipment[] sArray = new Shipment[shipments.length-1];
            for(int i=0; i<shipments.length-1; i++)
            {
                if(i< flag)
                {
                    sArray[i]= shipments[i];
                }
                else //i==flag or i>flag
                {
                    sArray[i]=shipments[i+1];
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
        for (int i=0; i<shipments.length; i++)
        {
            if(shipments[i].getTrackingNumber()==s.getTrackingNumber())
                shipments[i].changeCurrentStatus(text);
        }
    }

}
