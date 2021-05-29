package me.kwy.pirates.model.store;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.kwy.pirates.model.businessDay.BusinessTime;
import me.kwy.pirates.model.holiday.Holiday;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(
        name = "STORE_SEQ_GENERATOR",
        sequenceName = "STORE_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_SEQ_GENERATOR")
    private Integer id;

    private String name;
    private String owner;
    private String description;
    private int level;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "store", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<BusinessTime> businessTimes = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Holiday> holidays = new ArrayList<>();

    public void add(BusinessTime businessTime){
        businessTime.setStore(this);
        getBusinessTimes().add(businessTime);
    }

    public void add(Holiday holiday){
        holiday.setStore(this);
        getHolidays().add(holiday);
    }

}
