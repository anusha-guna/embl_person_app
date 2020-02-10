package embl.Person;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="Person")//Helps to create the Table in H2 database
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String fName;
    private String lName;
    private Integer age;
    public String favColor;
    public ArrayList<String> hobbyList;
   

    // avoid this "No default constructor for entity"
    public Person() {
    }
    //Persons structure to initialize the Person object
    public Person(Long _id, String fName, String lName,Integer pAge,String fColor, ArrayList<String> hobby) {
        this.id = _id;
        this.fName = fName;
        this.lName = lName;
        this.age = pAge;
        this.favColor=fColor;
        this.hobbyList = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fname) {
        this.fName = fname;
    }
    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }
 
    public void setAge(Integer pAge) {
    	this.age=pAge;
    }
    
    public Integer getAge() {
    	return age;
    }
    
    public void setFavColor(String fColor) {
    	this.favColor=fColor;
    }
    
    public String getFavColor() {
    	return favColor;
    }
    
    public void setHobbyList(ArrayList<String> hbyLst) {
    	this.hobbyList = hbyLst;
    }
    public ArrayList<String> getHobbyList() {
    	return hobbyList;
    }
    
    
   

}



