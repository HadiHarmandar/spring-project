
package com.cydeo.dto.country;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "2016"
})
@Generated("jsonschema2pojo")
public class Gini {

    @JsonProperty("2016")
    private Float _2016;

    @JsonProperty("2016")
    public Float get2016() {
        return _2016;
    }

    @JsonProperty("2016")
    public void set2016(Float _2016) {
        this._2016 = _2016;
    }

}
