package com.robosoft.searcher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photos_videos")
public class PhotosAndVideos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
    
    @Column(name = "description")
	private String Description;
    
	@Column(nullable = true, length = 64, name="photo")
	private String photo;
	
	@Column(name = "video")
	private String video;
	
	@Column(name = "photo_owner_name")
	private String photoOwnerName;
	
	@Column(name = "video_owner_name")
	private String videoOwnerName;
	
	public PhotosAndVideos() {
		super();
	}

	public PhotosAndVideos(long id, String description, String photo, String video, String photoOwnerName,
			String videoOwnerName) {
		super();
		this.id = id;
		Description = description;
		this.photo = photo;
		this.video = video;
		this.photoOwnerName = photoOwnerName;
		this.videoOwnerName = videoOwnerName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getPhotoOwnerName() {
		return photoOwnerName;
	}

	public void setPhotoOwnerName(String photoOwnerName) {
		this.photoOwnerName = photoOwnerName;
	}

	public String getVideoOwnerName() {
		return videoOwnerName;
	}

	public void setVideoOwnerName(String videoOwnerName) {
		this.videoOwnerName = videoOwnerName;
	}
}