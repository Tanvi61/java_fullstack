package com.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PhysiologicalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int heartRate;
    private double temperature;
    private double sleepHours;

    private LocalDateTime timestamp;

    @ManyToOne
    private User user;

 // getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getSleepHours() {
		return sleepHours;
	}

	public void setSleepHours(double sleepHours) {
		this.sleepHours = sleepHours;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}