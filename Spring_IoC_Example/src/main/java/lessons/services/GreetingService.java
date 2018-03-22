package lessons.services;

import org.springframework.context.annotation.Description;

/**
 * Created by VLADIMIR on 22.03.2018.
 */
public class GreetingService implements IGreetingService {

    /**
     * Приветствие.
     * @return - Hello world!!!
     */
    @Override
    public String sayGreeting() {
        return "Hello world!!!";
    }
}
