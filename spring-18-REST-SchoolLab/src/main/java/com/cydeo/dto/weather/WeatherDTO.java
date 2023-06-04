
package com.cydeo.dto.weather;

import lombok.Getter;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Getter
public class WeatherDTO {

    public Request request;
    public Location location;
    public Current current;

}
