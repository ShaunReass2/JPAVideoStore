package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name="address_id")
	private Address address; 
	
	@OneToMany(mappedBy="store")
	private List<Customer> customers; 
	
	@OneToMany(mappedBy = "store")
	List<InventoryItem> inventoryItems; 
	


	public Store() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	@OneToMany(mappedBy="store")
	private List<Staff> staffs; 

	

	@OneToOne
	@JoinColumn(name="manager_id")
	private Staff manager; 
	



		// Store.java
		// lab #4
		public void addCustomer(Customer customer) {
			if (customers == null) {
				customers = new ArrayList<>();
			}
			if (!customers.contains(customer)) {
				customers.add(customer);
				if (customer.getStore() != null) {
					customer.getStore().getCustomers().remove(customer);
				}
				customer.setStore(this);
			}
		}
		public void removeCustomer(Customer customer) {
			customer.setStore(null);
			if (customers != null) {
				customers.remove(customer);
			}
		}
		
		public List<Staff> getStaffs() {
			return staffs;
		}


		public void setStaffs(List<Staff> staffs) {
			this.staffs = staffs;
		}
		
		public Staff getManager() {
			return manager;
		}


		public void setManager(Staff manager) {
			this.manager = manager;
		}

	public List<InventoryItem> getInventoryItems() {
			return inventoryItems;
		}


		public void setInventoryItems(List<InventoryItem> inventoryItems) {
			this.inventoryItems = inventoryItems;
		}


	@Override
	public String toString() {
		return "Store [id=" + id + ", address=" + address + "]";
	}

	
}
