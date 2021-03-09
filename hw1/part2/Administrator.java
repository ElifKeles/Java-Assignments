import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Administrators manage the system by
 * adding and removing branches, branch employees and transportation personnel
 */
public class Administrator
{
    /*fields*/
    private String name;
    private ArrayList<Branch> branches= new ArrayList<Branch>(0);

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
        if(br.getAdminName()==this.name)
        {
            ArrayList<Branch> brArray= new ArrayList<Branch>(branches.size()+1);
            //brArray is a temporary arraylist to add old branches to new branch arraylist
            for (int i = 0; i < branches.size(); i++) {
                brArray.add(i, branches.get(i));
            }
            brArray.add(branches.size(), br);
            branches=brArray;
        }
        else//error message
        {
            throw new NoSuchElementException("No such administrator!");
        }
    }

    /**
     * removes a branch from arraylist
     * @param br branch to be  deleted
     */
    public void removeBranch(Branch br)
    {
        if(branches.size()==1)
        {
            branches= new ArrayList<Branch>(0);
        }

        else
        {
            int flag=0;
            for(int i=0; i<branches.size(); i++)
            {
                if(branches.get(i)== br)
                    flag=i;
            }

            ArrayList<Branch>brArray = new ArrayList<Branch>(branches.size()-1);
            for(int i=0; i<branches.size()-1; i++)
            {
                if(i< flag)
                {
                    brArray.add(i, branches.get(i));
                }
                else //i==flag or i>flag
                {
                    brArray.add(i, branches.get(i+1));
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
        else//error message
            throw new NoSuchElementException("Administrator does not have the branch");
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
        else
            throw new NoSuchElementException("Administrator does not have the branch");
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
        else
            throw new NoSuchElementException("Administrator does not have the branch");
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
        else
            throw new NoSuchElementException("Administrator does not have the branch");
    }
}
