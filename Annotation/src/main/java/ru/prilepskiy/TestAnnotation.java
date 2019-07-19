package ru.prilepskiy;

import java.lang.reflect.Method;

public class TestAnnotation {

    private String a = "AAAAAAAAAAABBBBBBBBbb";

    @MyAnnotation.MyTestAnnotation(expected = String.class)
    public void aVoid() {
    }

    public void reflection(Class<? extends TestAnnotation> clazz) {
        System.out.println(clazz.getName());
        Method[] declaredMethods = clazz.getDeclaredMethods();
        String name = clazz.getDeclaredMethods()[1].getAnnotations()[0].annotationType().getName();
        System.out.println(name);
    }

    public static void main(String[] args) {
        new TestAnnotation().reflection(new TestAnnotation().getClass());
    }


}
