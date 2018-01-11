package com.ahmadlufiau.parcel.pojo;

/**
 * Created by Ahmad Lufi A U on 10/01/2018.
 */

public class RiwayatPembayaranPojo {

    private int picture;
    private String kp;
    private String version;
    private String initialDate;
    private String screenshot;
    private String description;

    public RiwayatPembayaranPojo(int picture, String kp, String version, String initialDate, String screenshot, String description) {
        this.picture = picture;
        this.kp = kp;
        this.version = version;
        this.initialDate = initialDate;
        this.screenshot = screenshot;
        this.description = description;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}