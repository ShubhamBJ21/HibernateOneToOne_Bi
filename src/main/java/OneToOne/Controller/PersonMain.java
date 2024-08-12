package OneToOne.Controller;

import java.util.List;

import OneToOne.dao.PersonDao;
import OneToOne.dto.AadharCard;
import OneToOne.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		
		AadharCard card1 = new AadharCard();
		card1.setName("Shubham Jadhav");
		card1.setAddress("Satara");
		
		Person person1 = new Person();
		person1.setName("Shubham Jadhav");
		person1.setPhone(8830086429L);
		person1.setAddress("Satara");
		
		person1.setAadharCard(card1);
		card1.setPerson(person1);
		
		PersonDao dao = new PersonDao();
		
//		//dao.savePerson(person1);
  		
//		dao.getPersonDetails(1);

		
		AadharCard card2 = new AadharCard();
		card2.setName("Krishna Kadam");
		card2.setAddress("Nanded");
		
		Person person2 = new Person();
		person2.setName("Krishna Kadam");
		person2.setAddress("Nanded");
		person2.setPhone(9021457863L);
		
		person2.setAadharCard(card2);
		card2.setPerson(person2);
		
		//dao.savePerson(person2);
		
		List<Person> list = dao.getAllPersons();
		
//		for(Person person : list) {
//			System.out.println(person);
//		}
		
		AadharCard card3 = new AadharCard();
		card3.setName("Vaibhav Nagare");
		card3.setAddress("Karamala");
		
		Person person3 = new Person();
		person3.setName("Vaibhav Nagare");
		person3.setAddress("Karmala");
		person3.setPhone(9021457453L);
		
		person3.setAadharCard(card3);
		card3.setPerson(person3);
		
		dao.savePerson(person3);
		
		//dao.deletePerson(3);
	}

}
