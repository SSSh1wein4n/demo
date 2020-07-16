package com.personal.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author shiweinan
 * @date 2020-07-16 17:59
 */
@Entity(name = "group_entity")
public class GroupEntity implements Serializable {

    private static final long serialVersionUID = -6449413893518917710L;

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}