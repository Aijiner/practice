package main.DesignPattern.State;

/**
 * @author Aijiner
 * @date 2021/6/3 21:09
 */
public class StateTest {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }
}

class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle() {
        state.Handle(this);
    }
}

// 抽象类
abstract class State {
    public abstract void Handle(Context context);
}

class ConcreteStateA extends State {
    @Override
    public void Handle(Context context) {
        System.err.println("ConcreteStateA.Handle");
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {
    @Override
    public void Handle(Context context) {
        System.err.println("ConcreteStateB.Handle");
        context.setState(new ConcreteStateA());
    }
}







