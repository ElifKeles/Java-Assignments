/**
 * Administrators manage the system by
 * adding and removing branches, branch employees and transportation personnel
 */
public class Administrator
{
    /*fields*/
    private String name;
    private Branch[] branches= new Branch[0];

    /**
     * constructor
     * @param adName name of the administrator
     */
    public Administrator(String adName)
    {
        name= adName;
    }

    /*methods*/

    /**
     * adds new branch to admin.'s branches array
     * @param br is the branch object reference
     */
    public void addBranch(Branch br)
    {
        Branch[] brArray= new Branch[branches.length+1];
        //brArray is a temporary array to add old branches to new branch array
        for (int i = 0; i < branches.length; i++) {
            brArray[i] = branches[i];
        }
        brArray[branches.length]=br;
        branches=brArray;
    }

    /**
     * removes a branch from array
     * @param br branch to be  deleted
     */
    public void removeBranch(Branch br)
    {
        if(branches.length==1)
        {
            branches= new Branch[0];
        }

        else
        {
            int flag=0;
            for(int i=0; i<branches.length; i++)
            {
                if(branches[i]== br)
                    flag=i;
            }

            Branch[] brArray = new Branch[branches.length-1];
            for(int i=0; i<branches.length-1; i++)
            {
                if(i< flag)
                {
                    brArray[i]= branches[i];
                }
                else //i==flag or i>flag
                {
                    brArray[i]=branches[i+1];
                }
            }
            branches=brArray;
        }
    }

    /**
     * adds an employee to a given branch
     * only if the admins name is same with branch admin name
     * @param be is branch employee object reference
     * @param br is the branch that employee will be added to
     */
    public void addBranchEmployee(BranchEmployee be, Branch br)
    {
      if(br.getAdminName()== name)//if the administrator has the branch he/she can add employees
      {
          br.addBranchEmployee(be);
      }
    }

    /**
     * removes an employee from a given branch
     * only if the admins name is same with branch admin name
     * @param be is branch employee object reference
     * @param br is the branch that employee will be removed from
     */
    public void removeBranchEmployee(BranchEmployee be, Branch br)
    {
        if(br.getAdminName()== name)//if the administrator has the branch he/she can add employees
        {
            br.removeBranchEmployee(be);
        }
    }

    /**
     * adds an transportation personnel to a given branch
     * only if the admins name is same with branch admin name
     * @param tp is branch personnel object reference
     * @param br is the branch that personnel will be added to
     */
    public void addTransportationPersonnel(TransportationPersonnel tp, Branch br)
    {
        if(br.getAdminName()== name)//if the administrator has the branch he/she can add personnels
        {
            br.addTransportationPersonnel(tp);
        }
    }

    /**
     * removes an transportation personnel from a given branch
     * only if the admins name is same with branch admin name
     * @param tp is branch personnel object reference
     * @param br is the branch that personnel will be removed from
     */
    public void removeTransportationPersonnel(TransportationPersonnel tp, Branch br)
    {
        if(br.getAdminName()== name)//if the administrator has the branch he/she can add employees
        {
            br.removeTransportationPersonnel(tp);
        }
    }

}
