/*
* Elif Keles - 161044033
* CSE222 - HW6
*
* */

/**
 * Driver class to test Library Automation System,
 * Book and User classes and methods
 */
public class Driver
{
    public static void main(String[] args)
    {
        /* Library aut. sys with its password */
        LibraryAutomationSystem system= new LibraryAutomationSystem("youShallPass");
        /* Books to add */
        Book b1= new Book("Dan Brown", "Angels And Demons", "c3s5.1534" );
        Book b2= new Book("Franz Kafka", "Metamorphosis", "c3s6.1535" );
        Book b3= new Book("Dan Brown", "Inferno", "c4s12.1534" );
        Book b4= new Book("Orhan Pamuk", "The White Castle", "c4s45.1434" );
        Book b5= new Book("Franz Kafka", "The Judgement", "c4s6.1539" );
        Book b6= new Book("Dan Brown", "The Da Vinci Code", "c6s5.7534" );
        Book b7= new Book("Harper Lee", "To Kill A Mockingbird", "c3s5.3536" );
        Book b8= new Book("George Orwell", "Animal Farm", "c9s5.1134" );
        Book b9= new Book("George Orwell", "Nineteen Eighty-Four", "c10s5.1534" );
        Book b10= new Book("Orhan Pamuk", "My Name Is Red", "c10s5.3034" );
        Book b11= new Book("Jane Austen", "Pride And Prejudice", "c13s5.1538" );
        Book b12= new Book("Dostoevsky", "Crime And Punishment", "c3s25.1534" );
        Book b13= new Book("Jane Austen", "Persuasion", "c2s5.1578" );
        Book b14= new Book("Virginia Woolf", "Mrs Dalloway", "c4s6.1734" );
        Book b15= new Book("Virginia Woolf", "The Waves", "c9s5.1030" );
        Book b16= new Book("Orhan Pamuk", "My Name Is Red", "c10s5.3035" );

        /* Administrators */
        Administrator a1= new Administrator("Admin1", system );
        Administrator a2= new Administrator("Admin2", system);

        /* User */
        User u1= new User("Elif Keles", system);

        /* Adding books */
        a1.addBook("youShallPass", b1);
        a1.addBook("youShallPass", b2);
        a1.addBook("youShallPass", b3);
        a1.addBook("youShallPass", b4);
        a1.addBook("youShallPass", b5);
        a1.addBook("youShallPass", b6);
        a1.addBook("youShallPass", b7);
        a1.addBook("youShallPass", b8);
        a1.addBook("youShallPass", b9);
        a1.addBook("youShallPass", b10);
        a1.addBook("youShallPass", b11);
        a1.addBook("youShallPass", b12);
        a2.addBook("youShallPass", b13);
        a2.addBook("youShallPass", b14);
        a2.addBook("youShallPass", b16);

        /* Adding with wrong password */
        a2.addBook("youShallNotPass", b15);

        /* Adding the same book */
        a2.addBook("youShallPass", b14);

        /* Removing books */
        a1.deleteBook("youShallPass", b1);
        a2.deleteBook("youShallPass", b3);

        /* Updating information of some books */

        a1.updateInfo("youShallPass", b5, "Not available");
        a2.updateInfo("youShallPass", b6, "Not available");

        /* Book search by title */
        u1.searchByTitle("Mrs Dalloway");

        /* Book search by author */
        u1.searchByAuthor("Orhan Pamuk");
    }
}
