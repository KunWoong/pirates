package me.kwy.pirates.model.holiday;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import me.kwy.pirates.model.store.Store;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@Getter
@Setter
@ToString
public class Holiday {
    @Id
    @GeneratedValue
    private Integer id;

    private String day;

    @ManyToOne
    @JsonBackReference
    private Store store;

}
