package ru.prilepskiy.b;

import ru.prilepskiy.User;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            new Demo().createUserArray(220000);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private void createUserArray(int count) throws InterruptedException {
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = new User();
        }
    }
}
