package com.harry.observer.improve;

public class Client {
    public static void main(String[] args) {
        // 创建一个 WeatherData
        WeatherData weatherData = new WeatherData();
        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);
        weatherData.setData(20, 10, 100);
        System.out.println("update --------------");

        weatherData.setData(30, 40, 555);

    }
}
