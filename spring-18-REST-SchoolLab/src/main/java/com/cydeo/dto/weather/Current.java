
package com.cydeo.dto.weather;

import lombok.Getter;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Getter
public class Current {

    public String observationTime;
    public Integer temperature;
    public Integer weatherCode;
    public List<String> weatherIcons;
    public List<String> weatherDescriptions;
    public Integer windSpeed;
    public Integer windDegree;
    public String windDir;
    public Integer pressure;
    public Integer precip;
    public Integer humidity;
    public Integer cloudcover;
    public Integer feelslike;
    public Integer uvIndex;
    public Integer visibility;

}
