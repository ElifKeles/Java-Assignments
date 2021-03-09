/**
 *  General tree is a tree in which each node can have either zero or many child nodes.
 *  It can not be empty. In general tree, there is no limitation on the degree of a node.
 *  The topmost node of a general tree is called the root node.
 *  There are many subtrees in a general tree
 *
 * File system hierarchy in a general tree structure
 */

import java.util.LinkedList;
import java.util.Scanner;

/**ASSUMED: i.e directory names begin with root-name and / without space characters
 */
public class FileSystemTree
{
    /*Data fields*/
    FileNode root;

    /*Constructors*/

    /**
     * A constructor to create a file system with a root directory.
     *
     * @param rootName Name of the root directory
     */
    public FileSystemTree(String rootName)
    {
        root= new FileNode(rootName, true);
    }

    /*Methods*/

    /**
     * Helper method to find out a string has a slash(/) character in it or not
     * @param str string
     * @return true if it has a slash
     */
    boolean hasSlash(String str)
    {
        boolean result= false;
        for(int i= 0; i< str.length(); ++i)
        {
            if(str.charAt(i)=='/')
            {
                result=true;
                return result;
            }
        }
        return result;
    }

    /**
     * adds directories to the file system.
     * creates a linked list to take root and its children
     * level by level
     *
     * @param pathOfNewDir The path of the new directory
     */
    public void addDir(String pathOfNewDir )
    {
        if(root==null)
            return;
        if(hasSlash(pathOfNewDir))
        {
            //split the string as per /
            String[] parts = pathOfNewDir.split("/");

            if(parts[0].equals(root.NodeName) )
            {
                // list for elements in tree
                LinkedList<FileNode > qFileNode = new LinkedList<FileNode>();

                qFileNode.addFirst(root);
                while (!qFileNode.isEmpty())
                {
                    while ( qFileNode.size() > 0)
                    {
                        for(int i=0; i<parts.length; ++i)
                        {
                            if(!qFileNode.getFirst().NodeName.equals(parts[i] ) && i==parts.length-2)
                            {
                                //remove first element
                                qFileNode.removeFirst();
                            }

                            if( qFileNode.getFirst().NodeName.equals(parts[i] ) && i==parts.length-2)
                            {
                                //dir. can only be added under another directory
                                if(qFileNode.getFirst().isDir)
                                {
                                    //Directories cannot have the same name
                                    if(parts[i+1].equals(qFileNode.getFirst().NodeName))
                                    {
                                        System.out.println("Directories cannot have the same name!");
                                    }
                                    else
                                    {
                                        if(!qFileNode.getFirst().children.isEmpty())
                                        {
                                            for (int j = 0; j < qFileNode.getFirst().children.size(); j++)
                                            {
                                                //if any of the children has the same name as new dir
                                                if (parts[i + 1].equals(qFileNode.getFirst().children.get(j).NodeName))
                                                {
                                                    System.out.println("Directories cannot have the same names!");
                                                    return;
                                                }
                                            }
                                        }
                                        // add file
                                        FileNode newDir= new FileNode(parts[i+1], true);
                                        qFileNode.getFirst().children.add(newDir);
                                    }
                                }
                                else
                                    //files cannot hold directories under them
                                    System.out.println("Files cannot have directories!");
                                return;
                            }

                            else if( qFileNode.getFirst().NodeName.equals(parts[i] ) )
                            {
                                //add children to the queue
                                for (int j = 0; j <  qFileNode.getFirst().children.size(); j++)
                                    qFileNode.addLast( qFileNode.getFirst().children.get(j) );

                                //remove parent from queue
                                qFileNode.removeFirst();
                            }
                        }
                    }
                }
            }
            else
                System.out.println("Adding can only apply to root.");
        }
    }

    /**
     * adds files to the file system.
     * creates a linked list to take root and its children
     * level by level
     *
     * @param pathOfNewFile The path of the new file
     */
    public void addFile (String pathOfNewFile)
    {
        if(root==null)
            return;
        if(hasSlash(pathOfNewFile))
        {
            //split the string as per /
            String[] parts = pathOfNewFile.split("/");

            if(parts[0].equals(root.NodeName) )
            {
                // list for elements in tree - behaves like a queue
                LinkedList<FileNode > qFileNode = new LinkedList<FileNode>();
                int num=0;

                qFileNode.addFirst(root);
                while (!qFileNode.isEmpty())
                {
                    num = qFileNode.size();
                    while (num > 0)
                    {
                        for(int i=0; i<parts.length; ++i)
                        {
                            if(!qFileNode.getFirst().NodeName.equals(parts[i] ) && i==parts.length-2)
                            {
                                //remove first element
                                qFileNode.removeFirst();
                            }

                            if( qFileNode.getFirst().NodeName.equals(parts[i] ) && i==parts.length-2)
                            {
                                //files can only be added under a directory
                                if(qFileNode.getFirst().isDir)
                                {
                                    //Directory and file cannot have the same name
                                    if(parts[i+1].equals(qFileNode.getFirst().NodeName))
                                    {
                                        System.out.println("File cannot have the same name as directory!");
                                    }
                                    else
                                    {
                                        if(!qFileNode.getFirst().children.isEmpty())
                                        {
                                            for (int j = 0; j < qFileNode.getFirst().children.size(); j++)
                                            {
                                                //if any of the children has the same name as new file
                                                if (parts[i + 1].equals(qFileNode.getFirst().children.get(j).NodeName))
                                                {
                                                    System.out.println("Files cannot have the same names!");
                                                    return;
                                                }
                                            }
                                        }
                                        //finally add file
                                        FileNode newDir= new FileNode(parts[i+1], false);
                                        qFileNode.getFirst().children.add(newDir);

                                    }
                                }
                                else
                                    //files cannot hold files under them
                                    System.out.println("Files cannot have files!");
                                return;
                            }

                            else if( qFileNode.getFirst().NodeName.equals(parts[i] ) )
                            {
                                //add children to the queue
                                for (int j = 0; j <  qFileNode.getFirst().children.size(); j++)
                                    qFileNode.addLast( qFileNode.getFirst().children.get(j) );

                                //remove parent from queue
                                qFileNode.removeFirst();
                                num--;
                            }
                        }
                    }
                }
            }
            else
                System.out.println("Adding can only apply to root.");
        }
    }

