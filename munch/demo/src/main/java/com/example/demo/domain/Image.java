package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ImageTable")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long imageID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post")
	private Post post;

	private String url;

	public Image() {
		super();

		this.post = new Post();
		this.url = "";
	}

	public Image(Post post, String url) {
		super();
		this.post = post;
		this.url = url;
	}

	// getters/setters

	public long getImageID() {
		return imageID;
	}

	public void setImageID(long imageID) {
		this.imageID = imageID;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
