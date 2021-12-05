package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ImageTable")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long imageID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post")
	private Post post;

	private String url;

	public Image(Post post, String url) {
		this.url = url;
	}

	public long getImageID() {
		return imageID;
	}

	public void setImageID(long imageID) {
		this.imageID = imageID;
	}

	public String getURL() {
		return this.url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
