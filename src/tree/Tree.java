package tree;

import java.util.List;
import java.util.LinkedList;
import java.util.Objects;

public class Tree<T> {

    private T object;

    private List<Tree<T>> children;

    public Tree(T object) {
        this.object = object;
        this.children = new LinkedList<>();
    }

    public Tree(T object, List<Tree<T>> children) {
        this.children = new LinkedList<>(children);
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void addChild(Tree<T> child) {
        if (child != null) {
            this.children.add(child);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(object, tree.object)
                && Objects.equals(children, tree.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, children);
    }
}
