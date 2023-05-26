package com.jumpstart.store.dto;

public class UserDto {
	
		  private long id;

		  private String name;

		  private String email;
		  
		  private String role;
		  
		  private String address;
		  
		  private String phone;
		  
		  private String imageUrl;

		

		public UserDto(long id, String name, String email, String role, String address, String phone, String imageUrl) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.role = role;
			this.address = address;
			this.phone = phone;
			this.imageUrl = imageUrl;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

}