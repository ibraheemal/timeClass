package com.company;

public class Time {

    private int hour;
    private int minute;
    private boolean isEvening;

    public boolean isValidMin(int m){
        if((m>=0)&&(m<=59){
            return true;
        }
        return false;
    }

    public boolean isValidHour(int h){
        if((h>0)&&(h<=12)){
            return true;
        }
        return false;
    }

    public boolean setTime(int h, int m, boolean isEvening){

        setIsEvening(isEvening);
        if(isValidMin(h)&&(isValidHour(m))){
            // input inverted by accident?
            setMinute(h);
            setHour(m);
            System.out.println("NB assuming inputs are inverted h/m");
            return true;
        }
        if((isValidMin(m)&&isValidHour(h)){
            setMinute(m);
            setMinute(h);
            return true;
        }

    }

    public boolean setHour(int h) {
        if (isValidHour(h)) {
            this.hour = h;
            return true;
        }
        return false;
    }

    public boolean setMinute(int m){
        if(isValidMin(m)) {
            this.minute = m;
            return true;
        }
        return false;
    }

    public boolean setIsEvening(boolean b){
        this.isEvening = b;
        return true;
    }

    public boolean setTime(int h, int m, boolean isEve){
        setHour(h);
        setMinute(m);
        setIsEvening(isEve);
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinute(){
        return this.minute;
    }

    public boolean getIsEvening(){
        return this.isEvening;
    }
//TODO: account for minutes being so large they go over 1.99 hours and overlap again, need to take more than one hour off...
    public boolean subMin(int m){
        if(isValidMin(m)){
            if(minute<m){
                int remainder = m-minute;
                subHour(1);
                setMinute(60-remainder);
            }
            setMinute(minute-=m);
        }
    }
    //@TODO: and here also...
    public boolean subHour(int h){
        if(isValidHour(h)){
            if(hour<h){
                int remainder = h-hour;
                isEvening = !isEvening;
                hour = 12-remainder;
            }
            hour -=h;
        }
    }

}
