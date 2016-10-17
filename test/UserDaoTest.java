import java.util.Date;

import org.sql2o.Connection;

import pl.org.odnowa.dao.UserDAO;
import pl.org.odnowa.model.User;

public class UserDaoTest {

	static public void main(String[] args) {
		User user = new User();
		user.setId("");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setEmail("email");
		user.setStreet("street");
		user.setHouseNumber("houseNumber");
		user.setFlatNumber("flatNumber");
		user.setPostCode("postCode");
		user.setTown("town");
		user.setPesel("pesel");
		user.setTelephone("telephone");
		user.setExpectations("expectations");
		user.setCommunity("community");
		user.setConferences(new String[]{"conferences"});
		user.setSource1(new String[]{"source1"});
		user.setSource2("source2");
		user.setNotes("notes");
		user.setDate(new Date());

		String insert = String.format("INSERT INTO %s (%s) " + "VALUES (%s)", user.getDBTableName(),
				user.getDBColumnIdentifiersAsString(), user.getDBColumnParametersAsString());
		
		System.out.println(insert);
		
		System.out.println(user.getDBColumnIdentifiers());
		System.out.println(user.getDBColumnIdentifiersAsString());
		System.out.println(user.getDBColumnParametersAsString());
		System.out.println(user.getValues());
	}

}
