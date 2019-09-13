import java.util.LinkedList;


public class AdvancedFilteredList<E> extends LinkedList<E> {

    private final AdvancedListFilter<E> advancedFilter;

    public AdvancedFilteredList(AdvancedListFilter<E> advancedFilter) {
        this.advancedFilter = advancedFilter;
    }

    @Override
    public boolean add(E e) {
        return super.add(advancedFilter.filter(this, e));
    }


    @Override
    public void add(int index, E e) {
        super.add(index, (advancedFilter.filter(this, e)_);
    }

    @Override
    public void addFirst(E e) {
        super.addFirst(advancedFilter.filter(this, e));
    }

    @Override
    public void addLast(E e) {
        super.addLast(advancedFilter.filter(this, e));
    }
}