    /**
     * Starter method for removing a path
     * @param pathToRemove The path of the directory (or the file)
     */
    public void remove(String pathToRemove)
    {
        if(root==null)
            return;
        if(hasSlash(pathToRemove))
        {
            //split the string as per /
            String[] parts = pathToRemove.split("/");

            //cannot delete root
            if(parts[0].equals(root.NodeName) && parts.length > 1)
            {
                //index 0 is root
               remove(root.children, parts, 1);
            }
        }
    }


    /**
     * removes a directory (or a file) from the file system.
     *  The method will warn the user if the path cannot be found.
     *  If the directory includes some other directories (or files),
     *  method will list the contents and ask the user whether to remove or not.
     *  If user chooses y the path will be deleted,
     *  if n is chosen, path stays the same and user gets informed
     *
     * @param children children of root
     * @param partsOfPath separated with /
     * @param index number of index to keep track of pathname to be removed
     * @return 1 if the removal is successful, if not returns -1
     * return value is used only for checking inside the method
     */
    private int remove(LinkedList<FileNode> children, String[] partsOfPath, int index)
    {
        int result=0;
        for(int i=0; i<children.size(); ++i )
        {
            if(children.get(i).NodeName.equals(partsOfPath[index]) && index==partsOfPath.length-1)
            {
                //if a directory is to be removed
                //and if it has children
                //print its children
                //and ask again
                if(children.get(i).isDir && !children.get(i).children.isEmpty())
                {
                    Scanner sc= new Scanner(System.in);

                    System.out.println("Warning! This directory has: ");
                    for (int j = 0; j < children.get(i).children.size(); j++)
                    {
                        //print its children
                        System.out.println(children.get(i).children.get(j).NodeName) ;
                    }
                    System.out.println("Remove or not? (y/n)");
                    char answer= sc.next().charAt(0);
                    if (answer=='y')
                        children.remove(i);

                    else //answer is n or something else
                        System.out.println("Path is not deleted.");
                }
                else //if its a file or an empty dir
                {
                    children.remove(i);
                }
                return 1;
            }
            else if(children.get(i).NodeName.equals(partsOfPath[index]) && index < partsOfPath.length-1)
            {
                result = remove(children.get(i).children, partsOfPath, index+1 );
            }

            if(i==children.size()-1 && index==partsOfPath.length-1 && result==0)
            {
                System.out.println("Path cannot be found!");
                return -1;
            }
        }
        return -1;
    }


    /**
     * Starter method fo searching a keyword in tree
     * @param characters  The search characters
     */
    public void search(String characters)
    {
        if(root!=null)
            search(root, characters);
    }

    /**
     * searches the entire file system for a directory or a file
     * including the given search characters in its name.
     * @param root
     * @param characters keyword to look in tree
     * @return pathname that contains characters
     */
    private String search(FileNode root, String characters )
    {
        //leaves
        if(root.NodeName.contains(characters) && !root.isDir )
        {
            return root.NodeName;
        }

        else if(root.NodeName.contains(characters) && root.isDir && root.children.size()==0)
        {
            //System.out.print(root.NodeName + "/");
            return root.NodeName;
        }

        else if (root.NodeName.contains(characters) && !root.children.isEmpty() )
        {
            for (int i=0; i<root.children.size(); ++i)
            {
                String res = search(root.children.get(i), characters);
                if (!res.isEmpty())
                {
                    //System.out.println("aaa"+root.NodeName +"/" + res);
                    return root.NodeName +"/"+ res;
                }
            }
            return root.NodeName;
        }

        if(!root.NodeName.contains(characters) && !root.children.isEmpty())
        {
            for (int i=0; i<root.children.size(); ++i)
            {
                String res = search(root.children.get(i), characters);
                if (!res.isEmpty())
                {
                    if(root.equals(this.root))
                        System.out.println(root.NodeName +"/" + res);
                    else
                        return root.NodeName +"/"+ res;
                }
            }
        }
        return "";
    }

    /**
     * method to print the whole tree
     * every level of a tree is represented in a line
     */
    public void printFileSystem ()
    {
        // list- queue for elements in tree
        LinkedList<FileNode > qFileNode = new LinkedList<>();
        int num=0;

        qFileNode.add(root);
        while (!qFileNode.isEmpty())
        {
            num = qFileNode.size();
            while (num > 0)
            {
                FileNode temp = qFileNode.peek();
                if(!qFileNode.isEmpty())
                {
                    //remove from queue
                    qFileNode.removeFirst();
                    System.out.print(temp.NodeName + " ");

                    //add children to the queue
                    if(temp.isDir)
                    {
                        for (int i = 0; i < temp.children.size(); i++)
                            qFileNode.addLast(temp.children.get(i));

                    }
                    num--;
                }
            }

            // Print new line between two levels
            System.out.println();
        }
        return;
    }
}
