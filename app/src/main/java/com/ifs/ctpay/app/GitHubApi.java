package com.ifs.ctpay.app;


import com.ifs.ctpay.model.entity.Repository;
import com.ifs.ctpay.model.entity.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface GitHubApi {
	Integer PAGE_SIZE = 50;

	@GET("/user")
    Observable<User> signIn(@Header("Authorization") String token);

	@GET("/users/{login}/repos")
    Observable<List<Repository>> getUserRepos(@Path("login") String login, @Query("page") int page, @Query("per_page") int pageSize);
}
