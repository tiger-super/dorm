package tiger.dorm.mapper;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Dorm;

@Repository
public interface DormManagementMapper {
     int insertDrom(Dorm dorm);
     int insertNetWorkAddresss(Dorm dorm);
}
