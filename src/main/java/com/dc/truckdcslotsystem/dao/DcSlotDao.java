package com.dc.truckdcslotsystem.dao;

import com.dc.truckdcslotsystem.model.DcSlot;
import com.dc.truckdcslotsystem.model.DistributionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DcSlotDao extends JpaRepository<DcSlot, Integer> {

    List<DcSlot> findByDistributionCenter(DistributionCenter distributionCenter);

    DcSlot findBydcTimeSlot(String dcTimeSlot);

    DcSlot findByDcSlotId(Integer id);

//    DcSlot findByDCTimeSlot(Integer dcTimeSlot);


}
