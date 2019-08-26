package ru.prilepskiy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainClass {
    public static void main(String[] args) {
        User user = new User(1, "John");

        ClassLoader classLoader = new User().getClass().getClassLoader();
        Class[] interfaces = User.class.getInterfaces();
        InvocationHandler handler = new MyProxy(user);

        IUser proxyUser = (IUser)Proxy.newProxyInstance(classLoader, interfaces, handler);

        proxyUser.setId(50); //новое значение не присвоится
        proxyUser.setName("Uasya"); //т.к. происходит обращение к методу интерфейса а не к объекту на прямую

        System.out.println(proxyUser.getId());
        System.out.println(proxyUser.getName());
    }

    private static class MyProxy implements InvocationHandler {
        private User user;

        public MyProxy(User user) {
            this.user = user;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.printf("method: %s; %n", method.getName());

            User user = new User(this.user.getId() + 1, this.user.getName().concat(" (modify)"));
            return method.invoke(user, args);
        }
    }
}
