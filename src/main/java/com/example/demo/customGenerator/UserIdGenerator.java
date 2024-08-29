package com.example.demo.customGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

public class UserIdGenerator implements IdentifierGenerator {

	private static final String prefix="olp";
	private String suffix;
	
	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
//        prefix = params.getProperty("prefix");
//        numberFormat = params.getProperty("numberFormat");
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		session.createQuery("SELECT COUNT(e) FROM User e", Long.class).uniqueResult();
	
		try(Connection con=session.getJdbcConnectionAccess().obtainConnection()){
	
			System.out.println(object.getClass().getName());
			String sql="select user_id from user order by user_id desc limit 1";
			ResultSet rs = con.createStatement().executeQuery(sql);
	
			if (rs.next()) {
				System.out.println("Rs not Empty");
				Integer.toString(rs.getInt(1));
				suffix=String.valueOf(1);
			}
			else {
	System.out.println("Rs Empty");
				suffix=String.valueOf(1);
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return prefix + suffix;
	}
}
