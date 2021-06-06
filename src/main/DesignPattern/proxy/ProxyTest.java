package main.DesignPattern.proxy;

/**
 * @author Aijiner
 * @date 2021/5/30 22:08
 */
public class ProxyTest {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}

// 接口
interface Subject {
    void request();
}

// 实现
class RealSubject implements Subject {
    @Override
    public void request() {
        System.err.println("RealSubject.request()");
    }
}

// 代理对象
class Proxy implements Subject {
    @Override
    public void request() {
        RealSubject subject = new RealSubject();

        System.err.println("代理前处理");
        subject.request();
        System.err.println("代理后处理");
    }
}