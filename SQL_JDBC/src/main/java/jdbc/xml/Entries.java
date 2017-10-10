package jdbc.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VLADIMIR on 05.10.2017.
 */

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entries {

    /**
     * Entries.
     */
    @XmlElement(name = "entry")
    private List<Entry> entries = new ArrayList<>();

    /**
     * Getter.
     * @return - Entries.
     */
    public List<Entry> getList() {
        return this.entries;
    }

    /**
     * Setter.
     * @param userList - Entries.
     */
    public void setList(List<Entry> userList) {
        this.entries = userList;
    }


}
