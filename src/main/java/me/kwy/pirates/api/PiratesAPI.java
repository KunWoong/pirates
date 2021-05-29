package me.kwy.pirates.api;

import me.kwy.pirates.service.HolidayService;
import me.kwy.pirates.service.StoreService;
import me.kwy.pirates.model.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PiratesAPI {
    @Autowired
    StoreService storeService;
    @Autowired
    HolidayService holidayService;

    @PostMapping("/mvc/store")
    public void insertStore(@RequestBody Store store){
        storeService.insertStore(store);
    }

    @DeleteMapping("/mvc/store")
    public void deleteStore(int id){
        storeService.deleteStoreById(id);
    }

    @GetMapping("/mvc/store")
    public Object getStoreDetail(@RequestParam("id") int id){
        return storeService.getStoreDetail(id);
    }

    @PostMapping("/mvc/holiday")
    public void addHoliday(@RequestBody Map<String, Object> param){
        int storeId = (int) param.get("id");
        List<String> days = (List<String>) param.get("holidays");
        holidayService.insertHolidays(storeId, days);
    }

    @GetMapping("/mvc/list")
    public List<Object> getStores(){
        return storeService.getStores();
    }

}
