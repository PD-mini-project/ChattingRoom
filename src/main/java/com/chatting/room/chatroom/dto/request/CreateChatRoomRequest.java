package com.chatting.room.chatroom.dto.request;

import com.chatting.room.common.domain.BaseEntity;
import com.chatting.room.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;


@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "chat_room")
public class CreateChatRoomRequest  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @Length(max = 255)
    private String title;

    @Column(name = "description")
    @Length(max = 255)
    private String description;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public CreateChatRoomRequest(Long id, String title, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }
}