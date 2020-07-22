package com.practice.recyclerview_mvvm_demo.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.practice.recyclerview_mvvm_demo.models.NicePlace;
import com.practice.recyclerview_mvvm_demo.repositories.NicePlaceRepository;

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
public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlaces;
    private NicePlaceRepository mRepo ;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mNicePlaces != null){
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public void addNewValues(final NicePlace nicePlace){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(nicePlace);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();


    }

    public LiveData<List<NicePlace>> getNicePlaces(){
        return mNicePlaces;
    }

    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }

}
