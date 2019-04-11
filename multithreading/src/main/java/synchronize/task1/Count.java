package synchronize.task1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe //эта аннотация, говорит пользователям данного класса, что класс можно использовать в многопоточном режиме и он будет работать правильно.
public class Count {

    @GuardedBy("this") //эта аннотация выставляется над общим ресурсом. Аннотация имеет входящий параметр. Он указывает на объект монитора, по которому мы будет синхронизироваться.
    private int value;

    public synchronized void increment() {
        this.value++;
    }

    public synchronized int get() {
        return this.value;
    }
}
