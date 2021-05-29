package me.kwy.pirates.service;

import me.kwy.pirates.model.businessDay.BusinessTime;
import me.kwy.pirates.model.businessDay.BusinessTimeRepository;
import me.kwy.pirates.model.businessDay.DateType;
import me.kwy.pirates.model.holiday.Holiday;
import me.kwy.pirates.model.store.Store;
import me.kwy.pirates.model.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoreService {
    @Autowired
    BusinessTimeRepository businessTimeRepository;
    @Autowired
    StoreRepository storeRepository;

    public void insertStore(Store store){
        List<BusinessTime> businessTimes= store.getBusinessTimes();
        store.setBusinessTimes(new ArrayList<>());
        Store savedStore = storeRepository.save(store);
        businessTimes.forEach(businessTime -> {
            savedStore.add(businessTime);
            businessTimeRepository.save(businessTime);
        });

    }

    public Store getStoreById(int id){
        return storeRepository.findById(id).orElse(null);
    }

    public  void deleteStoreById(int id){
        try{
            storeRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException ignored){

        }

    }

    public List<Object> getStores(){
        List<Store> stores = storeRepository.findAll(Sort.by(Sort.Direction.ASC, "level"));

        return stores.stream().map(store -> {
            Map<String, Object> objectMap = new LinkedHashMap<>();
            objectMap.put("name", store.getName());
            objectMap.put("description", store.getDescription());
            objectMap.put("level", store.getLevel());

            List<BusinessTime> businessTimeList = store.getBusinessTimes();
            LocalDate todayDate = LocalDate.now();
            int dateCode = todayDate.getDayOfWeek().getValue();
            Optional<BusinessTime> compareBusinessTime = businessTimeList.stream().filter(businessTime -> businessTime.getDay().equalCode(dateCode))
                    .findFirst();
            List<Holiday> holidayList = store.getHolidays();
            objectMap.put("businessStatus", businessStatus(todayDate, compareBusinessTime, holidayList));
            return objectMap;
        }).collect(Collectors.toList());
    }

    public Object getStoreDetail(int id){
        Store store = getStoreById(id);
        store.getBusinessTimes().sort(Comparator.comparing(BusinessTime::getDay));
        Map<String, Object> objectMap = new LinkedHashMap<>();
        objectMap.put("id", store.getId());
        objectMap.put("name", store.getName());
        objectMap.put("description", store.getDescription());
        objectMap.put("level", store.getLevel());
        objectMap.put("address", store.getAddress());
        objectMap.put("phone", store.getPhone());

        List<BusinessTime> businessDays = store.getBusinessTimes();
        List<Holiday> holidayList = store.getHolidays();
        objectMap.put("businessDays", get3DaysInfo(businessDays, holidayList));
        return objectMap;
    }

    private String businessStatus(LocalDate date, Optional<BusinessTime> compareBusinessTime, List<Holiday> holidayList){
        String result;

        String searchDay = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        if (holidayList.stream().anyMatch(holiday ->holiday.getDay().equals(searchDay))) {
            return "HOLIDAY";
        }

        if(compareBusinessTime.isPresent()){
            String today =  LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
            if(!today.equals(searchDay)){
                result =  "OPEN";
            }else{
                LocalTime openTime = LocalTime.parse(compareBusinessTime.get().getOpen());
                LocalTime closeTime;
                try {
                    closeTime = LocalTime.parse(compareBusinessTime.get().getClose());
                }catch(DateTimeParseException e){
                    closeTime = LocalTime.parse("23:59:59");
                }
                LocalTime currentTime = LocalTime.now();
                if(currentTime.isBefore(closeTime) && currentTime.isAfter(openTime)){
                    result = "OPEN";
                }else {
                    result = "CLOSE";
                }
            }
        }else{
            result = "HOLIDAY";
        }
        return result;
    }

    private List<Object> get3DaysInfo(List<BusinessTime> businessDays, List<Holiday> holidayList){
        LocalDate targetDate = LocalDate.now();

        List<Object> infoList = new ArrayList<>();

        while(infoList.size() < 3){
            int dateCode = targetDate.getDayOfWeek().getValue();
            LocalDate finalTargetDate = targetDate;
            DateType dateType = DateType.getByCode(dateCode);
            Map<String, String> map = new LinkedHashMap<>();
            map.put("day", dateType.word);

            String open = "";
            String close = "";
            String status = "";
            Optional<BusinessTime> businessTime = businessDays.stream().filter(item -> item.getDay() == DateType.getByCode(dateCode))
                    .findFirst();
            if (businessTime.isPresent()) {
                open = businessTime.get().getOpen();
                close = businessTime.get().getClose();
            }
            status = businessStatus(finalTargetDate, businessTime, holidayList);
            map.put("open", open);
            map.put("close", close);
            map.put("status", status);
            infoList.add(map);

            targetDate = targetDate.plusDays(1);
        }

        return infoList;

    }

}
