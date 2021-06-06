package main.DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aijiner
 * @date 2021/6/3 22:04
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subjec subjec = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subjec.add(observer1);
        subjec.add(observer2);
        subjec.notifyObserver();
    }
}

abstract class Subjec {
    protected List<Observer> observers = new ArrayList<>();
    public void add(Observer observer) {
        observers.add(observer);
    }

    public abstract void notifyObserver();
}

class ConcreteSubject extends Subjec {
    @Override
    public void notifyObserver() {
        System.err.println("ConcreteSubject.notifyObserver");
        observers.forEach(observer -> observer.response());
    }
}



interface Observer {
    void response();
}

class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.err.println("ConcreteObserver1.response");
    }
}

class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.err.println("ConcreteObserver2.response");
    }
}







