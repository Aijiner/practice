package main.DesignPattern.Bridge;

/**
 * @author Aijiner
 * @date 2021/5/31 21:03
 */
public class BridgeTest {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.Operation();
    }
}


// 角色接口
interface Implementor {
    public void OperationImpl();
}

// 实现角色
class ConcreteImplementor implements  Implementor {
    @Override
    public void OperationImpl() {
        System.err.println("ConcreteImplementor.OperationImpl()");
    }
}

// 抽象角色
abstract class Abstraction{
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void Operation();
}

// 抽象角色扩展
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void Operation() {
        System.err.println("RefinedAbstraction.Operation");
        implementor.OperationImpl();
    }
}










