package com.citiustech.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Album")
@NamedQuery(
		name="albumbyreleaseyear",
		query= "select al from Album al where year(al.release_Date)= :yr"
		)

public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int album_id;
	private String album_Name;
	private LocalDate release_Date;
	private String copyright;
	
	@OneToMany(mappedBy = "album",cascade = CascadeType.ALL)
	private List<Song> songs;
	
	
	@Override
	public String toString() {
		return "Album [album_id=" + album_id + ", album_Name=" + album_Name + ", release_Date=" + release_Date
				+ ", copyright=" + copyright + "]";
	}

	
	
	
	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_Name() {
		return album_Name;
	}

	public void setAlbum_Name(String album_Name) {
		this.album_Name = album_Name;
	}

	public LocalDate getRelease_Date() {
		return release_Date;
	}

	public void setRelease_Date(LocalDate release_Date) {
		this.release_Date = release_Date;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	

}
