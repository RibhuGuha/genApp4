package com.apps.test.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.apps.test.model.Trips;
import com.apps.test.model.Person;

@Entity(name = "PersonTrip")
@Table(schema = "\"testing\"", name = "\"PersonTrip\"")
@Data
public class PersonTrip{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"UserName\"")
	private String userName;

    
    @Column(name = "\"TripId\"")
    private Integer tripId;
 
}