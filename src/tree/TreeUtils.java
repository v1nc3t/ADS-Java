package tree;

import java.util.ArrayList;

public class TreeUtils {

    /**
     * Creates a hard copy of the n-ary tree.
     * @param t The tree to create a copy of
     * @return a new tree in which every node contains the values of the nodes at the corresponding positions in t
     */
    public static <T> Tree<T> copy(Tree<T> t) {
        if (t == null) {
            return null;
        }
        ArrayList<Tree<T>> copyChildren = new ArrayList<>();
        for (Tree<T> child : t.getChildren()) {
            copyChildren.add(copy(child));
        }
        return new Tree<T>(t.getObject(), copyChildren);
    }

}
