package com.example.myapplication.model;

public class items {

    public String name;
    public String url;
    public String current_value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCurrentValue(){
        return current_value;
    }

    public void setCurrentValue(String current_value){
        this.current_value = current_value;

    }
}
