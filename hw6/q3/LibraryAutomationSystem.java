import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class to represent library aut. system
 */
public class LibraryAutomationSystem
{
    private Set<String> locationSet;
    private HashMap<String, HashSet<String>> innerMap;
    private HashMap< String, HashMap<String, HashSet<String>>> bookSet;

    private String password;

    public LibraryAutomationSystem(String pswrd)
    {
        locationSet= new HashSet<String>();
        innerMap= new HashMap<String , HashSet<String>>();
        bookSet= new HashMap<String, HashMap<String, HashSet<String>>>();
        password=pswrd;
    }

    /**
     * @return the password for the system
     */
    protected String getPassword()
    {
        return password;
    }

    /**
     * adds book to system
     * if the book already exist, does nothing
     * if the book name exists, but location is different,
     * then add book and address
     * if the book is the first book of the author add author too
     * @param obj book object to be added to the system
     */
    protected void addBook(Book obj)
    {
        if(bookSet.containsKey(obj.getNameOfAuthor()))
        {
            HashMap<String, HashSet<String>> tempInner=bookSet.get(obj.getNameOfAuthor());
            if ( tempInner.containsKey(obj.getTitleOfBook()) )
            {
                /* Only add the new address */
                /* If it already exits, set won't allow adding  */
                HashSet<String> tempSet= tempInner.get(obj.getTitleOfBook());
                tempSet.add(obj.getLocationOfBook());
            }
            else
            {
                /* Create new book and its address set */
                HashSet<String> newSet= new HashSet<String>();
                newSet.add(obj.getLocationOfBook());
                bookSet.get(obj.getNameOfAuthor()).put(obj.getTitleOfBook(), newSet);
            }
        }
        else
        {
            /* Create a new author area and its book and address areas */
            HashSet<String> newSet= new HashSet<String>();
            newSet.add(obj.getLocationOfBook());
            HashMap<String, HashSet<String>> newMap= new HashMap<String, HashSet<String>>();
            newMap.put(obj.getTitleOfBook(), newSet);
            bookSet.put(obj.getNameOfAuthor(), newMap);
        }
    }

    /**
     * deletes a book from the system
     * if the book is the only book with its title,
     * empty the whole map
     * if the book is the only book of the author,
     * then delete the author too
     * @param obj book object to be deleted
     */
    protected void deleteBook(Book obj)
    {
        /* If system has at least one copy of the book */
        int sizeTitle=1, sizeAuthor=1;
        if(bookSet.containsKey(obj.getNameOfAuthor()))
        {
            HashMap<String, HashSet<String>> tempInner=bookSet.get(obj.getNameOfAuthor());
            if ( tempInner.containsKey(obj.getTitleOfBook()) )
            {
                /* Only removing the addressed book */
                HashSet<String> tempSet= tempInner.get(obj.getTitleOfBook());
                tempSet.remove(obj.getLocationOfBook());
                /* If this is the only copy of the book */
                if(tempSet.size()==0)
                    sizeTitle=0;
            }
            if(sizeTitle==0)
            {
                tempInner.remove(obj.getTitleOfBook());
                /* If this is the only book of author */
                if(tempInner.size()==0)
                    sizeAuthor=0;
            }
        }
        if(sizeAuthor==0)
            bookSet.remove(obj.getNameOfAuthor());
    }

    /**
     * prints the book info by its author
     * if the author name exist in system
     * @param authorName
     */
    protected void displayByAuthor(String authorName)
    {
        if(bookSet.containsKey(authorName))
        {
            HashMap<String, HashSet<String>> temp = bookSet.get(authorName);
            Set<String> books= temp.keySet();
            System.out.println(books);
        }
    }

    /**
     * prints the book info by its title
     * @param authorName
     * @param bookTitle
     */
    protected void displayByTitle(String authorName, String bookTitle)
    {
        HashMap<String, HashSet<String>> temp= bookSet.get(authorName);
        if(temp.containsKey(bookTitle))
        {
            HashSet<String> tempSet= temp.get(bookTitle);
            Iterator<String> itr = tempSet.iterator();
            while (itr.hasNext())
                System.out.println(itr.next());
        }
    }

    /**
     * prints the book's whole information by its title
     * @param bookTitle
     */
    protected void displayByTitleWithAuthorName(String bookTitle)
    {
        String authorName = "";
        Set<String> authors= bookSet.keySet();
        Iterator<String> itr = authors.iterator();
        while (itr.hasNext())
        {
            authorName=itr.next();

            HashMap<String, HashSet<String>> temp = bookSet.get(authorName);
            Set<String> books = temp.keySet();
            if (books.contains(bookTitle))
            {
                System.out.println("Author : " + authorName);

                HashSet<String> tempSet= temp.get(bookTitle);
                Iterator<String> itrSet= tempSet.iterator();

                System.out.println("Location(s) of "+ bookTitle);
                while (itrSet.hasNext())
                    System.out.println(itrSet.next());
            }
        }
    }

}
