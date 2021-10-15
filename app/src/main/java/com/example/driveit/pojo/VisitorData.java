
package com.example.driveit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VisitorData {

    @SerializedName("data")
    @Expose
    public Data data;

    public class Data {


        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("organisation_id")
        @Expose
        public Integer organisationId;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_name")
        @Expose
        public String lastName;
        @SerializedName("phone")
        @Expose
        public String phone;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("national_id")
        @Expose
        public String nationalId;
        @SerializedName("comments")
        @Expose
        public Object comments;
        @SerializedName("office")
        @Expose
        public Object office;
        @SerializedName("host")
        @Expose
        public String host;
        @SerializedName("visitor_state")
        @Expose
        public String visitorState;
        @SerializedName("date_of_visit")
        @Expose
        public String dateOfVisit;
        @SerializedName("time_in")
        @Expose
        public String timeIn;
        @SerializedName("time_out")
        @Expose
        public Object timeOut;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;

    }
}