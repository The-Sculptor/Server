package backend.sculptor.domain.follow.controller;

import backend.sculptor.domain.follow.service.FollowService;
import backend.sculptor.domain.user.entity.SessionUser;
import backend.sculptor.domain.user.entity.Users;
import backend.sculptor.domain.user.service.UserService;
import backend.sculptor.global.api.APIBody;
import backend.sculptor.global.oauth.annotation.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;
    private final UserService userService;
    @PostMapping("/follow")
    public ResponseEntity<?> follow(@CurrentUser SessionUser user,
                                    @RequestParam UUID followId) {
        APIBody<Map<String, Object>> responseBody;
        try {
            Users targetUser = userService.findUser(followId);
        } catch (Exception e) {
            responseBody = APIBody.of(400, "해당 사용자가 존재하지 않습니다", null);
            return ResponseEntity.badRequest().body(responseBody);
        }
        UUID follow = followService.follow(user.getId(), followId);
        Map<String, Object> data = new HashMap<>();
        data.put("fromUser", user.getId());
        data.put("toUser", followId);

        responseBody = APIBody.of(200, "팔로우 요청 성공", data);
        return ResponseEntity.ok(responseBody);
    }
}
