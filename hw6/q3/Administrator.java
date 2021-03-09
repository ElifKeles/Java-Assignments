/**
 * Administrators can update information.
 * To update the information, administrators have to enter the system with
 * a password (assumed a single general password is sufficient).
 */
public class Administrator extends User
{
     public Administrator(String nameOfAdmin, LibraryAutomationSystem sys)
     {
         super(nameOfAdmin, sys);
     }

    /**
     * adds a book from the system if the administrator knows the correct password
     * @param password
     * @param bookObj book to be added
     */
     public void addBook(String password, Book bookObj)
     {
         if(password==this.system.getPassword())
         {
            system.addBook(bookObj);
         }
     }

    /**
     * deletes a book from the system if the administrator knows the correct password
     * @param password
     * @param bookObj book to be deleted from system
     */
    public void deleteBook(String password, Book bookObj)
    {
        if(password==this.system.getPassword())
        {
            system.deleteBook(bookObj);
        }
    }

    /**
     * changes the status information of a book in the system if the administrator knows the correct password
     * @param password
     * @param bookObj
     * @param status
     */
    public void updateInfo(String password, Book bookObj, String status)
    {
        if(password==this.system.getPassword())
        {
            bookObj.updateInfo(status);
        }
    }
}
