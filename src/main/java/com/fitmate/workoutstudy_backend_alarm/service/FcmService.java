package com.fitmate.workoutstudy_backend_alarm.service;

import com.fitmate.workoutstudy_backend_alarm.dto.FcmServiceDto;
import com.fitmate.workoutstudy_backend_alarm.jpa.Token;
import com.fitmate.workoutstudy_backend_alarm.jpa.TokenRepository;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FcmService {

    private final TokenRepository tokenRepository;

    // 푸시 알림 클릭 시 액션을 구현할 수 있도록 설정.
    public void sendByToken(FcmServiceDto dto){
        String token = getToken(dto.getUsername());

        Message message = Message.builder()
                .setToken(token)
                .setNotification(
                        Notification.builder()
                                .setTitle(dto.getTitle())
                                .setBody(dto.getContent())
                                .build()
                )
                .setAndroidConfig(
                        AndroidConfig.builder()
                                .setNotification(
                                        AndroidNotification.builder()
                                                .setTitle(dto.getTitle())
                                                .setBody(dto.getContent())
                                                .setClickAction("push_click")
                                                .build()
                                )
                                .build()
                )
                .setApnsConfig(
                        ApnsConfig.builder()
                                .setAps(Aps.builder()
                                        .setCategory("push_click")
                                        .build())
                                .build()
                )
                .putData("contentId",dto.getContentId().toString())
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("FCMsend-"+response);
        } catch (FirebaseMessagingException e) {
            log.info("FCMexcept-"+ e.getMessage());
        }
    }

    private String getToken(String username) {
        Token token = tokenRepository.findByUsername(username).orElse(null);
        return token.getValue();
    }
}
