package com.bvinstruments.paristravelguide.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.model.Forecast;
import com.bvinstruments.paristravelguide.items.ListItem;
import com.bvinstruments.paristravelguide.items.NewsItem;

import java.util.ArrayList;
import java.util.Random;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="database";
    private static final int DATABASE_VERSION=1;

    //table forecast//
    private static final String forecastTable="forecast";
    private static String KEY_ID="id";
    private static String WINDSPEED="windspeed";
    private static String HUMIDITY="humidity";
    private static String TEMPERATURE="temperature";
    private static String PRESSURE="pressure";
    private static String DESCRIPTION="description";


    ////table news///
    private static final String newsTable="news";
    private static String NEWS_ID="id";
    private static String IMAGE_URL="image_url";
    private static String HEADLINE="headline";
    private static String NEWS_DESCRIPTION="description";
    private static String AUTHOR="author";
    private static String SOURCE="source";
    private static String URL="url";
    private static String PUBLISHED_AT="published_at";
    private static String CONTENT="content";

    ////restaurants table///
    private static final String restaurantsTable="restaurants";
    private static String RESTAURANTS_ID="restaurant_id";
    private static String RESTAURANT_NAME="restaurant_name";
    private static String RESTAURANT_IMAGE="restaurant_resource_image";
    private static String DESCRIPTION_RESTAURANT="restaurant_description";
    private static String RESTAURANT_FAVORITE="favorite_restaurant";

///event table///
    private static final String eventsTable="events";
    private static String EVENTS_ID="event_id";
    private static String EVENT_NAME="EVENT_name";
    private static String EVENT_IMAGE="EVENT_resource_image";
    private static String DESCRIPTION_EVENT="EVENT_description";
    private static String EVENT_FAVORITE="favorite_event";

    private static final String hotelsTable="hotels";
    private static String HOTEL_ID="HOTEL_id";
    private static String HOTEL_NAME="HOTEL_name";
    private static String HOTEL_IMAGE="HOTEL_resource_image";
    private static String DESCRIPTION_HOTEL="HOTEL_description";
    private static String HOTEL_FAVORITE="favorite_HOTEL";

    private static final String culture_table="culture_table";
    private static String CULTURE_ID="CULTURE_id";
    private static String CULTURE_NAME="CULTURE_name";
    private static String CULTURE_IMAGE="CULTURE_resource_image";
    private static String DESCRIPTION_CULTURE="CULTURE_description";
    private static String CULTURE_FAVORITE="favorite_CULTURE";



    private static final String CREATE_TABLE_FORECAST = "CREATE TABLE "
            + forecastTable + "(" + KEY_ID + " INTEGER PRIMARY KEY," + HUMIDITY
            + " REAL," + WINDSPEED + " REAL," + PRESSURE
            + " REAL," + TEMPERATURE + " REAL," + DESCRIPTION + " VARCHAR" + ")";

    private static final String CREATE_TABLE_NEWS = "CREATE TABLE "
            + newsTable + "(" + NEWS_ID + " INTEGER PRIMARY KEY," + IMAGE_URL
            + " VARCHAR," + HEADLINE + " VARCHAR," + NEWS_DESCRIPTION
            + " VARCHAR," + SOURCE + " VARCHAR," + AUTHOR + " VARCHAR," + URL + " VARCHAR,"+ PUBLISHED_AT + " VARCHAR,"+ CONTENT + " VARCHAR" + ")";

    private static final String CREATE_TABLE_RESTAURANTS = "CREATE TABLE "
            + restaurantsTable + "(" + RESTAURANTS_ID + " INTEGER PRIMARY KEY," + RESTAURANT_NAME+ " VARCHAR," + RESTAURANT_IMAGE
            + " INTEGER," +RESTAURANT_FAVORITE + " INTEGER," + DESCRIPTION_RESTAURANT + " TEXT"  + ")";

    private static final String CREATE_TABLE_EVENTS = "CREATE TABLE "
            + eventsTable + "(" + EVENTS_ID + " INTEGER PRIMARY KEY," + EVENT_NAME+ " VARCHAR," + EVENT_IMAGE
            + " INTEGER," +EVENT_FAVORITE + " INTEGER," + DESCRIPTION_EVENT + " TEXT"  + ")";

    private static final String CREATE_TABLE_HOTEL = "CREATE TABLE "
            + hotelsTable + "(" + HOTEL_ID + " INTEGER PRIMARY KEY," + HOTEL_NAME+ " VARCHAR," + HOTEL_IMAGE
            + " INTEGER," +HOTEL_FAVORITE + " INTEGER," + DESCRIPTION_HOTEL + " TEXT"  + ")";

    private static final String CREATE_TABLE_CULTURE = "CREATE TABLE "
            + culture_table + "(" + CULTURE_ID + " INTEGER PRIMARY KEY," + CULTURE_NAME+ " VARCHAR," + CULTURE_IMAGE
            + " INTEGER," +CULTURE_FAVORITE + " INTEGER," + DESCRIPTION_CULTURE + " TEXT"  + ")";






    public DBHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_FORECAST);
        db.execSQL(CREATE_TABLE_NEWS);
        db.execSQL(CREATE_TABLE_RESTAURANTS);
        db.execSQL(CREATE_TABLE_EVENTS);
        db.execSQL(CREATE_TABLE_HOTEL);
        db.execSQL(CREATE_TABLE_CULTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + forecastTable);
        db.execSQL("DROP TABLE IF EXISTS " + newsTable);
        db.execSQL("DROP TABLE IF EXISTS " + restaurantsTable);
        db.execSQL("DROP TABLE IF EXISTS " + eventsTable);
        db.execSQL("DROP TABLE IF EXISTS " + hotelsTable);
        db.execSQL("DROP TABLE IF EXISTS " + culture_table);

    }

    public void insertForecastData(Forecast f){

Random r=new Random();
int id=r.nextInt(100000000);
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(WINDSPEED, f.getWindspeed());
        values.put(HUMIDITY, f.getHumidity());
        values.put(TEMPERATURE, f.getTemperature());
        values.put(DESCRIPTION, f.getDescription());
        values.put(PRESSURE, f.getPressure());
        this.getWritableDatabase().insert(forecastTable,null,values);


    }

    public Forecast getLatestForecast(){
        Forecast f=null;
        SQLiteDatabase db=this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + forecastTable;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()){

            c.moveToLast();
            f=new Forecast(c.getDouble(c.getColumnIndex(HUMIDITY)),c.getDouble(c.getColumnIndex(WINDSPEED)),c.getDouble(c.getColumnIndex(PRESSURE)),c.getDouble(c.getColumnIndex(TEMPERATURE)),c.getString(c.getColumnIndex(DESCRIPTION)));
        }


