package main.DesignPattern.Decorator;

/**
 * @author Aijiner
 * @date 2021/5/31 21:50
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        System.err.println("-------------------------");
        component = new ConcreteDecorator(component);
        component.operation();
    }
}

// 抽象构建角色
interface Component {
    void operation();
}

// 具体构建角色
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.err.println("ConcreteComponent.operation");
    }
}

// 抽象装饰者
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public abstract void operation();
}

// 具体装饰角色
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.err.println("开始装饰");
        component.operation();
    }
}



