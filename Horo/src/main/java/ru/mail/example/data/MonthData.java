package ru.mail.example.data;

public enum MonthData {
    January("январь"),
    February("февраль"),
    March("март"),
    April("апрель"),
    May("май"),
    June("июнь"),
    July("июль"),
    August("август"),
    September("сентябрь"),
    October("октябрь"),
    November("ноябрь"),
    Decembr("декабрь");

    private final String name;
    MonthData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
