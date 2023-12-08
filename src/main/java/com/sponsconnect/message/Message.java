package com.sponsconnect.message;



import javax.persistence.*;

import com.sponsconnect.lead.userProfile.UserProfile;
import com.sponsconnect.shared.BaseEntity;
import org.hibernate.annotations.Filter;


@Entity
@Filter(name = "is_delete", condition = "is_delete=false")
public class Message extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sponsor_id", referencedColumnName = "id")
//    private UserProfile sender; // Foreign key to User
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sponsor_id", referencedColumnName = "id")
//    private UserProfile receiver;

    @Column
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public UserProfile getSender() {
//        return sender;
//    }
//
//    public void setSender(UserProfile sender) {
//        this.sender = sender;
//    }
//
//    public UserProfile getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(UserProfile receiver) {
//        this.receiver = receiver;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

//
//interface MessageRepo extends JpaRepository<Message, Long> {
//    // Your custom query methods can be added here
//}
