package com.shaun.verify;

//import lombok.Data;

//@Data
public class OpenApiMapping {

    /**
     * 对内路由path
     */
    private String inside_api_url;

    /**
     * 该路径对应的服务ID
     */
    private String service_id;

    public String getInside_api_url() {
        return inside_api_url;
    }

    public void setInside_api_url(String inside_api_url) {
        this.inside_api_url = inside_api_url;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    @Override
    public String toString() {
        return "OpenApiMapping{" +
                "inside_api_url='" + inside_api_url + '\'' +
                ", service_id='" + service_id + '\'' +
                '}';
    }
}
