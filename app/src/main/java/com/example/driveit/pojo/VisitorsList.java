
package com.example.driveit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VisitorsList {

    @SerializedName("error")
    @Expose
    public Boolean error;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

    public class Datum {

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
        public String comments;
        @SerializedName("office")
        @Expose
        public String office;
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

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getOrganisationId() {
            return organisationId;
        }

        public void setOrganisationId(Integer organisationId) {
            this.organisationId = organisationId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNationalId() {
            return nationalId;
        }

        public void setNationalId(String nationalId) {
            this.nationalId = nationalId;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getVisitorState() {
            return visitorState;
        }

        public void setVisitorState(String visitorState) {
            this.visitorState = visitorState;
        }

        public String getDateOfVisit() {
            return dateOfVisit;
        }

        public void setDateOfVisit(String dateOfVisit) {
            this.dateOfVisit = dateOfVisit;
        }

        public String getTimeIn() {
            return timeIn;
        }

        public void setTimeIn(String timeIn) {
            this.timeIn = timeIn;
        }

        public Object getTimeOut() {
            return timeOut;
        }

        public void setTimeOut(Object timeOut) {
            this.timeOut = timeOut;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }



}
