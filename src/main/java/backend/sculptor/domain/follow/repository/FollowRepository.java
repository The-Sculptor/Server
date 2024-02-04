package backend.sculptor.domain.follow.repository;

import backend.sculptor.domain.follow.dto.FollowSimpleListDto;
import backend.sculptor.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FollowRepository extends JpaRepository<Follow, Follow.PK> {
    Long countByToUser(UUID userId);    // 팔로워 수 (follower)
    Long countByFromUser(UUID userId);  // 팔로우 수 (following)
    List<FollowSimpleListDto> findAllByFromUser(UUID userId); // 사용자가 팔로우한 관계를 가져옴
    List<FollowSimpleListDto> findAllByToUser(UUID userId);	 // 사용자를 팔로우하는 관계를 가져옴
}