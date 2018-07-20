package com.jetictors.futures.javaroom.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jetictors.futures.javaroom.dao.UserDao;
import com.jetictors.futures.javaroom.entity.User;

/**
 * Desc           :  database
 * Author         :  Jetictors
 * Time           :  2018/7/20 18:13
 * Email          :  zhengxcfutures@gmail.com
 * Version        :  v-1.0.1
 */
@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class TestDatabase extends RoomDatabase{

    private static final String DB_NAME = "test_db";
    private static TestDatabase instance;

    public abstract UserDao userDao();

    public static TestDatabase getInstance(Context context){
        if (instance == null){
            synchronized (TestDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context,TestDatabase.class,DB_NAME)
                            // 数据库迁移
                            .addMigrations()
                            //迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
                            .fallbackToDestructiveMigration()
                            // 允许主线程中查询数据
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

    @Override
    public void clearAllTables() {

    }
}
