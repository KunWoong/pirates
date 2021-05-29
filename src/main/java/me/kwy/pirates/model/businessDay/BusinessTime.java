package me.kwy.pirates.model.businessDay;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.kwy.pirates.model.store.Store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter @Setter
@NoArgsConstructor
public class BusinessTime {
    @Id @GeneratedValue
    private Integer id;
    private DateType day;
    private String open;
    private String close;

    @ManyToOne
    @JsonBackReference
    private Store store;
}
