package tiger.dorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tiger.dorm.entity.Repair;
import tiger.dorm.mapper.RepairManagementMapper;
import tiger.dorm.service.RepairManagementService;
@Service
public class RepairManagementServiceImpl implements RepairManagementService {
	@Autowired
	RepairManagementMapper repairManagementMapper; 
	@Override
	public int insertRepairApply(Repair repair) {
        	 int result= repairManagementMapper.insertRepairApply(repair);
        	 return result;
        	
	}
	
	
	

}
