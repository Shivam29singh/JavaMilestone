package com.dc.truckdcslotsystem;

import com.dc.truckdcslotsystem.controller.DcSlotController;
import com.dc.truckdcslotsystem.model.DcSlot;
import com.dc.truckdcslotsystem.service.DcSlotService;
import com.dc.truckdcslotsystem.service.impl.DcSlotServiceImpl;
import org.junit.*;
import org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
 public class TruckDcslotSystemApplicationTests {

	@InjectMocks
	DcSlotController dcSlotController ;
	@Mock
	DcSlotServiceImpl service;
	@Test
	public void contextLoads() {


	}
	@Test
   public void addDcSlotTestSuccess(){
		Mockito.when(service.addDcSlot(any(),anyLong())).thenReturn(true);
     ResponseEntity responseEntity =  dcSlotController.addDcSlot(any(),anyLong());
     Assert.assertEquals("ADDED", responseEntity.getBody());
 }


	@Test
	public void addDcSlotTestFialiure(){
		Mockito.when(service.addDcSlot(any(),anyLong())).thenReturn(false);
		ResponseEntity responseEntity =  dcSlotController.addDcSlot(any(),anyLong());
		Assert.assertEquals("THERE WAS A PROBLEAM", responseEntity.getBody());
	}

	@Test
	public  void  searchDCTimeSlotSuccess(){

		DcSlot dcSlot = new DcSlot();
		 dcSlot.setMaxTruck(200);
//		List<DcSlot> dcSlotsList = Collections.singletonList(dcSlot);
		Mockito.when(service.searchByDCTimeSlot(any(),anyLong())).thenReturn(dcSlot);
		DcSlot dcSlotreturn = dcSlotController.searchDCTimeSlot(any(),anyLong());
		Assert.assertEquals((Integer) 200, (Integer) dcSlotreturn.getMaxTruck());


	}
	@Test
	public  void  searchDCTimeSlotFailiure(){

//		List<DcSlot> dcSlotsList = Collections.singletonList(dcSlot);
		Mockito.when(service.searchByDCTimeSlot(any(),anyLong())).thenReturn(null);
		DcSlot dcSlotreturn = dcSlotController.searchDCTimeSlot(any(),anyLong());
		Assert.assertEquals( null,  dcSlotreturn);


	}

	@Test
	public void  updateDcSlotSuccess(){
		DcSlot dcSlot = new DcSlot();
		dcSlot.setMaxTruck(200);

		Mockito.when(service.updateDcSlot(any(),anyInt())).thenReturn(dcSlot);
		ResponseEntity responseEntity =  dcSlotController.updateDcSlot(any(),anyInt());
		Assert.assertEquals((Integer)200, (Integer)( (DcSlot)(responseEntity.getBody())).getMaxTruck());
	}

	@Test
	public void  updateDcSlotFail(){


		Mockito.when(service.updateDcSlot(any(),anyInt())).thenReturn(null);
		ResponseEntity responseEntity =  dcSlotController.updateDcSlot(any(),anyInt());
		Assert.assertEquals("THERE WAS A NO SUCH SLOT", (responseEntity.getBody()));
	}

	@Test
	public  void deleteDcSlotSuccss(){
		Mockito.when(service.deleteDcSlot(anyInt())).thenReturn(true);
		   ResponseEntity responseEntity =  dcSlotController.deleteDcSlot(anyInt());
		   Assert.assertEquals("DELETED",responseEntity.getBody());
	}

	@Test
	public  void deleteDcSlotFail(){
		Mockito.when(service.deleteDcSlot(anyInt())).thenReturn(false);
		ResponseEntity responseEntity =  dcSlotController.deleteDcSlot(anyInt());
		Assert.assertEquals("THERE WAS A PROBLEAM",responseEntity.getBody());
	}
}
