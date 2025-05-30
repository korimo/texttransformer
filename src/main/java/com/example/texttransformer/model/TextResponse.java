package com.example.texttransformer.model;

public class TextResponse {
    private String transformed;

    public TextResponse(String transformed) {
        this.transformed = transformed;
    }

    public String getTransformed() {
        return transformed;
    }

    public void setTransformed(String transformed) {
        this.transformed = transformed;
    }
}