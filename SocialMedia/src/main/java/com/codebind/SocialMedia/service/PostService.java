package com.codebind.SocialMedia.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.codebind.SocialMedia.database.DatabaseClass;
import com.codebind.SocialMedia.model.Post;

public class PostService {
	
	private Map<Long, Post> posts = DatabaseClass.getPosts();
	
	public PostService() {
		posts.put(1L, new Post(1, "Hello world","Joy"));
		posts.put(2L, new Post(2, "Hello jersey","Joy"));
		posts.put(3L, new Post(3, "Hello REST_API","Joy"));
	}
	
	public List<Post> getAllPostsForYear(int year){
		List<Post> postsForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Post post : posts.values()) {
			cal.setTime(post.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				postsForYear.add(post);
			}
		}
		return postsForYear;
	}
	
	public List<Post> getAllPostsPaginated(int start, int size){
		ArrayList<Post> list = new ArrayList<>();
		if(start + size > list.size()) {
			return new ArrayList<Post>();
		}
		return list.subList(start, start+size);
	}
	
	public List<Post> getAllPost(){
		return new ArrayList<Post>(posts.values());
	}
	
	public Post getPost(long id) {
		return posts.get(id);
	}

	public Post addPost(Post post) {
		post.setId(posts.size() + 1);
		posts.put(post.getId(),post);
		return post;
	}
	
	public Post updatePost(Post post) {
		if(post.getId() <= 0) {
			return null;
		}
		posts.put(post.getId(),post);
		return post;
	}
	
	public Post removeMessage(long id) {
		return posts.remove(id);
	}
}
