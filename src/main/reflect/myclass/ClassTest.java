package main.reflect.myclass;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;

/**
 * @author Aijiner
 * @date 2021/6/5 19:49
 */
@AnnotationA
@AnnotationB
public class ClassTest extends Demo implements Serializable, InterfaceA {
    public static void main(String[] args) throws Exception {
        Class<ClassTest> clazz = ClassTest.class;
        /**
         * <U> Class<? extends U>	asSubclass(Class<U> clazz)
         * 判断是否是其子类，是时返回子类class，否时抛出：java.lang.ClassCastException
         */
        System.err.println(clazz.asSubclass(Object.class));

        /**
         * T	cast(Object obj)
         * 强制转换对象，失败抛出：ClassCastException
         */
        Serializable cast = Serializable.class.cast(new ClassTest());

        /**
         * boolean	desiredAssertionStatus()
         * 获取该类的断言状态，类的断言状态可通过类的ClassLoader设置
         */
        System.err.println(clazz.desiredAssertionStatus());

        /**
         * static Class<?>	forName(String className)
         * 反射加载类，会初始化类
         * static Class<?>	forName(String name, boolean initialize, ClassLoader loader)
         * 反射加载类，可以指定是否需要初始化
         */
//        Class<?> aClass = Class.forName("main.reflect.myclass.Demo");
        Class<?> aClass1 = Class.forName("main.reflect.myclass.Demo", false, ClassTest.class.getClassLoader());

        /**
         * AnnotatedType[]	getAnnotatedInterfaces()
         * 获取class实现接口的所有Type。
         * Type 是 Java 编程语言中所有类型的通用超级接口。 这些包括原始类型、参数化类型、数组类型、类型变量和原始类型。
         */
        AnnotatedType[] annotatedInterfaces = clazz.getAnnotatedInterfaces();
        Arrays.stream(annotatedInterfaces).map(AnnotatedType::getType).forEach(System.err::println);


        /**
         * AnnotatedType	getAnnotatedSuperclass()
         * 获取父类的Type
         */
        System.err.println(Demo.class.getAnnotatedSuperclass().getType());

        /**
         * <A extends Annotation> A	getAnnotation(Class<A> annotationClass)
         * 获取CLass上指定的Annotation
         */
        Annotation annotation = clazz.getAnnotation(AnnotationA.class);
        System.err.println(annotation.annotationType());
        System.err.println("---------------------");
        /**
         * Annotation[]	getAnnotations()
         * 获取Class上所有的Annotation
         */
        Arrays.stream(clazz.getAnnotations()).map(Annotation::annotationType).forEach(System.err::println);
        System.err.println("-----------------------------------");

        /**
         * <A extends Annotation> A[]	getAnnotationsByType(Class<A> annotationClass)
         * 由于Java8加入重复注解，此方法可以获取多个指定的Annotation
         */
        Arrays.stream(clazz.getAnnotationsByType(AnnotationC.class)).forEach(annotationC -> System.err.println(annotationC.annotationType()));
        System.err.println("----------------------------");

        /**
         * String	getCanonicalName()
         * 返回由Java语言规范定义的基础类的规范名称
         */
        System.err.println(clazz.getCanonicalName());

        /**
         * Class<?>[]	getClasses()
         * 获取本类及其父类的内部类，权限为public
         */
        System.err.println(Arrays.toString(DemoA.class.getClasses()));

        /**
         * ClassLoader	getClassLoader()
         * 返回类的加载器
         */
        System.err.println(clazz.getClassLoader());

        /**
         * Class<?>	getComponentType()
         * 获取数组中对象对应的Class对象
         */
        System.err.println(Demo[].class.getComponentType());

        /**
         * Constructor<T>	getConstructor(Class<?>... parameterTypes)
         * 获取指定参数类型的构造器
         */
        Constructor<DemoB> constructor = DemoB.class.getConstructor(String.class);
        /**
         * Constructor<?>[]	getConstructors()
         * 获取所有的构造器
         */
        Constructor<?>[] constructors = DemoB.class.getConstructors();

        /**
         * <A extends Annotation> A	getDeclaredAnnotation(Class<A> annotationClass)
         * 获取本类注解，无法获取继承的
         */
        System.err.println(clazz.getDeclaredAnnotation(AnnotationCs.class));

        /**
         * Annotation[]	getDeclaredAnnotations()
         * 获取所有注解，无法获取继承的
         */
        Arrays.stream(clazz.getDeclaredAnnotations()).forEach(System.err::println);
        System.err.println("------------------");
        /**
         * <A extends Annotation> A[]	getDeclaredAnnotationsByType(Class<A> annotationClass)
         * 获取重复的注解，无法获取继承的
         */
        Arrays.stream(clazz.getDeclaredAnnotationsByType(AnnotationC.class)).forEach(System.err::println);

        /**
         * Class<?>[]	getDeclaredClasses()
         * 获取当前类的内部类，不获取父类的内部类，没有权限限制
         */
        Arrays.stream(DemoA.class.getDeclaredClasses()).forEach(System.err::println);

        /**
         * Constructor<T>	getDeclaredConstructor(Class<?>... parameterTypes)
         * 可以获取私有的构造器
         */
        Constructor<DemoB> declaredConstructor = DemoB.class.getDeclaredConstructor(int.class);
        System.err.println(declaredConstructor);
        System.err.println("---------------------------------");
        /**
         * Constructor<?>[]	getDeclaredConstructors()
         * 获取所有的构造器，无权限限制
         */
        Arrays.stream(DemoB.class.getDeclaredConstructors()).forEach(System.err::println);

        /**
         * Field	getDeclaredField(String name)
         * 获取指定名称的Field，无权限控制
         */
        System.err.println(DemoC.class.getDeclaredField("mDefault"));

        /**
         * Field[]	getDeclaredFields()
         * 获取所有字段，无权限控制
         */
        Arrays.stream(DemoC.class.getDeclaredFields()).forEach(System.err::println);
        System.err.println("-----------------------");

        /**
         * Field	getField(String name)
         * Field[]	getFields()
         * 获取字段，有权限限制
         */


        /**
         * Method	getDeclaredMethod(String name, Class<?>... parameterTypes)
         * 根据参数获取指定的Method
         */
        System.err.println(DemoD.class.getDeclaredMethod("test", int.class));

        /**
         * Method[]	getDeclaredMethods()
         * 获取所有的Method
         */
        Arrays.stream(DemoD.class.getDeclaredMethods()).forEach(System.err::println);
        System.err.println("-------------------");

        /**
         * Method	getMethod(String name, Class<?>... parameterTypes)
         * Method[]	getMethods()
         */

        /**
         * Class<?>	getDeclaringClass()
         * 可获取内部类的上一层Class
         */
        System.err.println(DemoF.DemoFF.DemoFFF.class.getDeclaringClass());

        /**
         * Class<?>	getEnclosingClass()
         * 对匿名内部类也有效
         */
        System.err.println(DemoF.DemoFF.DemoFFF.DemoInterface.getClass().getEnclosingClass());
        System.err.println(DemoF.DemoFF.DemoFFF.DemoInterface.getClass().getDeclaringClass());

        /**
         * Constructor<?>	getEnclosingConstructor()
         * 可获得匿名内部类的构造函数
         */
        System.err.println(DemoF.DemoFF.DemoFFF.DemoInterface.getClass().getDeclaredConstructor());
        System.err.println(DemoF.DemoFF.DemoFFF.class.getDeclaredConstructor());
        System.err.println("----------------");
        /**
         * Method	getEnclosingMethod()
         * 当此类是本地或匿名类时，它将返回基础类的最近封闭方法
         */
        System.err.println(DemoF.DemoFF.DemoFFF.getDemoFFFInner().getClass().getEnclosingMethod());
        System.err.println("---------------------");

        /**
         * T[]	getEnumConstants()
         * 返回此枚举类的元素，如果此Class对象不表示枚举类型，则返回null。
         */
        System.err.println(Arrays.toString(EnumA.class.getEnumConstants()));


        /**
         * Type[]	getGenericInterfaces()
         * 返回实现接口信息的Type数组，包含泛型信息
         */
        System.err.println(Arrays.toString(DemoG.class.getGenericInterfaces()));

        /**
         * Class<?>[]	getInterfaces()
         * 返回实现接口信息的Class数组，不包含泛型信息
         */
        System.err.println(Arrays.toString(DemoG.class.getInterfaces()));

        /**
         * int	getModifiers()
         * 返回int类型值表示该字段的修饰符
         */
        System.err.println(Modifier.toString(Demo.class.getModifiers()));

        /**
         * String	getName()
         * 获取类类名
         */
        System.err.println(Demo.class.getName());

        /**
         * String	getSimpleName()
         * 获取类的简单名称
         */
        System.err.println(Demo.class.getSimpleName());

        /**
         * Package	getPackage()
         * 获取包对象Package
         */
        System.err.println(Demo.class.getPackage());

        System.err.println("----------------------------------------------------");
        /**
         * ProtectionDomain	getProtectionDomain()
         * 返回Class对应的保户域
         * ProtectionDomain类封装了域的特征，该域包含一组类，这些类的实例在代表给定的Principal集执行时被授予一组权限。
         */
        System.err.println(Demo.class.getProtectionDomain());
        System.err.println("==========================");

        /**
         * URL	getResource(String name)
         * 获取当前类的路径
         */
        System.err.println(Demo.class.getResource(""));
        System.err.println(Demo.class.getResource("/"));

        /**
         * InputStream	getResourceAsStream(String name)
         * 获取类路径下资源
         */
        System.err.println(ClassTest.class.getResourceAsStream("application.properties"));

        /**
         * Object[]	getSigners()
         * 获取签名
         */
        System.err.println(Arrays.toString(ClassTest.class.getSigners()));

        /**
         * Class<? super T>	getSuperclass()
         * 获取父类
         */
        System.err.println(Demo.class.getSuperclass());

        /**
         * String	getTypeName()
         * 返回此类型名称的信息字符串
         */
        System.err.println(Demo[].class.getTypeName());
        System.err.println(Demo[].class.getName());

        /**
         * TypeVariable<Class<T>>[]	getTypeParameters()
         * 获取泛型
         */
        System.err.println(Arrays.toString(Map.class.getTypeParameters()));

        System.err.println("======================================");

        /**
         * boolean	isAnnotation()
         * 判读是不是Annotation类型
         */
        System.err.println(Demo.class.isAnnotation() + " : " + AnnotationA.class.isAnnotation());

        /**
         * boolean	isAnnotationPresent(Class<? extends Annotation> annotationClass)
         */
        System.err.println(AnnotationA.class.isAnnotationPresent(Target.class));

        /**
         * boolean	isAnonymousClass()
         * 判断是不是匿名内部类
         */
        System.err.println(Demo.class.isAnonymousClass());
        System.err.println(DemoF.DemoFF.DemoFFF.DemoInterface.getClass().isAnonymousClass());

        /**
         * boolean	isArray()
         * 判断是否是数组
         */
        System.err.println(Object[].class.isArray());

        /**
         * boolean	isAssignableFrom(Class<?> cls)
         * 判读调用类是不是参数类的同类或者父类
         */
        System.err.println(Object.class.isAssignableFrom(Demo.class));

        /**
         * boolean	isEnum()
         * 判断是否是枚举
         */
        System.err.println(EnumA.class.isEnum());

        /**
         * boolean	isInstance(Object obj)
         * 判断是否是参数对象的类及其父类
         */
        System.err.println(Demo.class.isInstance(new Demo()));

        System.err.println("=======================");
        /**
         * boolean	isInterface()
         * 判读是否是接口
         */
        System.err.println(InterfaceA.class.isInterface());

        /**
         * boolean	isLocalClass()
         * 判读是否是局部类，代码块中的类
         */
        class A{}
        System.err.println(A.class.isLocalClass());

        /**
         * boolean	isMemberClass()
         * 判读类是不是成员类
         */
        System.err.println(DemoA.DemoAA.class.isMemberClass());

        /**
         * boolean	isPrimitive()
         * 判断是否是基本类型
         */
        System.err.println(int.class.isPrimitive());

        /**
         * boolean	isSynthetic()
         * 是否是合成类，不知道是做啥的。。。
         */
        System.err.println(DemoA.DemoAA.class.isSynthetic());

        /**
         * String	toGenericString()
         */
        System.err.println(Demo.class.toGenericString());
        System.err.println(EnumA.class.toGenericString());

    }
}








