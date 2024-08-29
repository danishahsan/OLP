package com.example.demo.entity;

import java.security.Timestamp;


import com.example.demo.utility.PaymentMethod;
import com.example.demo.utility.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Payment {
	
	@Id
	private String id;
	@OneToOne
	private Enrollment enrollment;
	private String paymentReference;
	private Timestamp paymentDate;
	private Double amount;
	private PaymentMethod paymentMethod;
	private PaymentStatus paymentStatus;
	private Timestamp createdAt ;
	private Timestamp updatedAt ;

}
