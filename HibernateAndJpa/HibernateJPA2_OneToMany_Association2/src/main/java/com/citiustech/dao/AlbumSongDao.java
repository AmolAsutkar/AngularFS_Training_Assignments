package com.citiustech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import com.citiustech.entity.Album;
import com.citiustech.entity.Song;

public class AlbumSongDao extends GenericDao{

	public List<Album> findAlbumByReleaseYear(int year){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				.createNamedQuery("albumbyreleaseyear",Album.class)
				//.createQuery("select al from Album al where year(al.release_Date)=:rdst",Album.class)    //JPQL query is independent of database
				.setParameter("yr", year)
				.getResultList();		
	}
	
	public List<Song> findSongsByArtist(String artist){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				.createQuery("select s from Song s where s.artist=:ast",Song.class)    //JPQL query is independent of database
				.setParameter("ast", artist)
				.getResultList();
		
	}
	
	public List<Song> findSongsByArtisusingCriteriat(String artist){
		
		EntityManager em=entitymanagerfactory.createEntityManager();
		CriteriaBuilder cb=em.getCriteriaBuilder();		
		CriteriaQuery<Song> criteria=cb.createQuery(Song.class);
		Root<Song> song = criteria.from(Song.class);
		criteria.select(song);
		criteria.where(cb.equal(song.get("artist"), artist));
		
		List<Song> list=em.createQuery(criteria).getResultList();
		return list;
				
	
		
	}
	
	public List<Album> findAlbumByArtist(String artist){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				.createQuery("select al from Album al inner join al.songs s where s.artist=:ast",Album.class)    //JPQL query is independent of database
				.setParameter("ast", artist)
				.getResultList();
		
	}
	
	public List<Album> findAlbumByArtistUsingCriteria(String artist){
		EntityManager em=entitymanagerfactory.createEntityManager();
		CriteriaBuilder cb=em.getCriteriaBuilder();		
		CriteriaQuery<Album> criteria=cb.createQuery(Album.class);
		Root<Album> album = criteria.from(Album.class);
		criteria.select(album);
        Join<Album, Song> songs = album.join("songs",JoinType.INNER);
		criteria.where(cb.equal(songs.get("artist"), artist));
		
		List<Album> list=em.createQuery(criteria).getResultList();
		return list;
	}
	
	public List<Song> findSongByCopyright(String copyright){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class
				//.createQuery("select s from Song s where s.album.copyright=:cright",Song.class)    //JPQL query is independent of database

				.createQuery("select s from Song s inner join s.album al where al.copyright=:cright",Song.class)    //JPQL query is independent of database
				.setParameter("cright", copyright)
				.getResultList();
		
	}
	
	public List<Object[]> findAllSongsInfo(){
		return entitymanagerfactory
				.createEntityManager()    // warning goes away when adding Customer.class

				.createQuery("select s.title, s.artist, al.album_Name from Song s inner join s.album al",Object[].class)    //JPQL query is independent of database
				.getResultList();
		
	}
}
