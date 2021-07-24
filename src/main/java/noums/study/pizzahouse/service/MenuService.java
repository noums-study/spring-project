package noums.study.pizzahouse.service;

import lombok.RequiredArgsConstructor;
import noums.study.pizzahouse.bean.OrderRequest;
import noums.study.pizzahouse.domain.OrderEntity;
import noums.study.pizzahouse.domain.OrderJpaRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class MenuService {
    final private OrderJpaRepository repository;

    @Cacheable(value = "menu")
    public List<OrderEntity> getOrderMenu(){
        System.out.println("메뉴 조회 / 캐시 저장 ");
        List<OrderEntity> menu = repository.findAll();
        return menu;
    }

    @Transactional
    @CachePut(value = "menu")
    public OrderEntity updateMenu(OrderEntity menu){
        System.out.println("메뉴 수정 / 캐시 업데이트");
        OrderEntity result = repository.save(menu);
        return result;
    }

    @CacheEvict(value = "menu", allEntries = true)
    public String deleteMenu(){
        System.out.println("캐시 삭제");
        //repository.deleteAll();
        return "삭제 완료";
    }


}
