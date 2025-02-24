package com.example.demo.dto;

public enum Type {

    RISK("Риск"),
    IDEA("Идея");

    private String displayName;

    // Конструктор
    Type (String displayName) {
        this.displayName = displayName;
    }

    // Метод для получения строкового значения
    public String getDisplayName() {
        return displayName;
    }
}
