import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *SimpleTextEditor class which provides the some of the edit functionality of a text editor.
 */
public class SimpleTextEditor
{
    //Data fields
    List<Character> listOfCharacters;

    //Methods
    public SimpleTextEditor(List newList)
    {
        listOfCharacters=newList;
    }

    /**
     * reads a text file and construct the text.
     * @param fileName name of file to be read
     * @return 0 if successful, -1 if the text is empty
     */
    public int read(String fileName)
    {
        StringBuilder data= new StringBuilder("");
        try
        {
            File fileObj = new File(fileName);
            Scanner myReader = new Scanner(fileObj);
            while (myReader.hasNextLine())
            {
                data.append(myReader.nextLine() );
            }
            //loop
            //construct the text
            for(int i=0;i<data.length();i++)
            {
                listOfCharacters.add(data.charAt(i));
            }
            if(listOfCharacters.isEmpty() )
            {
                System.out.println("The text is empty");
                return -1;
            }

            System.out.println(listOfCharacters);

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * reads a text file and construct the text.
     * With iterator
     * @param fileName name of file to be read
     * @param iter iterator object reference
     * @return 0 if successful, -1 if the text is empty
     */
    public int read(String fileName, ListIterator iter)
    {StringBuilder data= new StringBuilder("");
        try
        {
            File fileObj = new File(fileName);
            Scanner myReader = new Scanner(fileObj);
            while (myReader.hasNextLine())
            {
                data.append(myReader.nextLine() );
            }
            //initialize iterator
            iter= listOfCharacters.listIterator();

            //construct the text
            for(int i=0;i<data.length();i++)
            {
                iter.add(data.charAt(i));
            }

            if(listOfCharacters.isEmpty() )
            {
                System.out.println("The text is empty");
                return -1;
            }

            System.out.println(listOfCharacters);

            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * adds one or more characters at the specified
     * position in text.
     * @param ch character or characters to add to text
     * @param index position to add the characters
     * @return 0 if adding successful, -1 if not
     */
    public int add(String ch, int index)
    {
        if(listOfCharacters.isEmpty())
        {
            return -1;
        }

        for (int i=0; i<ch.length(); ++i)
        {
            listOfCharacters.add(index, ch.charAt(i));
            index++;
        }
        System.out.println(listOfCharacters);
        return 0;
    }

    /**
     * adds one or more characters at the specified
     * position in text. With iterator.
     * @param ch character or characters to add to text
     * @param index position to add the characters
     * @param iter iterator object reference
     * @return 0 if adding successful, -1 if not
     */
    public int  add(String ch, int index, ListIterator iter)
    {
        if(listOfCharacters.isEmpty())
        {
            return -1;
        }
        //initialize iterator
        iter= listOfCharacters.listIterator(index);
        int i=0;

        while (iter.hasNext())
        {
            iter.add(ch.charAt(i));
            i++;
            if(i== ch.length())
                break;
        }

        System.out.println(listOfCharacters);
        return 0;
    }

    /**
     * Looks for a group of characters in list
     * @param ch group of characters that will be searched in the list
     * @return the start index of the first occurrence of the searched group of characters.
     * If the searched characters is not in the list, returns -1
     */
    public int find(String ch)
    {
        boolean flag=false;

        for (int i=0; i<listOfCharacters.size(); ++i)
        {
            for(int j=0; j<ch.length(); ++j)
            {
                if(listOfCharacters.get(i+j)== ch.charAt(j))
                    flag=true;
                else
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Looks for a group of characters in list. With iterator
     * @param ch group of characters that will be searched din list
     * @return the start index of the first occurrence of the searched group of characters.
     * If the searched characters is not in the list, returns -1
     * @param iter iterator object reference
     */
    public int find(String ch, ListIterator iter)
    {
        boolean flag=false;
        //initialize iterator
        iter=listOfCharacters.listIterator();

        while (iter.hasNext())
        {
            for(int i=0; i<ch.length(); ++i)
            {
                if (iter.next().equals( ch.charAt(i)) )
                    flag=true;
                else
                {
                    flag=false;
                    break;
                }
            }

            if (flag)
            {
                int loc=iter.nextIndex()-ch.length();
                return loc;
            }
        }
        return -1;//error case
    }

    /**
     * replaces all occurrences of a character with another character.
     * @param ch1 character to be changed
     * @param ch2 character to be changed with
     */
    public void replace(Character ch1, Character ch2)
    {
        for(int i=0; i <listOfCharacters.size(); ++i)
        {
            if(listOfCharacters.get(i)==ch1)
                listOfCharacters.set(i, ch2);
        }
        System.out.println(listOfCharacters);
    }

    /**
     * replaces all occurrences of a character with another character.
     * @param ch1 character to be changed
     * @param ch2 character to be changed with
     * @param iter iterator object reference
     */
    public void replace(Character ch1, Character ch2, ListIterator iter)
    {
        //initialize iterator
        iter=listOfCharacters.listIterator();

        while (iter.hasNext())
        {
            if(iter.next().equals(ch1) )
                iter.set(ch2);//  add(ch2);
        }
        System.out.println(listOfCharacters);
    }
}
