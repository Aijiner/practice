package main.DesignPattern.adapter;

/**
 * @author Aijiner
 * @date 2021/5/30 22:21
 */
public class ClassAdapterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.request();
    }
}

// 目标接口
interface Target {
    void request();
}

// 适配者
class Adaptee {
    public void specificRequest() {
        System.err.println("适配者业务");
    }
}

// 适配器
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}











