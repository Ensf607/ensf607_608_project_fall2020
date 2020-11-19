package server.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class JDBCTest {

	@Test
	void test() throws SQLException {
		
		JDBC t= new JDBC();
		ResultSet f=t.checkInventory();
		
		while (f.next()) {
			System.out.println(f.getString(1)+ " "+f.getString(2));
		}
		//t.purchase(1000, 2, 1);
		fail("Not yet implemented");
	}

}
