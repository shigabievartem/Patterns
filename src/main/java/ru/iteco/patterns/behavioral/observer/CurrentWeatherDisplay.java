package ru.iteco.patterns.behavioral.observer;

import static java.lang.String.format;

public class CurrentWeatherDisplay implements Observer {
    private WeatherData weatherData;

    public CurrentWeatherDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    private float temperature;
    private float humidity;
    private int pressure;

    @Override
    public void update(float temperature, float humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display() {
        System.out.println(format("Current temperature '%s', humidity '%s', pressure '%s'", temperature, humidity, pressure));
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentWeatherDisplay currentWeatherDisplay = new CurrentWeatherDisplay(weatherData);

        weatherData.setNewWeather(12f, 12f, 13);
        weatherData.setNewWeather(15f, 15f, 15);


    }
}
