package com.upgrad.bookmyconsultation.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

//mark this class as an 'entity class'
//Use Data annotation to generate boilerplate code
//Use NoArgsConstructor annotation
//create a class name Rating
	//create a primary key called 'id' of type String
	//initialise id with a UUID using UUID.randomUUID
	//create appointmentId of type String
	//create doctorId of type String
	//create rating of type Integer
	//create comments of type String
	//Set access modifiers for all these members to 'private'
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {
    @Id
    private String id=UUID.randomUUID().toString();
    @Column(name="appointment_id")
    private String appointmentId;
    @Column(name="doctor_id")
    private String doctorId;
    @Column(name="rating")
    private int rating;
    @Column(name="comments")
    private String comments;
}
/* DB Table
`id` varchar(255) NOT NULL,
  `appointment_id` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `doctor_id` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
*/
