package main.DesignPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aijiner
 * @date 2021/6/5 15:32
 */
public class IteratorTest {
    public static void main(String[] args) {
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("a");
        aggregate.add("b");
        aggregate.add("b");

        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            System.err.println(iterator.next());
        }

    }
}

// 抽象聚合
interface Aggregate<T> {
    public void add(T t);
    public Iterator getIterator();
}

// 具体聚合
class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> data = new ArrayList<>();

    @Override
    public void add(T t) {
        data.add(t);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(data);
    }
}


// 抽象迭代器
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// 具体迭代器
class ConcreteIterator<T> implements Iterator {
    private List<T> data;
    private int cursor;

    public ConcreteIterator(List<T> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return cursor != data.size();
    }

    @Override
    public T next() {
        return data.get(cursor++);
    }
}











