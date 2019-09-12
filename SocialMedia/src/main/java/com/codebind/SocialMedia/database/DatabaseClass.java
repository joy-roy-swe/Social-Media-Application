package com.codebind.SocialMedia.database;

import java.util.HashMap;
import java.util.Map;

import com.codebind.SocialMedia.model.Post;
import com.codebind.SocialMedia.model.Profile;

public class DatabaseClass {

	private static Map<Long, Post> post = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();
	
	public static Map<Long, Post> getPosts(){
		return post;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profile;
	}
	
}
