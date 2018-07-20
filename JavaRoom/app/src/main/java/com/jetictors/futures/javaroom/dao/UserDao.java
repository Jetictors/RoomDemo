package com.jetictors.futures.javaroom.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.jetictors.futures.javaroom.entity.User;

import java.util.List;

/**
 * Desc           :  UserDao
 * Author         :  Jetictors
 * Time           :  2018/7/20 18:14
 * Email          :  zhengxcfutures@gmail.com
 * Version        :  v-1.0.1
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUserList(List<User> userList);

    @Query("select * from tb_user where uid = :uid")
    User getUserById(String uid);

    @Query("select * from tb_user")
    List<User> getUserAll();

//    @Update()
//    void updateUserById(String uid);

}
