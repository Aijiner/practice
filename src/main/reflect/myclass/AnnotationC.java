package main.reflect.myclass;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Aijiner
 * @date 2021/6/6 11:58
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
@Inherited
@Repeatable(AnnotationCs.class)
public @interface AnnotationC {
    String value();
}
