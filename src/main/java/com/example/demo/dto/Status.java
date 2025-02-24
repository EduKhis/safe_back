package com.example.demo.dto;

public enum Status {
    IN_WORK("В работе"),
    POSTED("Отправлен"),
    MONITORED("Контролируется");

    private String displayName;

    // Конструктор
    Status(String displayName) {
        this.displayName = displayName;
    }

    // Метод для получения строкового значения
    public String getDisplayName() {
        return displayName;
    }

}
