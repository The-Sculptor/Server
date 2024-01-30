package backend.sculptor.global.oauth.memberInfo;

import java.util.Map;

public class KakaoMemberInfo implements OAuth2MemberInfo {
    private Map<String, Object> attributes;
    private Map<String, Object> kakaoAccountAttributes;
    private Map<String, Object> profileAttributes;

    public KakaoMemberInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.kakaoAccountAttributes = (Map<String, Object>) attributes.get("properties");
        this.profileAttributes = (Map<String, Object>) attributes.get("profile");

    }


    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getName() {
        return kakaoAccountAttributes.get("nickname").toString();
    }

    @Override
    public String getProfileImage() {
        return kakaoAccountAttributes.get("profile_image").toString();
    }

    @Override
    public String getEmail() {
        return kakaoAccountAttributes.get("email").toString();
    }
}
