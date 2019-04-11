package synchronize.task2;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private Map<Integer, User> users = new HashMap<>();

    public boolean add(User user) {
        return this.users.putIfAbsent(user.getId(), user) == null;
    }

    public synchronized boolean update(User user) {
        return this.users.replace(user.getId(), user) != null;
    }

    public synchronized boolean delete(User user) {
        return this.users.remove(user) != null;
    }

    public synchronized boolean transfer(int fromId, int toId, long amount) {
        boolean result = false;
        final User from = this.users.get(fromId);
        final User to = this.users.get(toId);
        if (from.getAmount() - amount >= 0) {
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            result = true;
        }
        return result;
    }
}
