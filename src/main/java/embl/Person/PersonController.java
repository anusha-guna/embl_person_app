
package embl.Person;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class PersonController {

	/**
	 * @param args
	 */
	//Get mapping is used to receive the Get request and returns the Persons JSON to client
	@Autowired
    private PersonRepo repository;
	@GetMapping("/persons")
    Map<String,Person> findAll() {
		Map json=new HashMap();
		try {
			
	    	json.put("persons", repository.findAll());
	        
		}catch(Exception e) {
			
		}
		return json;
    } 
	
	

	
	@RequestMapping(method = RequestMethod.POST, value="/persons")
	@ResponseBody
	//to handle multiple person JSON input
	Map<String,Person> newPersonList(@RequestBody List<Person> people) {
		Map json=new HashMap();
		json.put("persons", repository.saveAll(people));
        return json;
    }
	
	//Get person with Id method
	@GetMapping("/persons/{id}")
	Map<String,Person> findUser(@PathVariable Long id) {
		Optional<Person> person=repository.findById(id);
		if(!person.isPresent()) {
			throw new UserNotFoundException(id);
		}

		Map json=new HashMap();
		json.put("persons",repository.findById(id));
		return json;


	}
	
	// Save or update
    @PutMapping("/persons/{id}")
    Map<String,Person> saveOrUpdate(@RequestBody Person newUser, @PathVariable Long id) {
    	Map<String,Person> json=new HashMap();
    	return repository.findById(id)
    			.map(x -> {
    				if(newUser.getFName()!=null && !newUser.getFName().isEmpty()) {
    					x.setFName(newUser.getFName());
    				}
    				if(newUser.getLastName()!=null && !newUser.getLastName().isEmpty()) {
    					x.setLastName(newUser.getLastName());
    				}
    				if(newUser.getFavColor()!=null && !newUser.getFavColor().isEmpty()) {
    					x.setFavColor(newUser.getFavColor());
    				}
    				if(newUser.getAge()!=null && !newUser.getAge().toString().isEmpty()) {
    					x.setAge(newUser.getAge());
    				}
    				if(newUser.getHobbyList()!=null && newUser.getHobbyList().size()>0) {
    					Object l=newUser.getHobbyList().size();
    					x.setHobbyList(newUser.getHobbyList());
    				}
    				json.put("persons",repository.save(x));
    				return json;
    			})
    			.orElseGet(() -> {
    				throw new UserNotFoundException(id);
    			});
    }
    
    @ResponseStatus
    @ResponseBody
    @DeleteMapping("/persons/{id}")
    ResponseEntity deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
        //returns the delete message
        return new ResponseEntity<>(new CustomMessage("Deleted Successfully"),
                HttpStatus.OK);
        
       
    }
    
    
	
}
