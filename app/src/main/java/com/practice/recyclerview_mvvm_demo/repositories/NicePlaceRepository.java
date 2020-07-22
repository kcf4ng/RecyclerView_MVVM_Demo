package com.practice.recyclerview_mvvm_demo.repositories;

import androidx.lifecycle.MutableLiveData;

import com.practice.recyclerview_mvvm_demo.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================================================================
 * File Name：
 * Description：
 * Author： KC Fang.
 * Created Date： 22,July,2020
 * =============================================================================================================
 * Number    Modified Date      User      Description
 * -----------------------------------------------------------------------------------------------------------
 * 00       0000/00/00          kc        TODO
 * =============================================================================================================
 */
public class NicePlaceRepository {
    public static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance(){
        if(instance == null){
            instance = new NicePlaceRepository();
        }
        return  instance;
    }

    //pretend to get data from a webservice of online source;
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setNicePlaces();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return  data;
    }

    private  void setNicePlaces(){
        dataSet.add(new NicePlace("https://i.imgur.com/EmIfg.jpg","Havasu Falls"));

        dataSet.add(new NicePlace("https://i.redd.it/tpsnoz5bzo501.jpg","Trondheim"));

        dataSet.add(new NicePlace("https://i.redd.it/qn7f9oqu7o501.jpg","Portugal"));

        dataSet.add(new NicePlace("https://i.redd.it/j6myfqglup501.jpg","Rocky Mountain National Park"));

        dataSet.add(new NicePlace("https://i.redd.it/0h2gm1ix6p501.jpg","Mahahual"));

        dataSet.add(new NicePlace("https://i.redd.it/k98uzl68eh501.jpg","Frozen Lake"));

        dataSet.add(new NicePlace("https://i.redd.it/glin0nwndo501.jpg","White Sands Desert"));

        dataSet.add(new NicePlace("https://i.redd.it/obx4zydshg601.jpg","Austrailia"));

        dataSet.add(new NicePlace("https://i.imgur.com/ZcLLrkY.jpg","Washington"));
    }

}
