package ru.job4j.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VLADIMIR on 12.12.2017.
 */
public class Role {

    /**
     * Constructor.
     * @param description - description.
     */
    public Role(String description) {
        this.description = description;
    }


    /**
     * Description.
     */
    private final String description;


    /**
     * Rights.
     */
    private final Set<String> rights = new HashSet<>();


    /**
     * Getter.
     * @return - description.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Add right.
     * @param right - right.
     * @return - it is true if added.
     */
    public boolean addRight(String right) {
        return this.rights.add(right);
    }


    /**
     * Getter.
     * @return - rights.
     */
    public Set<String> getRights() {
        return this.rights;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Role{ description='");
        sb.append(this.description);
        sb.append("\', rights=");
        sb.append(this.rights);
        sb.append('}');
        return sb.toString();
    }


}
