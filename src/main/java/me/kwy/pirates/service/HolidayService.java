package me.kwy.pirates.service;

import me.kwy.pirates.model.holiday.Holiday;
import me.kwy.pirates.model.holiday.HolidayRepository;
import me.kwy.pirates.model.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {
    @Autowired
    HolidayRepository holidayRepository;
    @Autowired
    StoreService storeService;

    public void insertHolidays(int storeId, List<String> days) {
        Store store = storeService.getStoreById(storeId);

        days.forEach(s -> {
            Holiday holiday = new Holiday();
            holiday.setDay(s);
            store.add(holiday);
            holidayRepository.save(holiday);
        });
    }
}
