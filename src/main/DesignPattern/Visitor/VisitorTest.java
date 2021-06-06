package main.DesignPattern.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aijiner
 * @date 2021/6/5 16:07
 */
public class VisitorTest {
    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        os.accept(new ConcreteVisitorA());
        System.err.println("------------");
        os.accept(new ConcreteVisitorB());
    }
}

// 抽象元素
interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


// 抽象访问这
interface Visitor {
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.err.println("ConcreteVisitorA -> ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.err.println("ConcreteVisitorA -> ConcreteElementB");
    }
}

class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.err.println("ConcreteVisitorB -> ConcreteElementA");
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.err.println("ConcreteVisitorB -> ConcreteElementB");
    }
}

// 对象结构角色
class ObjectStructure {
    private List<Element> elements = new ArrayList<>();
    public void accept(Visitor visitor) {
        elements.forEach(element -> element.accept(visitor));
    }
    public void add(Element element) {
        elements.add(element);
    }
}














