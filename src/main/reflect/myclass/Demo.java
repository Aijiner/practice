package main.reflect.myclass;

/**
 * @author Aijiner
 * @date 2021/6/5 20:16
 */
@AnnotationCs({@AnnotationC("AnnotationC1"),@AnnotationC("AnnotationC2")})
public class Demo {
    static {
        System.err.println("Demo 类静态代码块");
    }
    public class Demo1 {}
}

class DemoA extends Demo {
    public class DemoAA {}
    private class DemoAA2{}
}

class DemoB {
    public DemoB(){}
    public DemoB(String name){}
    private DemoB(int age){}
}

class DemoC {
    private String mPrivate;
    public String mPublic;
    protected String mProtected;
    String mDefault;
}

class DemoD{
    private void test(int i){}
    void test(long l){}
    protected void test(double d){}
    public void test(String s){}
}

class DemoF{
    static class DemoFF{
        static class DemoFFF{
            public static DemoInterface DemoInterface = new DemoInterface() {};
            public static Object getDemoFFFInner(){
                class DemoFFFInner{}
                return new DemoFFFInner();
            }
        }
    }
}

interface DemoInterface<T> {}

interface DemoGInterface<T>{}
class DemoG<T> implements DemoGInterface<T> {}