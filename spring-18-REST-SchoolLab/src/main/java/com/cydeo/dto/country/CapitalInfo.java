
package com.cydeo.dto.country;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latlng"
})
@Generated("jsonschema2pojo")
public class CapitalInfo {

    @JsonProperty("latlng")
    private List<Float> latlng;

    @JsonProperty("latlng")
    public List<Float> getLatlng() {
        return latlng;
    }

    @JsonProperty("latlng")
    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }

}
