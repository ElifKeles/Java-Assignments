import java.util.Scanner;

/**
 * Users can browse books.
 * Book search is a public feature.
 *
 */
public class User
{
    protected LibraryAutomationSystem system;
    protected String userName;

    public User(String nameOfUser, LibraryAutomationSystem sys)
    {
        userName=nameOfUser;
        system=sys;
    }

    /**
     * searches for a book in system, by its author's name
     * after displaying all of the books of the author
     * waits for an entry, a title of any book
     * to search its location(s), if there are any, prints locations
     * @param authorName author's name of the book
     */
    public void searchByAuthor(String authorName)
    {
        System.out.println(authorName+ "'s Books: ");
        system.displayByAuthor(authorName);
        System.out.println("Enter one book name to see locations: ");

        Scanner sc= new Scanner(System.in);
        String bookName= sc.nextLine();

        if(!bookName.isEmpty())
        {
            System.out.println("Location(s) of "+ bookName);
            system.displayByTitle(authorName, bookName);
        }
    }

    /**
     * searches for a book by its title
     * if found, displays the books information
     * @param bookName
     */
    public void searchByTitle(String bookName)
    {
        System.out.println("Displaying information of :"+ bookName);
        system.displayByTitleWithAuthorName(bookName);
    }

}
