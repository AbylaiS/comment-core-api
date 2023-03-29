package kz.dar.university.commentcoreapi.repository;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String commentId;
    @Column(nullable = false, length = 50)
    private String comment;

}
