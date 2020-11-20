package server.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

class JDBCTest {

	@Test
	void test() throws SQLException {
		
		JDBC t= new JDBC();
		try {
			String g=t.getSuppliersList();
			System.out.println(g);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//t.purchase(1000, 2, 1);
		fail("Not yet implemented");
	}

}
