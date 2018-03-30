package com.example.administrator.data_binding.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.data_binding.R;
import com.example.administrator.data_binding.bean.TeacherBean;
import com.example.administrator.data_binding.databinding.ActivityMain2Binding;
import com.example.administrator.data_binding.databinding.ActivityMainBinding;
import com.example.administrator.data_binding.util.retrofit.ApiService;
import com.example.administrator.data_binding.util.retrofit.RetrofitFactory;
import com.example.administrator.data_binding.util.retrofit.base.BaseBean;
import com.example.administrator.data_binding.util.retrofit.base.BaseObserver;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        RetrofitFactory.getInstance().getRetrofit().create(ApiService.class).getTeachers(1, 5)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<TeacherBean>>() {
                    @Override
                    protected void onSuccees(BaseBean<List<TeacherBean>> t) throws Exception {
                        binding.setTeacher(t.getObject().get(0));
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });
    }
}
