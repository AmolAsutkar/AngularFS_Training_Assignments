package com.citiustech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.dao.GenericDao;
import com.citiustech.entity.Album;
import com.citiustech.entity.Song;

class AlbumSongTest {

	@Test
	public void addinganAlbum() {
		
		Album album=new Album();
		album.setAlbum_Name("reddy");
		album.setCopyright("zee music");
		album.setRelease_Date(LocalDate.of(2020, 10, 12));
		
		GenericDao gdao=new GenericDao();
		gdao.save(album);
		}
	
	@Test
	public void addingSongtoanAlbum() {
		
		Song  song=new Song();
		GenericDao gdao=new GenericDao();

		Album alb=gdao.findById(Album.class, 3);
		song.setTitle("Good for U");
		song.setArtist("kakkar");
		song.setDuration(3.56);
		song.setAlbum(alb);
		gdao.save(song);
		}

	
	@Test
	public void addingAlbumAlongWithSong() {
		
		GenericDao gdao=new GenericDao();
        Album album=new Album();
		album.setAlbum_Name("Bollywood olds");
		album.setCopyright("sony");
		album.setRelease_Date(LocalDate.of(2022,02,15));
		
		
		Song  song3=new Song();
		song3.setTitle("90s");
		song3.setArtist("pankaj udas");
		song3.setDuration(4.56);
		song3.setAlbum(album);

		Song  song1=new Song();
		song1.setTitle("70s");
		song1.setArtist("ithias");
		song1.setDuration(5.56);
		song1.setAlbum(album);
		
		Song  song2=new Song();
		song2.setTitle("20s");
		song2.setArtist("nam tera");
		song2.setDuration(6.56);
		song2.setAlbum(album);
		
		List<Song> song = new ArrayList<>();
		song.add(song2);
		song.add(song1);
		song.add(song3);
		album.setSongs(song);
		gdao.save(album);
		}
}
