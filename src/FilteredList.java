import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

public class  FilteredList<E> extends LinkedList<E> {

    private final Predicate<E> filter;

    public FilteredList(Predicate<E> filter) {

        this.filter = filter;
    }

    @Override
    public boolean add(E e) {
        if (filter.test(e)){
            return super.add(e);
        } else {
            throw new IllegalArgumentException("Value not allowed!");
        }
    }

    @Override
    public void add(int index, E e) {
        if (filter.test(e)){
            super.add(index, e);
        } else {
            throw new IllegalArgumentException("Value not allowed!");
        }
    }

    @Override
    public void addFirst(E e) {
        if (filter.test(e)){
            super.addFirst(e);
        } else {
            throw new IllegalArgumentException("Value not allowed!");
        }
    }

    @Override
    public void addLast(E e) {
        if (filter.test(e)){
            super.addLast(e);
        } else {
            throw new IllegalArgumentException("Value not allowed!");
        }
    }


    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.stream().allMatch(filter)) {
            return super.addAll(c);
        } else {
            throw new IllegalArgumentException("Values not allowed!");
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (c.stream().allMatch(filter)) {
            return super.addAll(index, c);
        } else {
            throw new IllegalArgumentException("Values not allowed!");
        }
    }
}
