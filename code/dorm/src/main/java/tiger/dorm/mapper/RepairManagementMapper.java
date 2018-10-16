package tiger.dorm.mapper;

import org.springframework.stereotype.Repository;

import tiger.dorm.entity.Repair;
@Repository
public interface RepairManagementMapper {
	// 把维修单插入数据库
	public int insertRepairApply(Repair repair);
}
