package connectionDB;

import java.sql.Date;
import java.sql.Time;

public class Seance {
	private int id;
    private int udln;
    private String country;
    private String town;
    private String theatre;
    private String cinema_hall;
    private Date date_seance;
    private Time time_seance;
    private String film_name;
    private int number_chair;
    private int cost_chair;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUdln() {
		return udln;
	}
	public void setUdln(int udln) {
		this.udln = udln;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getTheatre() {
		return theatre;
	}
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	public String getCinema_hall() {
		return cinema_hall;
	}
	public void setCinema_hall(String cinema_hall) {
		this.cinema_hall = cinema_hall;
	}
	public Date getDate_seance() {
		return date_seance;
	}
	public void setDate_seance(Date date_seance) {
		this.date_seance = date_seance;
	}
	public Time getTime_seance() {
		return time_seance;
	}
	public void setTime_seance(Time time_seance) {
		this.time_seance = time_seance;
	}
	public String getFilm_name() {
		return film_name;
	}
	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}
	public int getNumber_chair() {
		return number_chair;
	}
	public void setNumber_chair(int number_chair) {
		this.number_chair = number_chair;
	}
	public int getCost_chair() {
		return cost_chair;
	}
	public void setCost_chair(int cost_chair) {
		this.cost_chair = cost_chair;
	}

}
