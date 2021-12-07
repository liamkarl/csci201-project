package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ImageTable")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(nullable = false, updatable = false)
	private long imageID = Long.valueOf(0);

	private String url;

//	@ManyToOne
//	@JoinColumn(name = "postID")
//	private Post post;

//	@Autowired
//	private ImageRepository imageRepo;

	public Image() {
		// this.post = new Post();
		this.url = "";
	}

	public Image(String url) {
		super();
		// this.post = post;
		this.url = url;
	}

	// getters/setters

	public long getImageID() {
		return imageID;
	}

	public void setImageID(Long imageID) {
		this.imageID = imageID;
	}

//	public Post getPost() {
//		return post;
//	}
//
//	public void setPost(Post post) {
//		this.post = post;
//	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}