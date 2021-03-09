/*From book*/
public interface SearchTree<E>
{
    /**
     *  Inserts item where it belongs in the tree.
     * @param item
     * @return Returns true if item is inserted;
     * false if it isn’t (already in tree)
     */
    boolean add (E item);

    /**
     *
     * @param target
     * @return  Returns true if target is found in the tree
     */
    boolean contains(E target);

    /**
     *
     * @param target
     * @return Returns a reference to the data in the node that is equal to target.
     * If no such node is found, returns null
     */
    E find(E target);

    /**
     *
     * @param target
     * @return Removes target (if found) from tree and returns it; otherwise, returns null
     */
    E delete(E target) ;

    /**
     *  Removes target (if found) from tree and returns true; otherwise, returns false
     * @param target
     * @return
     */
    boolean remove(E target);

}
