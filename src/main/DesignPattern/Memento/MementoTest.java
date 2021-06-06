package main.DesignPattern.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aijiner
 * @date 2021/6/5 16:41
 */
public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("state #1");
        originator.setState("state #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("state #3");
        careTaker.add(originator.saveStateToMemento());

        careTaker.acceptMementosState();
    }
}

// 备忘录
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// 发起人
class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }
}

// 管理
class CareTaker {
    private List<Memento> mementos = new ArrayList<>();
    public void add(Memento memento) {
        mementos.add(memento);
    }

    public void acceptMementosState() {
        mementos.forEach(memento -> System.err.println(memento.getState()));
    }
}












