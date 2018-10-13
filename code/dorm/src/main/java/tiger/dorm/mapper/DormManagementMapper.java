package tiger.dorm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Dorm;

@Repository
public interface DormManagementMapper {
     int insertDrom(Dorm dorm);
     int insertNetWorkAddresssFromXLSX(Dorm dorm);
     int insertDromFromXLSX(List<Dorm> dorms);
     int insertDromInfoFromXLSX(Dorm dorm);
}
