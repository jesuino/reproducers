package org.reproducer.model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class TheEntity extends PanacheEntity {
    
    public String cl;

}
