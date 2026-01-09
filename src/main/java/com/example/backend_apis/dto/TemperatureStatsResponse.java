package com.example.backend_apis.dto;

public class TemperatureStatsResponse {

    private double min;
    private double max;
    private double average;

    
    private String minText;
    private String maxText;
    private String averageText;

    public TemperatureStatsResponse(double min, double max, double average, String minText, String maxText, String averageText) {
        
        this.min = min;
        this.max = max;
        this.average = average;
        
        
        this.minText = minText;
        this.maxText = maxText;
        this.averageText = averageText;
    }


    public double getMin() { return min; }
    public double getMax() { return max; }
    public double getAverage() { return average; }


    public String getMinText() { return minText; }
    public String getMaxText() { return maxText; }
    public String getAverageText() { return averageText; }
}