return f;


    }

    public void insertNews(ListItem item){


        ContentValues values = new ContentValues();
        values.put(NEWS_ID,item.hashCode());
        values.put(NEWS_DESCRIPTION, item.getDescription());
        values.put(HEADLINE, item.getHeadline());
        values.put(IMAGE_URL, item.getImaageURL());
        NewsItem nItem=(NewsItem)item;
        values.put(CONTENT, nItem.getContent());
        values.put(AUTHOR, nItem.getAuthor());
        values.put(PUBLISHED_AT, nItem.getPublishedAt());
        values.put(SOURCE, nItem.getSource());
        values.put(URL, nItem.getUrl());

        this.getWritableDatabase().insertWithOnConflict(newsTable,null, values,SQLiteDatabase.CONFLICT_REPLACE);


    }

    public void insertRestaurant(Item item){


        ContentValues values = new ContentValues();
        values.put(RESTAURANTS_ID,item.hashCode());
        values.put(RESTAURANT_NAME, item.getHeadline());
        values.put(RESTAURANT_IMAGE, item.getImageResource());
        values.put(RESTAURANT_FAVORITE, item.isFavorite());
        values.put(DESCRIPTION_RESTAURANT, item.getDescription());



        this.getWritableDatabase().insertWithOnConflict(restaurantsTable,null, values,SQLiteDatabase.CONFLICT_REPLACE);


    }
    public void insertEvent(Item item){


        ContentValues values = new ContentValues();
        values.put(EVENTS_ID,item.hashCode());
        values.put(EVENT_NAME, item.getHeadline());
        values.put(EVENT_IMAGE, item.getImageResource());
        values.put(EVENT_FAVORITE, item.getDescription());
        values.put(DESCRIPTION_EVENT, item.getDescription());


        this.getWritableDatabase().insertWithOnConflict(eventsTable,null, values,SQLiteDatabase.CONFLICT_REPLACE);


    }

    public void insertHotel(Item item){


        ContentValues values = new ContentValues();
        values.put(HOTEL_ID,item.hashCode());
        values.put(HOTEL_NAME, item.getHeadline());
        values.put(HOTEL_IMAGE, item.getImageResource());
        values.put(HOTEL_FAVORITE, item.getDescription());
        values.put(DESCRIPTION_HOTEL, item.getDescription());


        this.getWritableDatabase().insertWithOnConflict(hotelsTable,null, values,SQLiteDatabase.CONFLICT_REPLACE);


    }

    public void insertCulture(Item item){


        ContentValues values = new ContentValues();
        values.put(CULTURE_ID,item.hashCode());
        values.put(CULTURE_NAME, item.getHeadline());
        values.put(CULTURE_IMAGE, item.getImageResource());
        values.put(CULTURE_FAVORITE, item.getDescription());
        values.put(DESCRIPTION_CULTURE, item.getDescription());


        this.getWritableDatabase().insertWithOnConflict(culture_table,null, values,SQLiteDatabase.CONFLICT_REPLACE);


    }



    public ArrayList<NewsItem> getNews(){
        String selectQuery = "SELECT * FROM "+ newsTable;
        ArrayList<NewsItem> items=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst()){

            do{

                NewsItem item=new NewsItem(c.getString(c.getColumnIndex(IMAGE_URL)),c.getString(c.getColumnIndex(HEADLINE)),c.getString(c.getColumnIndex(NEWS_DESCRIPTION)),c.getString(c.getColumnIndex(SOURCE)),
                        c.getString(c.getColumnIndex(AUTHOR)),c.getString(c.getColumnIndex(URL)),c.getString(c.getColumnIndex(PUBLISHED_AT)),c.getString(c.getColumnIndex(CONTENT)));
                items.add(item);
            }while(c.moveToNext());


        }


        return items;

    }

    public ArrayList<Item> getRestaurants(){
        String selectQuery = "SELECT * FROM "+ restaurantsTable;
        ArrayList<Item> items=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst()){

            do{
Item item=new Item(c.getString(c.getColumnIndex(RESTAURANT_NAME)),c.getString(c.getColumnIndex(DESCRIPTION_RESTAURANT)),c.getInt(c.getColumnIndex(RESTAURANT_IMAGE)),c.getInt(c.getColumnIndex(RESTAURANT_FAVORITE)));

                items.add(item);
            }while(c.moveToNext());


        }


        return items;

    }

    public ArrayList<Item> getEvents(){
        String selectQuery = "SELECT * FROM "+ eventsTable;
        ArrayList<Item> items=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst()){

            do{
                Item item=new Item(c.getString(c.getColumnIndex(EVENT_NAME)),c.getString(c.getColumnIndex(DESCRIPTION_EVENT)),c.getInt(c.getColumnIndex(EVENT_IMAGE)),c.getInt(c.getColumnIndex(EVENT_FAVORITE)));

                items.add(item);
            }while(c.moveToNext());


        }


        return items;

    }

    public ArrayList<Item> getHotels(){
        String selectQuery = "SELECT * FROM "+ hotelsTable;
        ArrayList<Item> items=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst()){

            do{
                Item item=new Item(c.getString(c.getColumnIndex(HOTEL_NAME)),c.getString(c.getColumnIndex(DESCRIPTION_HOTEL)),c.getInt(c.getColumnIndex(HOTEL_IMAGE)),c.getInt(c.getColumnIndex(HOTEL_FAVORITE)));

                items.add(item);
            }while(c.moveToNext());


        }


        return items;

    }

    public ArrayList<Item> getCultures(){
        String selectQuery = "SELECT * FROM "+ culture_table;
        ArrayList<Item> items=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if(c.moveToFirst()){

            do{
                Item item=new Item(c.getString(c.getColumnIndex(CULTURE_NAME)),c.getString(c.getColumnIndex(DESCRIPTION_CULTURE)),c.getInt(c.getColumnIndex(CULTURE_IMAGE)),c.getInt(c.getColumnIndex(CULTURE_FAVORITE)));

                items.add(item);
            }while(c.moveToNext());


        }


        return items;

    }


}
