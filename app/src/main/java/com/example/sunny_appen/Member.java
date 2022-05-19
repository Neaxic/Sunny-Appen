package com.example.sunny_appen;

public class Member {
    public String name;
    public Integer points;

    public Member(String name, int points) {
        this.name = name;
        this.points = points;
    }


    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getPointsAsString() {
        return points.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
