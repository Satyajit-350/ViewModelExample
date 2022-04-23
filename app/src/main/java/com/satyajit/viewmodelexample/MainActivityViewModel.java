package com.satyajit.viewmodelexample;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.satyajit.viewmodelexample.Retrofit.HeroApi;
import com.satyajit.viewmodelexample.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Hero>> heroList;

    //recreation of data is done here
    public LiveData<List<Hero>> getHeroes(){
        if(heroList==null){
            heroList = new MutableLiveData<>();

            loadheroes();
        }
        return heroList;
    }

    private void loadheroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HeroApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HeroApi heroApi = retrofit.create(HeroApi.class);

        Call<List<Hero>> call = heroApi.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }
}
