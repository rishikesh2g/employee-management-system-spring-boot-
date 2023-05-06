package net.javaguides.springboot.dto;
import java.time.LocalDate;

public class UserRegistrationDto {
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    
    public UserRegistrationDto() {
        
    }
    
    public UserRegistrationDto(Long id, String firstName, String lastName, String email, String password, String address, LocalDate dateOfBirth, LocalDate joiningDate) {
        this.id=id;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.joiningDate = joiningDate;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public LocalDate getDateOfJoining() {
        return joiningDate;
    }
    
    public void setDateOfJoining(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
}
