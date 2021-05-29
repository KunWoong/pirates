package me.kwy.pirates;

import me.kwy.pirates.model.businessDay.BusinessTimeRepository;
import me.kwy.pirates.model.store.StoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    BusinessTimeRepository businessTimeRepository;

    @Test
    public void test(){
//        Store store = new Store();
//        store.setName("name1");
//        store.setOwner("owner1");
//        store.setDescription("description1");
//        store.setLevel(1);
//        store.setAddress("address");
//        store.setPhone("010-1010-0101");
//        storeRepository.save(store);
//
//        BusinessTime businessTime1 = BusinessTime.builder()
//                                                .dayCode(1)
//                                                .openTime("09:00")
//                                                .closeTime("23:00")
//                                                .build();
//        BusinessTime businessTime2 = BusinessTime.builder()
//                                                .dayCode(2)
//                                                .openTime("09:00")
//                                                .closeTime("24:00")
//                                                .build();
//
//        store.add(businessTime1);
//        store.add(businessTime2);
//
//        businessTimeRepository.save(businessTime1);
//        businessTimeRepository.save(businessTime2);
//
//        List<BusinessTime> businessTimeList = businessTimeRepository.findAll();
//        System.out.println(businessTimeList.size());
//        businessTimeList.forEach(businessTime -> System.out.println(businessTime.toString()));

    }
}