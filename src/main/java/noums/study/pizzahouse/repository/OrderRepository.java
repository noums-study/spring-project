package noums.study.pizzahouse.repository;

import noums.study.pizzahouse.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, Integer> {


}
