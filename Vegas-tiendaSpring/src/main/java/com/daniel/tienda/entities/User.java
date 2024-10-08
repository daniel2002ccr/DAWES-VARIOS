package com.daniel.tienda.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;



	
	@Entity
	@Table(name="users")
	public class User {
		
		@Id
		@GeneratedValue
		@Column(name="user_id")
		private Integer id;
		
		@Column(name="user_name")
		private String name;
		
		@Column(name="user_passwd")
		private String password;
		
		@Column(name="user_email")
		private String email;
		
		@ElementCollection(fetch= FetchType.EAGER)
		@CollectionTable(
				name="roles",
				joinColumns = @JoinColumn(name="user_id")
				)
		@Column(name="user_role")
		private List<String> roles;

		public User(Integer id, String name, String password, String email, List<String> roles) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.email = email;
			this.roles = roles;
		}

		public User() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<String> getRoles() {
			return roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		
		
		
		
	}