package com.griffith.assignment3;

import android.location.Location;
import android.util.Log;

import java.sql.Timestamp;

/**
 * Created by 42900 on 14/04/2017 for Assignment3.
 */

public class CustomLocation {
    private static String TAG = "CustomLocation";
    private Timestamp timestamp;
    private double latitude;
    private double longitude;
    private float distance;


    public CustomLocation(Timestamp timestamp, double latitude, double longitude, float distance) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
    }

    public CustomLocation(Location location){
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float distanceTo(CustomLocation location){
        float[] results = new float[1];
        Location.distanceBetween(this.latitude, this.longitude, location.getLatitude(), location.getLongitude(), results);
        return results[0];
    }

    public long getTimeBetween(CustomLocation location){
        long diff = (timestamp.getTime() - location.getTimestamp().getTime()) / 1000; // divide by 1000 to get seconds instead of milliseconds
        return diff < 0 ? diff * -1 : diff;
    }

    @Override
    public String toString() {
        return "CustomLocation{" +
                "timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distance=" + distance +
                '}';
    }
}
