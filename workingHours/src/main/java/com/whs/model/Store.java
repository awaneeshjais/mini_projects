package com.whs.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Store extends RealmObject {
    @PrimaryKey
    String id;

    String name;
    String phone;
    String address;
    boolean isNonStop;
    double latitude;
    double longitude;
    boolean isDayOff1;
    boolean isDayOff2;
    boolean isDayOff3;
    boolean isDayOff4;
    boolean isDayOff5;
    boolean isDayOff6;
    boolean isDayOff7;
    int day1Start;
    int day1End;
    int day2Start;
    int day2End;
    int day3Start;
    int day3End;
    int day4Start;
    int day4End;
    int day5Start;
    int day5End;
    int day6Start;
    int day6End;
    int day7Start;
    int day7End;



    public Store (){}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getNonStop() {
        return isNonStop;
    }

    public void setNonStop(boolean nonStop) {
        isNonStop = nonStop;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }




    public boolean getDayOff1() {
        return isDayOff1;
    }

    public void setDayOff1(boolean dayOff1) {
        isDayOff1 = dayOff1;
    }

    public boolean getDayOff2() {
        return isDayOff2;
    }

    public void setDayOff2(boolean dayOff2) {
        isDayOff2 = dayOff2;
    }

    public boolean getDayOff3() {
        return isDayOff3;
    }

    public void setDayOff3(boolean dayOff3) {
        isDayOff3 = dayOff3;
    }

    public boolean getDayOff4() {
        return isDayOff4;
    }

    public void setDayOff4(boolean dayOff4) {
        isDayOff4 = dayOff4;
    }

    public boolean getDayOff5() {
        return isDayOff5;
    }

    public void setDayOff5(boolean dayOff5) {
        isDayOff5 = dayOff5;
    }

    public boolean getDayOff6() {
        return isDayOff6;
    }

    public void setDayOff6(boolean dayOff6) {
        isDayOff6 = dayOff6;
    }

    public boolean getDayOff7() {
        return isDayOff7;
    }

    public void setDayOff7(boolean dayOff7) {
        isDayOff7 = dayOff7;
    }




    public int getDay1Start() {
        return day1Start;
    }

    public void setDay1Start(int day1Start) {
        this.day1Start = day1Start;
    }

    public int getDay1End() {
        return day1End;
    }

    public void setDay1End(int day1End) {
        this.day1End = day1End;
    }

    public int getDay2Start() {
        return day2Start;
    }

    public void setDay2Start(int day2Start) {
        this.day2Start = day2Start;
    }

    public int getDay2End() {
        return day2End;
    }

    public void setDay2End(int day2End) {
        this.day2End = day2End;
    }

    public int getDay3Start() {
        return day3Start;
    }

    public void setDay3Start(int day3Start) {
        this.day3Start = day3Start;
    }

    public int getDay3End() {
        return day3End;
    }

    public void setDay3End(int day3End) {
        this.day3End = day3End;
    }

    public int getDay4Start() {
        return day4Start;
    }

    public void setDay4Start(int day4Start) {
        this.day4Start = day4Start;
    }

    public int getDay4End() {
        return day4End;
    }

    public void setDay4End(int day4End) {
        this.day4End = day4End;
    }

    public int getDay5Start() {
        return day5Start;
    }

    public void setDay5Start(int day5Start) {
        this.day5Start = day5Start;
    }

    public int getDay5End() {
        return day5End;
    }

    public void setDay5End(int day5End) {
        this.day5End = day5End;
    }

    public int getDay6Start() {
        return day6Start;
    }

    public void setDay6Start(int day6Start) {
        this.day6Start = day6Start;
    }

    public int getDay6End() {
        return day6End;
    }

    public void setDay6End(int day6End) {
        this.day6End = day6End;
    }

    public int getDay7Start() {
        return day7Start;
    }

    public void setDay7Start(int day7Start) {
        this.day7Start = day7Start;
    }

    public int getDay7End() {
        return day7End;
    }

    public void setDay7End(int day7End) {
        this.day7End = day7End;
    }
}