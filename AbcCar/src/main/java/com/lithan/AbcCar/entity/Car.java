package com.lithan.AbcCar.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userID")
	private UserAccount userId;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "registration")
	private String registration;

	@Column(name = "price")
	private String price;

	@Column(name = "image")
	private String image;

	@Column(name = "file_path")
	private String filePath;

	@Column(name = "file_type")
	private String fileType;

	@Column(name = "file_size")
	private String fileSize;

	@OneToMany(mappedBy = "car", orphanRemoval = true)
	private Set<CarBidding> biddings = new HashSet<CarBidding>();

	@Column(name = "status")
	private String status;

	public Car() {
	}

	public Car(Long id, UserAccount userId, String make, String model, String registration, String price, String image,
			String filePath, String fileType, String fileSize, Set<CarBidding> biddings) {
		super();
		this.id = id;
		this.userId = userId;
		this.make = make;
		this.model = model;
		this.registration = registration;
		this.price = price;
		this.image = image;
		this.filePath = filePath;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.biddings = biddings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserAccount getUserId() {
		return userId;
	}

	public void setUserId(UserAccount userId) {
		this.userId = userId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<CarBidding> getBiddings() {
		return biddings;
	}

	public void setBiddings(Set<CarBidding> biddings) {
		this.biddings = biddings;
	}

}
