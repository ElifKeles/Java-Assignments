/**
 * Represents the books in library aut. system
 * Stores a books, author name, the title, the location (such as "c3s5.1534" )
 */
public class Book
{
    private String nameOfAuthor;
    private String titleOfBook;
    private String locationOfBook;
    private String statusInfo;

    public Book(String author, String title, String loc)
    {
        nameOfAuthor=author;
        titleOfBook=title;
        locationOfBook=loc;
        statusInfo="Available";
    }

    /**
     * Changes the status of the book
     * @param newStatus
     */
    protected void updateInfo(String newStatus)
    {
        statusInfo=newStatus;
    }

    public String getNameOfAuthor()
    {
        return nameOfAuthor;
    }

    public String getTitleOfBook()
    {
        return titleOfBook;
    }

    public String getLocationOfBook()
    {
        return locationOfBook;
    }

    public String getStatusInfo()
    {
        return statusInfo;
    }
}
