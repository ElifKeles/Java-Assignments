import java.util.LinkedList;

/**
 * The nodes of the file system tree
 */
public class FileNode
{
    /*Data fields*/
    String NodeName;
    boolean isDir= false;//initialized as file
    LinkedList<FileNode> children;

    /*Constructors*/

    /**
     * A directory can have directories and files under it
     * but a file cannot have one.
     * @param name name of file/ directory
     * @param dir true represent dir, false represents file
     */
    public FileNode(String name, boolean dir )
    {
        NodeName= name;
        if(dir)
        {
            isDir= dir;
            children=new LinkedList<FileNode>();
        }
    }
}
