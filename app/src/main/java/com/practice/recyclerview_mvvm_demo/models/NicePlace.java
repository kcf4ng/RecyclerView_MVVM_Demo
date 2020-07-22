package com.practice.recyclerview_mvvm_demo.models;

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

public class NicePlace {

    private String title;
    private String ImageUrl;

    public NicePlace(String imageUrl ,String title) {
        this.title = title;
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

}
