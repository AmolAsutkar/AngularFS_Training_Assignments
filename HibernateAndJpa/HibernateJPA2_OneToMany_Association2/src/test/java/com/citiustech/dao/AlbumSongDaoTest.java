package com.citiustech.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.citiustech.entity.Album;
import com.citiustech.entity.Song;

class AlbumSongDaoTest {

	@Test
	public void fetchAllSongsByArtistName() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Song> list=asd.findSongsByArtist("kakkar");
		list.forEach(System.out::println);

	}
	@Test
	public void fetchAllSongsByArtistNameusingCriteria() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Song> list=asd.findSongsByArtisusingCriteriat("kakkar");
		list.forEach(System.out::println);

	}
	
	@Test
	public void fetchAlbumByReleaseDate() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Album> list=asd.findAlbumByReleaseYear(2022);
		list.forEach(System.out::println);

	}
	
	@Test
	public void fetchAlbumByArtistName() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Album> list=asd.findAlbumByArtist("kakkar");
		list.forEach(System.out::println);

	}
	
	@Test
	public void fetchAlbumByArtistNameUsingCriteria() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Album> list=asd.findAlbumByArtist("kakkar");
		list.forEach(System.out::println);

	}
    
	@Test
	public void fetchSongByCopyright() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Song> list=asd.findSongByCopyright("sony");
		list.forEach(System.out::println);

	}
	
	@Test
	public void fetchAllSongsInfoTest() {
		AlbumSongDao asd=new AlbumSongDao();
		List<Object[]> list=asd.findAllSongsInfo();
		list.forEach(arr -> System.out.println(Arrays.toString(arr)));

	}
}
