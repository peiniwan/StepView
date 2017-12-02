package com.example.stepview.stepview;

/**
 * Created by ly on 2017/12/2.
 */

public class StepViewBean {
    /** 时间 */
    private String acceptTime;
    /** 描述 */
    private String acceptStation;
    /** 描述下方*/
    private String acceptStationBelow;

    public String getAcceptStationBelow() {
        return acceptStationBelow;
    }

    public void setAcceptStationBelow(String acceptStationBelow) {
        this.acceptStationBelow = acceptStationBelow;
    }



    public StepViewBean() {
    }

    public StepViewBean(String acceptTime, String acceptStation) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
    }

    public StepViewBean(String acceptTime, String acceptStation, String acceptStationBelow) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
        this.acceptStationBelow = acceptStationBelow;

    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }
}
