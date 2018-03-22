package lessons;

import lessons.services.IGreetingService;
import lessons.services.GreetingService;
import org.springframework.context.annotation.*;

/**
 * Created by VLADIMIR on 22.03.2018.
 *
 *  Заметка:
 * Полный @Configuration vs легкий @Bean режимы
 * Когда методы с аннотацией @Bean определены в классах, не имеющих аннотацию @Configuration, то относятся к обработке в легком режиме, то же относится и к классам с аннотацией @Component. Иначе, такие методы относятся к полному режиму обработки.
 * В отличие от полного, в легком режиме @Bean методы не могут просто так объявлять внутренние зависимости. Поэтому, в основном предпочтительно работать в полном режиме, во избежание трудноуловимых ошибок.
 *
 */
@Configuration
@ComponentScan(basePackages = "lessons.services") // можно объявить для автоматического поиска @Component.
@Description("Конфигурация бинов.")
public class LessonsConfiguration {


    /**
     * Привязка интерфейса к объекту.
     * @return - объект.
     */
    @Bean
    @Description("Бин Hello world!!!.")
    public IGreetingService greetingService() {
        return new GreetingService();
    }

}
