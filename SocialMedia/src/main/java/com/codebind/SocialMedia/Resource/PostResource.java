package com.codebind.SocialMedia.Resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codebind.SocialMedia.Resource.Bean.PostFilterBean;
import com.codebind.SocialMedia.model.Post;
import com.codebind.SocialMedia.service.PostService;

@Path("/post")
public class PostResource {
	
	PostService post_service = new PostService();
	
	//To get all post at a time
	@GET
	@Path("/newsfeed")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getAllPosts(){
		return post_service.getAllPost();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPost(@BeanParam PostFilterBean filterBean) {
		if(filterBean.getYear()>0) {
			return post_service.getAllPostsForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0) {
			return post_service.getAllPostsPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return post_service.getAllPost();
	}

	// search post using post id
	@GET
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Post getPost(@PathParam("postId") Long id) {
		return post_service.getPost(id);
	}
	
	// add a post
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post addPost(Post post) {
		return post_service.addPost(post);
	}
	
	
	// update the post
	@PUT
	@Path("/{postId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post updatePost(@PathParam("postId") Long id, Post post) {
		post.setId(id);
		return post_service.updatePost(post);
	}
	
	// delete a post
	@DELETE
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePost(@PathParam("postId") Long id) {
		post_service.removeMessage(id);
	}
	
	
	
	
	
}
