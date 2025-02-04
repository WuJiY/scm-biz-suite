
package com.doublechaintech.retailscm.potentialcustomercontactperson;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;

public class PotentialCustomerContactPersonMapper extends BaseRowMapper<PotentialCustomerContactPerson>{

	protected PotentialCustomerContactPerson internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PotentialCustomerContactPerson potentialCustomerContactPerson = getPotentialCustomerContactPerson();
		
 		setId(potentialCustomerContactPerson, rs, rowNumber);
 		setName(potentialCustomerContactPerson, rs, rowNumber);
 		setMobile(potentialCustomerContactPerson, rs, rowNumber);
 		setPotentialCustomer(potentialCustomerContactPerson, rs, rowNumber);
 		setDescription(potentialCustomerContactPerson, rs, rowNumber);
 		setVersion(potentialCustomerContactPerson, rs, rowNumber);

    
		return potentialCustomerContactPerson;
	}

	protected PotentialCustomerContactPerson getPotentialCustomerContactPerson(){
	  PotentialCustomerContactPerson entity = new PotentialCustomerContactPerson();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(PotentialCustomerContactPerson potentialCustomerContactPerson, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PotentialCustomerContactPersonTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomerContactPerson.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(PotentialCustomerContactPerson potentialCustomerContactPerson, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(PotentialCustomerContactPersonTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomerContactPerson.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setMobile(PotentialCustomerContactPerson potentialCustomerContactPerson, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(PotentialCustomerContactPersonTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomerContactPerson.setMobile(mobile);
		}catch (SQLException e){

    }
	}
		
 	protected void setPotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, ResultSet rs, int rowNumber) throws SQLException{
 		String potentialCustomerId;
 		try{
 		  potentialCustomerId = rs.getString(PotentialCustomerContactPersonTable.COLUMN_POTENTIAL_CUSTOMER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( potentialCustomerId == null){
 			return;
 		}
 		if( potentialCustomerId.isEmpty()){
 			return;
 		}
 		PotentialCustomer potentialCustomer = potentialCustomerContactPerson.getPotentialCustomer();
 		if( potentialCustomer != null ){
 			//if the root object 'potentialCustomerContactPerson' already have the property, just set the id for it;
 			potentialCustomer.setId(potentialCustomerId);

 			return;
 		}
 		potentialCustomerContactPerson.setPotentialCustomer(createEmptyPotentialCustomer(potentialCustomerId));
 	}
 	
	protected void setDescription(PotentialCustomerContactPerson potentialCustomerContactPerson, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(PotentialCustomerContactPersonTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomerContactPerson.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(PotentialCustomerContactPerson potentialCustomerContactPerson, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PotentialCustomerContactPersonTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomerContactPerson.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected PotentialCustomer  createEmptyPotentialCustomer(String potentialCustomerId){
 		PotentialCustomer potentialCustomer = new PotentialCustomer();
 		potentialCustomer.setId(potentialCustomerId);
 		potentialCustomer.setVersion(Integer.MAX_VALUE);
 		return potentialCustomer;
 	}
 	
}


