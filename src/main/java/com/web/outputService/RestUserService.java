package com.web.outputService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.http.MediaType;

import com.web.pojo.User;

/**
 * restful webservice服务类
 * @author liling
 *
 */
public interface RestUserService {
  
  @Path("/user/")
  @POST
  @Consumes(MediaType.APPLICATION_JSON_VALUE)
  Response addUser(User user);
  
  @Path("/user/{id}/")
  @DELETE
  Response delUser(@PathParam("id") String id);
  
  @Path("/user/")
  @PUT
  Response updateUser(User user);
  
  @Path("/user/{id}/")
  @GET
  @Produces(MediaType.APPLICATION_JSON_VALUE)//返回json数据格式
  User getUserById(@PathParam("id") String id);
  
  @Path("/users/")
  @GET
  @Produces(MediaType.APPLICATION_JSON_VALUE)//返回json数据格式
  List<User> findAllUsers();
}