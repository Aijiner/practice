package main.DesignPattern.TemplateMethod;

/**
 * @author Aijiner
 * @date 2021/6/3 20:27
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        ac.TemplateMethod();
    }
}

// 抽象类
abstract class AbstractClass {
    // 模板方法
    public void TemplateMethod() {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }
    //具体方法
    public void SpecificMethod() {
        System.out.println("AbstractClass.SpecificMethod");
    }
    //抽象方法1
    public abstract void abstractMethod1();
    //抽象方法2
    public abstract void abstractMethod2();
}

// 具体子类
class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.err.println("ConcreteClass.abstractMethod1");
    }

    @Override
    public void abstractMethod2() {
        System.err.println("ConcreteClass.abstractMethod2");
    }
}





