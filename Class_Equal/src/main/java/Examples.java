import entity.BaseEntity;
import entity.FirstEntity;
import entity.SecondEntity;

public class Examples {

    public static void main(String[] args) {

        System.out.println(new BaseEntity() instanceof BaseEntity); //true
        System.out.println(new FirstEntity() instanceof BaseEntity); //true
        System.out.println(new BaseEntity() instanceof FirstEntity); //false

        System.out.println(new BaseEntity().getClass() == new BaseEntity().getClass()); //true
        System.out.println(new FirstEntity().getClass() == new BaseEntity().getClass()); //false
        System.out.println(new BaseEntity().getClass() == new FirstEntity().getClass()); //false
    }
}
