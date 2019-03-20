package ru.prilepskiy.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "items")
public class ItemsEntity implements Serializable {
    private int id;
    private UserEntity user;
    private MarksEntity mark;
    private ModelsEntity model;
    private BodyTypesEntity bodyType;
    private Integer year;
    private Integer price;
    private byte[] photo;
    private Boolean active;
    private Timestamp created;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "mark_id", nullable = false)
    public MarksEntity getMark() {
        return mark;
    }

    public void setMark(MarksEntity mark) {
        this.mark = mark;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "model_id", nullable = false)
    public ModelsEntity getModel() {
        return model;
    }

    public void setModel(ModelsEntity model) {
        this.model = model;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "body_type_id", nullable = false)
    public BodyTypesEntity getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyTypesEntity bodyType) {
        this.bodyType = bodyType;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Type(type = "org.hibernate.type.MaterializedBlobType")
    @Column(name = "photo", length = 1024 * 1024 * 10)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsEntity that = (ItemsEntity) o;
        return id == that.id &&
            Objects.equals(mark, that.mark) &&
            Objects.equals(model, that.model) &&
            Objects.equals(bodyType, that.bodyType) &&
            Objects.equals(year, that.year) &&
            Objects.equals(price, that.price) &&
            Arrays.equals(photo, that.photo) &&
            Objects.equals(active, that.active) &&
            Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, mark, model, bodyType, year, price, active, created);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
