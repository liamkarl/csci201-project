package com.example.demo.payload;

import javax.validation.constraints.NotNull;

public class RemovePostRequest {
	@NotNull
	private Long postID;

	public Long getPostID() {
		return postID;
	}

	public void setPostID(Long postID) {
		this.postID = postID;
	}

}
