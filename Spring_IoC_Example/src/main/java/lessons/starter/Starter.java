package lessons.starter;

import lessons.LessonsConfiguration;
import lessons.services.IGreetingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by VLADIMIR on 22.03.2018.
 */
public class Starter {

    /**
     * Logger.
     */
    private static final Logger logger = LogManager.getLogger(Starter.class);

    /**
     * Точка входа.
     * @param args - args.
     */
    public static void main(String[] args) {
        logger.info("Starting configuration...");

        // загрузить конфигурацию.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LessonsConfiguration.class);
        context.refresh();

        // получить бин.
        IGreetingService iGreetingService = context.getBean(IGreetingService.class);
        logger.info(iGreetingService.sayGreeting());  // "Greeting, user!"

        // загасить
        context.registerShutdownHook();
    }

}
