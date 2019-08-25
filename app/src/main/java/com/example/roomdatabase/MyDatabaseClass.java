package com.example.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {User.class}, version = 1,exportSchema = false)
public abstract class MyDatabaseClass extends RoomDatabase {

    public abstract MyDao myDao();
}
