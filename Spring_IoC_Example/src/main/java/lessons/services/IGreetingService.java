package lessons.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 * Created by VLADIMIR on 22.03.2018.
 */
public interface IGreetingService {

    /**
     * Приветствие.
     * @return - тектовое значение.
     */
    @Scope("prototype") // каждый раз создается новый бин (default singleton).
    String sayGreeting();

}
