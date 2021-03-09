/*
* Elif Keleş - 161044033
* CSE222- HW5
*
*/


/**
 * Driver class for testing FileSystemTree class and its methods
 */
public class Driver
{
    public static void main(String[] args)
    {
       //Testing
       /*FileSystemTree fst= new FileSystemTree("Root");
       fst.addDir("Root/Dir1");

       fst.addDir("Root/Dir1/Dir2");
       fst.addFile("Root/Dir1/File1");
       fst.addFile("Root/Dir1/Dir2/File2");
       fst.addFile("Root/Dir1/File3");


       fst.printFileSystem();
       //fst.remove("Root/Dir1/Dir2/File2");
       //fst.remove("Root/Dir1/Dir2");

       fst.search("Root");

       //error case on same name
       //fst.addDir("Root/Dir1/Dir1");
       //fst.addFile("Root/Dir1/Dir1");
       //fst.addDir("Root/Root");
       //fst.addFile("Root/Dir1/File1");

        //fst.addDir("Root/Dir1/Dir1");

       //error file
       //fst.addFile("Root/Dir1/File1/d");
       //fst.addDir("Root/Dir1/File1/d");

       //fst.printFileSystem();*/


       FileSystemTree fst2= new FileSystemTree("root");
       fst2.addDir("root/first_directory");
       fst2.addFile("root/first_directory/new_file.txt");
       fst2.addDir("root/second_directory");
       fst2.addDir("root/second_directory/new_directory");
       fst2.addFile("root/second_directory/new_directory/new_file.doc");
       //fst2.remove("root/second_directory/new_directory/new_file.doc");

       //fst2.addFile("root/second_directory/new_file.doc");
       //fst2.search("new");

       //fst2.remove("root/");//cannot be done

       fst2.printFileSystem();

    }
}
