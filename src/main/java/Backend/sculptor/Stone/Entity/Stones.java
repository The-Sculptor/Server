package Backend.sculptor.Stone.Entity;

import Backend.sculptor.User.Entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Stones {

    @Id @GeneratedValue
    @Column(name = "stone_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    //아직 유저 엔티티에 매핑안함. @OneToMany 안함

    private String stone_name;
    private String stone_goal;
    private String one_comment;

    @Enumerated(EnumType.STRING)
    private Category category; //enum

    private int powder;

    private LocalDateTime start_date;
    private LocalDateTime final_date;
    @CreationTimestamp
    private LocalDateTime created_at;

    private int stone_like;

    /*
    //갱신일
    private LocalDateTime updated_at;
     */




}