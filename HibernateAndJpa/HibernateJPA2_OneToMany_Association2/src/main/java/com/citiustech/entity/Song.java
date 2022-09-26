package com.citiustech.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="song")
public class Song {
	
	
	@Override
	public String toString() {
		return "Song [song_id=" + song_id + ", title=" + title + ", artist=" + artist + ", duration=" + duration + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int song_id;
	private String title;
	private String artist;
	private double duration;
	
	@JoinColumn(name="Albumid_fkey")  // foreign key mapping
    @ManyToOne
	Album album;
	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	


}
