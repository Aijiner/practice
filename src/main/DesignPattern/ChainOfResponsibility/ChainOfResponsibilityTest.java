package main.DesignPattern.ChainOfResponsibility;

/**
 * @author Aijiner
 * @date 2021/6/3 20:54
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setNext(h2);
        h1.handlerRequest("two");
    }
}

// 抽象处理者
abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handlerRequest(String request);
}


// 具体处理者角色1
class ConcreteHandler1 extends Handler {
    @Override
    public void handlerRequest(String request) {
        if ("one".equals(request)) {
            System.err.println("ConcreteHandler1.handlerRequest");
        } else {
            if (null != this.getNext()){
                this.getNext().handlerRequest(request);
            } else {
                System.err.println("not handler deal request");
            }
        }
    }
}

// 具体处理者角色2
class ConcreteHandler2 extends Handler {
    @Override
    public void handlerRequest(String request) {
        if ("two".equals(request)) {
            System.err.println("ConcreteHandler2.handlerRequest");
        } else {
            if (null != this.getNext()){
                this.getNext().handlerRequest(request);
            } else {
                System.err.println("not handler deal request");
            }
        }
    }
}




