package main.DesignPattern.adapter;

/**
 * @author Aijiner
 * @date 2021/5/30 22:35
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}

class ObjectAdapter implements Target{
    private Adaptee adaptee;
    public ObjectAdapter (Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}