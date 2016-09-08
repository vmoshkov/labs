package ru.vm.berryville.j2eewebix;
// Generated 30.06.2016 14:46:07 by Hibernate Tools 4.3.1.Final

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Car generated by hbm2java
 */
@Entity
@Table(name = "car", catalog = "carsdeskdb")
public class Car implements java.io.Serializable {

	private Integer id;
	private Manufacturer manufacturer;
	private LocalDate entryDate;
	private String model;
	private int year;
	private String description;
	private double prise;
	private String contactPerson;
	private String contactPhone;
	private Set<Image> images = new HashSet<Image>(0);

	public Car() {
	}

	public Car(Manufacturer manufacturer, LocalDate entryDate, String model, int year, String description, double prise,
			String contactPerson, String contactPhone) {
		this.manufacturer = manufacturer;
		this.entryDate = entryDate;
		this.model = model;
		this.year = year;
		this.description = description;
		this.prise = prise;
		this.contactPerson = contactPerson;
		this.contactPhone = contactPhone;
	}

	public Car(Manufacturer manufacturer, LocalDate entryDate, String model, int year, String description, double prise,
			String contactPerson, String contactPhone, Set<Image> images) {
		this.manufacturer = manufacturer;
		this.entryDate = entryDate;
		this.model = model;
		this.year = year;
		this.description = description;
		this.prise = prise;
		this.contactPerson = contactPerson;
		this.contactPhone = contactPhone;
		this.images = images;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id", nullable = false)
	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	@Column(name = "entry_date", nullable = false, length = 10)
	public LocalDate getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "model", nullable = false)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "car_year", nullable = false)
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "prise", nullable = false, precision = 22, scale = 0)
	public double getPrise() {
		return this.prise;
	}

	public void setPrise(double prise) {
		this.prise = prise;
	}

	@Column(name = "contact_person", nullable = false)
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Column(name = "contact_phone", nullable = false)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CAR_ID", nullable = false)
	@JoinTable(
            name="CAR_IMAGE ",
            joinColumns = @JoinColumn( name="CAR_ID"),
            inverseJoinColumns = @JoinColumn( name="images_id")
    )
	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

public String toString()
	{
		return "Car[" + id + "; " + entryDate + "; " + model + "; " + manufacturer.getName() + "; " +
				description.toString() + "; " + prise + "; " + contactPerson + "; " + contactPhone + "]";
				
	}

}
