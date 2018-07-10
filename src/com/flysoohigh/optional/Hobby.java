package com.flysoohigh.optional;

public class Hobby {
    private String hobby;
    private int level;

    public Hobby(String hobby, int level) {
        this.hobby = hobby;
        this.level = level;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby='" + hobby + '\'' +
                ", level=" + level +
                '}';
    }
}
