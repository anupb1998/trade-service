package com.db.trade;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class TradeServiceApplicationTest {
	@Autowired
	ApplicationContext appContect;

	@Test
	void contextTest() {
		assertNotNull(appContect);
	}

}
