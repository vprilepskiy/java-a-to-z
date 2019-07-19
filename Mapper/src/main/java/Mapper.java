import org.dozer.DozerBeanMapper;

public class Mapper {

    public static void main(String[] args) {
        org.dozer.Mapper mapper = new DozerBeanMapper();
        O1 o1 = new O1("1", null, "3");
        O2 o2 = new O2(null, "2", null, "4");

        mapper.map(o1, o2);

        System.out.println(o1);
        System.out.println(o2);

        O2 map = mapper.map(o1, O2.class);

        System.out.println(map);
    }

}
