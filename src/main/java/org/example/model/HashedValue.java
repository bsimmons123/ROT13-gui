package org.example.model;

public class HashedValue {
    private String value;
    private String originalValue;

    public void setValue(String value){
        this.value = value;
    }

    public void setOriginalValue(String originalValue){
        this.originalValue = originalValue;
    }

    public String getValue(){
        return value;
    }

    public String getOriginalValue(){
        return originalValue;
    }
}
