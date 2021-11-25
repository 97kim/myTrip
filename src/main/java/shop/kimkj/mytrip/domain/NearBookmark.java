package shop.kimkj.mytrip.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.kimkj.mytrip.dto.NearBookmarkDto;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class NearBookmark extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String contentId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String file;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public NearBookmark(NearBookmarkDto nearBookmarkDto, User user) {
        this.contentId = nearBookmarkDto.getContentId();
        this.title = nearBookmarkDto.getTitle();
        this.file = nearBookmarkDto.getFile();
        this.username = nearBookmarkDto.getUsername();
        this.user = user;
    }
}
