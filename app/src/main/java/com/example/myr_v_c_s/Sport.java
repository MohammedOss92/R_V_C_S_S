package com.example.myr_v_c_s;

public class Sport {
    private String mInfo;
    private String mSubTitle;
    private String mTitle;

    public Sport( String mInfo,String mSubTitle, String mTitle) {
//        this.mImageUrl = mImageUrl;
        this.mInfo = mInfo;
        this.mSubTitle = mSubTitle;
        this.mTitle = mTitle;
    }

//    public Sport( String mInfo) {
//    //        this.mImageUrl = mImageUrl;
//            this.mInfo = mInfo;
//
//        }

    public Sport(){}

    public String getInfo() {
        return mInfo;
    }

    public void setInfo(String info) {
        mInfo = info;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        mSubTitle = subTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
