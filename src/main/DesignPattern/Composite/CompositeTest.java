package main.DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aijiner
 * @date 2021/6/3 20:13
 */
public class CompositeTest {
    public static void main(String[] args) {
        Composite c1 = new Composite();
        Composite c2 = new Composite();

        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        Component leaf3 = new Leaf("leaf3");

        c1.add(leaf1);
        c2.add(c1);
        c2.add(leaf2);
        c2.add(leaf3);
        c2.operation();

    }
}

interface Component {
    public void operation();
}

// 树叶
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.err.println("leaf name is [" + this.name + "]");
    }
}

// 树枝
class Composite implements Component {
    private List<Component> childred = new ArrayList<>();
    public void add(Component component) {
        childred.add(component);
    }
    public Component getChild(int i) {
        return childred.get(i);
    }

    @Override
    public void operation() {
        childred.forEach(child -> child.operation());
    }
}
















