package com.jetictors.futures.javaroom.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Desc           :  表user
 * Author         :  Jetictors
 * Time           :  2018/7/20 18:07
 * Email          :  zhengxcfutures@gmail.com
 * Version        :  v-1.0.1
 */
@Entity(tableName = "tb_user")
public class User implements Parcelable{

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "uid")
    private String uid;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "nick_name")
    private String nickName;

    @ColumnInfo(name = "pwd")
    private String pwd;

    public User(){}

    @Ignore
    public User(@NonNull String uid, String userName, String nickName, String pwd) {
        this.uid = uid;
        this.userName = userName;
        this.nickName = nickName;
        this.pwd = pwd;
    }

    @Ignore
    protected User(Parcel in) {
        uid = in.readString();
        userName = in.readString();
        nickName = in.readString();
        pwd = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @NonNull
    public String getUid() {
        return uid;
    }

    @NonNull
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(uid);
        parcel.writeString(userName);
        parcel.writeString(nickName);
        parcel.writeString(pwd);
    }
}
