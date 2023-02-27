package uz.ankeloff.House_Selling.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.ankeloff.House_Selling.Language;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "usersDataTable")
public class User {

    @Id
    private Long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privateId;

    private String firstName;

    private String phoneNumber;

    private String lastName;

    private Double coin = 3.0;

    private String username;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", privateId=" + privateId +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", coin=" + coin +
                ", username='" + username + '\'' +
//                ", language=" + language +
                ", isAdmin=" + isAdmin +
                ", addedTime=" + addedTime +
                ", recentActivity=" + recentActivity +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrivateId(Long privateId) {
        this.privateId = privateId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCoin(Double coin) {
        this.coin = coin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public void setLanguage(Language language) {
//        this.language = language;
//    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    public void setRecentActivity(Timestamp recentActivity) {
        this.recentActivity = recentActivity;
    }

    public Long getId() {
        return id;
    }

    public Long getPrivateId() {
        return privateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getCoin() {
        return coin;
    }

    public String getUsername() {
        return username;
    }

//    public Language getLanguage() {
//        return language;
//    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public Timestamp getRecentActivity() {
        return recentActivity;
    }

//    @Enumerated(EnumType.STRING)
//    private Language language = Language.UZ;

    private boolean isAdmin = false;

    @CreationTimestamp
    private Timestamp addedTime;

    @UpdateTimestamp
    private Timestamp recentActivity;

}
