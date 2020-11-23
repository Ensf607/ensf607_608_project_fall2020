package client.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ViewControllerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testViewController() {
		ModelController mc =new ModelController();
		ViewController vc =new ViewController(mc);
	}

}
