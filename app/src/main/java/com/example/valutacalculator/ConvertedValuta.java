package com.example.valutacalculator;

import java.util.Objects;

public class ConvertedValuta {
    private String fromValuta;
    private String toValuta;
    private double fromValutaDouble;
    private double toValutaDouble;
    private double fromValue;
    private double toValue;

    // from valuta
    public String getFromValuta(){
        return fromValuta;
    }
    public void setFromValuta(String value){
        fromValuta = value;
    }

    // to valuta
    public String getToValuta(){
        return toValuta;
    }
    public void setToValuta(String value){
        toValuta = value;
    }


    // from valuta double
    public double getFromValutaDouble(){
        return fromValutaDouble;
    }
    public void setFromValutaDouble(double value){
        fromValutaDouble = value;
    }

    // to valuta double
    public double getToValutaDouble(){
        return toValutaDouble;
    }
    public void setToValutaDouble(double value){
        toValutaDouble = value;
    }

    // from value
    public double getFromValue(){
        return fromValue;
    }
    public void  setFromValue(double value){
        fromValue = value;
    }

    // to value
    public double getToValue(){
        return toValue;
    }
    public void setToValue(double value){
        toValue = value;
    }

    public  ConvertedValuta(){}
    public  ConvertedValuta(String fromValuta, double fromValue){
        this.fromValuta = fromValuta;
        this.fromValue = fromValue;
    }
    public  ConvertedValuta(String fromValuta, double fromValutaDouble, double fromValue){
        this.fromValuta = fromValuta;
        this.fromValutaDouble = fromValutaDouble;
        this.fromValue = fromValue;
    }
    public ConvertedValuta(String fromValuta, double fromValue, String toValuta, double toValue){
        this.fromValuta = fromValuta;
        this.fromValue = fromValue;
        this.toValuta = toValuta;
        this.toValue = toValue;
    }
    public ConvertedValuta(String fromValuta, double fromValutaDouble, double fromValue, String toValuta, double toValutaDouble, double toValue){
        this.fromValuta = fromValuta;
        this.fromValutaDouble = fromValutaDouble;
        this.fromValue = fromValue;
        this.toValuta = toValuta;
        this.toValutaDouble = toValutaDouble;
        this.toValue = toValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConvertedValuta item = (ConvertedValuta) o;

        if (!Objects.equals(fromValuta, item.fromValuta)) return false;
        if (!Objects.equals(toValuta, item.toValuta)) return false;
        if (fromValutaDouble != item.fromValutaDouble) return false;
        if (toValutaDouble != item.toValutaDouble) return false;
        if (fromValue != item.fromValue) return false;
        if (toValue != item.toValue) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = fromValuta != null ? fromValuta.hashCode() : 0;
        result = 31 * result + ((toValuta != null) ? toValuta.hashCode() : 0);
        result = 63 * result + (int) Math.floor(fromValutaDouble);
        result = 127 * result + (int) Math.floor(toValutaDouble);
        result = 255 * result + (int) Math.floor(fromValue);
        result = 511 * result + (int)Math.floor(toValue);
        return result;
    }

    public ConvertedValuta copy(){
        return new ConvertedValuta(this.fromValuta,this.fromValutaDouble,this.fromValue,this.toValuta,this.toValutaDouble,this.toValue);
    }
}
