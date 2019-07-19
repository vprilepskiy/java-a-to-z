package ru.prilepskiy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotation {

    @Target(ElementType.METHOD)//Указывает, что целью нашей Аннотации является метод (не класс, не переменная, не поле, а именно метод).
    @Retention(RetentionPolicy.RUNTIME)//Указывает, что наша Аннотация может использована во время выполнения через Reflection
    public @interface MyTestAnnotation {
        Class expected();
    }

}
