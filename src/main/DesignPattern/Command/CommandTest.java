package main.DesignPattern.Command;

/**
 * @author Aijiner
 * @date 2021/6/3 20:44
 */
public class CommandTest {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}

// 接受者
class Receiver {
    public void action() {
        System.err.println("Receiver.action");
    }
}
// 抽象命令
interface Command {
    public abstract void execute();
}

// 具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand() {
        this.receiver = new Receiver();
    }

    @Override
    public void execute() {
        System.err.println("ConcreteCommand.execute");
        receiver.action();
    }
}

// 调用者
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        System.err.println("Invoker.call");
        command.execute();
    }
}








