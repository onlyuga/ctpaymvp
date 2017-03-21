package com.ifs.ctpay.app;


import com.ifs.ctpay.model.entity.Repository;
import com.ifs.ctpay.model.entity.User;

import java.util.List;

import rx.Observable;


public class GitHubService {

	private GitHubApi mApi;

	public GitHubService(GitHubApi githubApi) {
		mApi = githubApi;
	}

	public Observable<User> signIn(String token) {
		return mApi.signIn(token);
	}

	public Observable<List<Repository>> getUserRepos(String user, int page, Integer pageSize) {
		return mApi.getUserRepos(user, page, pageSize);
	}
}
