package main.DesignPattern.Factory;

/**
 * @author Aijiner
 * @date 2021/5/30 19:56
 */
public class AbstractFactoryTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] strArr = {"main.DesignPattern.Factory.ConcreteFactory1","main.DesignPattern.Factory.ConcreteFactory2"};
        for (String s : strArr) {
            AbstractFactory abstractFactory = (AbstractFactory) Class.forName(s).newInstance();
            Product product = abstractFactory.getProduct();
            product.show();
        }
    }
}

// 产品接口
interface Product {
    void show();
}

// 产品1
class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.err.println("ConcreteProduct1");
    }
}

// 产品2
class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.err.println("ConcreteProduct2");
    }
}

// 工厂接口
interface AbstractFactory {
    public Product getProduct();
}

// 工厂1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product getProduct() {
        return new ConcreteProduct1();
    }
}

// 工厂2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product getProduct() {
        return new ConcreteProduct2();
    }
}

