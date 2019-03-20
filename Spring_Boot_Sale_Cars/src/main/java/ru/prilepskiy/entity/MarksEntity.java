package ru.prilepskiy.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "marks")
public class MarksEntity {
    private int id;
    private String description;
    private Set<ModelsEntity> models = new HashSet<>();

    public MarksEntity() {
    }


    public MarksEntity(int id) {
        this.id = id;
    }

    public MarksEntity(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="mark_id", insertable=true, updatable=true)
    public Set<ModelsEntity> getModels() {
        return models;
    }

    public void setModels(Set<ModelsEntity> models) {
        this.models = models;
    }
}
