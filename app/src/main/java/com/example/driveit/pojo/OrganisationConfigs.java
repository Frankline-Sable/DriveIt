
package com.example.driveit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrganisationConfigs {

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
        @SerializedName("notify_days")
        @Expose
        public Integer notifyDays;
        @SerializedName("notify_time")
        @Expose
        public String notifyTime;
        @SerializedName("notify_message")
        @Expose
        public String notifyMessage;
        @SerializedName("notify_email_subject")
        @Expose
        public String notifyEmailSubject;
        @SerializedName("notify_email_message")
        @Expose
        public String notifyEmailMessage;
        @SerializedName("partner_id")
        @Expose
        public Integer partnerId;
        @SerializedName("api_key")
        @Expose
        public String apiKey;
        @SerializedName("short_code")
        @Expose
        public String shortCode;
        @SerializedName("email_address")
        @Expose
        public Object emailAddress;
        @SerializedName("email_cc")
        @Expose
        public Object emailCc;
        @SerializedName("telephone")
        @Expose
        public Object telephone;
        @SerializedName("departments")
        @Expose
        public Object departments;
        @SerializedName("assets")
        @Expose
        public Object assets;
        @SerializedName("auto_notify")
        @Expose
        public Integer autoNotify;
        @SerializedName("notify_method")
        @Expose
        public String notifyMethod;
        @SerializedName("verify_expire")
        @Expose
        public Integer verifyExpire;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;

    }

}
