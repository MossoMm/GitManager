package com.example.androidappbuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserInterface {

    @GET("/repos/{owner}/{repo}/branches/{branch}")
    Call<BranchCommit> requestCommit(@Path("owner") String owner, @Path("repo") String repo, @Path("branch") String branch);


    @POST("/repos/{owner}/{repo}/pulls")
    Call<ResponsePost> postPull(@Body RequestPost requestPost);

}
