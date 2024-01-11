package com.apps.test.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.apps.test.model.Trips;
import com.apps.test.model.Person;
import com.apps.test.converter.DurationConverter;
import com.apps.test.converter.UUIDToByteConverter;
import com.apps.test.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Person")
@Table(name = "\"Person\"", schema =  "\"testing\"")
@Data
                        
public class Person {
	public Person () {   
  }
	  
  @Id
  @Column(name = "\"UserName\"", nullable = true )
  private String userName;
	  
  @Column(name = "\"FirstName\"", nullable = true )
  private String firstName;
  
	  
  @Column(name = "\"LastName\"", nullable = true )
  private String lastName;
  
	  
  @Column(name = "\"Income\"", nullable = true )
  private Double income;
  
	  
  @Column(name = "\"DateOfBirth\"", nullable = true )
  @Temporal(value = TemporalType.DATE)
  private Date dateOfBirth;  
  
	  
  @Column(name = "\"MiddleName\"", nullable = true )
  private String middleName;
  
	  
  @Column(name = "\"Gender\"", nullable = true )
  private String gender;
  
	  
  @Column(name = "\"Age\"", nullable = true )
  private Integer age;
  
	  
  @Column(name = "\"HomeAddress\"", nullable = true )
  private String homeAddress;
  
  
  
  
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"PersonTrip\"",
            joinColumns = @JoinColumn( name="\"UserName\""),
            inverseJoinColumns = @JoinColumn( name="\"TripId\""), schema = "\"testing\"")
private List<Trips> trip = new ArrayList<>();
  
  
  
  
  
  
  
	@OneToOne(fetch = FetchType.LAZY, cascade = {})
@JoinColumn(name = "\"PersonBestFriend\"", referencedColumnName = "\"UserName\"", insertable = false, updatable = false)
private Person bestFriend;

@Column(name =  "\"PersonBestFriend\"")
private String personBestFriend;
  
	
@JoinTable(
          name="\"PersonFriends\"",
          joinColumns = @JoinColumn( name="\"UserName\""),
          inverseJoinColumns = @JoinColumn(name = "\"UserName\""), schema = "\"Transport\"")
private List<Person> friends = new ArrayList<>();
  
  @Override
  public String toString() {
	return "Person [" 
  + "UserName= " + userName  + ", " 
  + "FirstName= " + firstName  + ", " 
  + "LastName= " + lastName  + ", " 
  + "Income= " + income  + ", " 
  + "DateOfBirth= " + dateOfBirth  + ", " 
  + "MiddleName= " + middleName  + ", " 
  + "Gender= " + gender  + ", " 
  + "Age= " + age  + ", " 
  + "HomeAddress= " + homeAddress 
 + "]";
	}
	
}