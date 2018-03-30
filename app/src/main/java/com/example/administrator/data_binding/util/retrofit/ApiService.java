package com.example.administrator.data_binding.util.retrofit;



import com.example.administrator.data_binding.bean.TeacherBean;
import com.example.administrator.data_binding.util.retrofit.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/3/14.
 */

public interface ApiService {

    @GET("Teacher")
    Observable<BaseBean<TeacherBean>> getTeacher(@Query("id") String id);

    @GET("LatestTeachers")
    Observable <BaseBean<List<TeacherBean>>> getTeachers(@Query("start") int start, @Query("end") int end);
}
