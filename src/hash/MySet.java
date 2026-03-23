package hash;

import java.util.HashSet;
import java.util.Iterator;

public class MySet extends HashSet<String> {

    public MySet() {
        super();
    }

    /**
     * Unions this set with the given other set.
     *
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();

        for (String s : this) {
            result.add(s);
        }

        if (that != null) {
            for (String s : that) {
                result.add(s);
            }
        }

        return result;
    }


    /**
     * Intersects this set with the given other set.
     *
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();

        if (that == null) {
            return result;
        }

        for (String s : this) {
            if (that.contains(s)) {
                result.add(s);
            }
        }

        return result;
    }

    /**
     * Gets the difference between this set and the given other set.
     *
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();

        if (that == null) {
            return result;
        }

        for (String s : this) {
            if (!that.contains(s)) {
                result.add(s);
            }
        }

        return result;
    }

    /**
     * Gets the exclusive or between this set and the given other set.
     *
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();

        MySet diff1 = this.difference(that);

        MySet diff2 = new MySet();
        if (that != null) {
            diff2 = that.difference(this);
        }

        result = diff1.union(diff2);
        return result;
    }

    /**
     * Converts this set to a string representation.
     *
     * @return a String representation of a MySet object
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("<MySet{");

        Iterator<String> it = this.iterator();
        while(it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }

        return sb.append("}>").toString();
    }
}