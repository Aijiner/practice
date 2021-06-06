package main.DesignPattern.Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aijiner
 * @date 2021/6/3 22:09
 */
public class MediatorTest {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        mediator.register(c1);
        mediator.register(c2);
        c1.send();
        System.err.println("---------");
        c2.send();
    }
}

// 抽象中介者
interface Mediator {
    void register(Colleague colleague);

    void relay(Colleague colleague);
}
//具体中介者
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();
    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleague.setMediator(this);
            colleagues.add(colleague);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        colleagues.forEach(c -> {
            if (!c.equals(colleague)) {
                c.receive();
            }
        });
    }
}


// 抽象同事类
abstract class Colleague {
    protected Mediator mediator;

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}

class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.err.println("ConcreteColleague1.receive");
    }

    @Override
    public void send() {
        System.err.println("ConcreteColleague1.send");
        mediator.relay(this);
    }
}

class ConcreteColleague2 extends Colleague {
    @Override
    public void receive() {
        System.err.println("ConcreteColleague2.receive");
    }

    @Override
    public void send() {
        System.err.println("ConcreteColleague2.send");
        mediator.relay(this);
    }
}






