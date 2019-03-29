package ru.prilepskiy.a;

import ru.prilepskiy.User;
import ru.prilepskiy.instrument.monitoring.Item;
import ru.prilepskiy.instrument.monitoring.Memory;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 50; i++) {
//            new Demo().createUserArray(220000);
            new Demo().createUserArray(340000);
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    private void createUserArray(int count) throws InterruptedException {
//        Item item = new Memory().calculate().print("BEGIN");
        User[] users = new User[count];
        for (int i = 0; i < count; i++) {
            users[i] = new User();
//            if (i % 20000 == 0) {
//                System.out.println("i: " + i);
//            }
        }
//        new Memory().calculate().print("END").different(item).print("DIFFERENT");
//        System.out.println(users.length);
    }

    @Override
    protected void finalize() throws Throwable {
//        new Memory().calculate().print("*************** Run GC ***************");
        super.finalize();
    }
}
