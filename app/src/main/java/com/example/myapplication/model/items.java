package com.example.myapplication.model;

public class items {

    /**
     * name of the product, image of the product, cash back value of the product,description and terms about thee product.
     */
    public String name;
    public String url;
    public String current_value;
    public String description;
    public String terms;


    /**
     * Get the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the image url of the product.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the image url of the product.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get the cashback value of the product.
     */
    public String getCurrentValue(){
        return current_value;
    }

    /**
     * Set the cashback value of the product.
     */
    public void setCurrentValue(String current_value){
        this.current_value = current_value;

    }

    /**
     * Get the description of the product.
     */
    public String getDescription(){
        return description;
    }

    /**
     * Set the description of the product.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Get the terms of the product.
     */
    public String getTerms(){
        return terms;
    }

    /**
     * Set the terms of the product.
     */
    public void setTerms(String terms){
        this.terms = terms;
    }

}
