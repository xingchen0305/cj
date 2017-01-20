package com.bupt626;

import com.github.abel533.easyxls.EasyXls;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

public class EquipmentServerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMap() {
		try {
			List list = EasyXls.xls2List(
					EquipmentServerApplicationTests.class.getResource("/equipmentMap.xml").getPath(),
					new File(EquipmentServerApplicationTests.class.getResource("/equipment.xls").getPath()));
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
