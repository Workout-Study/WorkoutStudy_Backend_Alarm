package com.fitmate.workoutstudy_backend_alarm.service;

import com.fitmate.workoutstudy_backend_alarm.dto.ChatDto;
import com.fitmate.workoutstudy_backend_alarm.dto.PenaltyCompleteDto;
import com.fitmate.workoutstudy_backend_alarm.jpa.Users;
import com.fitmate.workoutstudy_backend_alarm.jpa.UsersRepository;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Value;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebhookService {

    private final UsersRepository usersRepository;

    @Transactional
    public void sendPenaltyCompleteWebhook(PenaltyCompleteDto penaltyCompleteDto) {
        Users users = usersRepository.findByUserId(penaltyCompleteDto.getUserId());
        String token = users.getFcmToken();
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(String.valueOf(penaltyCompleteDto.getUserId()))
                        .setBody(penaltyCompleteDto.getMessage())
                        .build())
                .putData("userId", String.valueOf(penaltyCompleteDto.getUserId()))
                .putData("message", penaltyCompleteDto.getMessage())
                .setAndroidConfig(AndroidConfig.builder()
                        .setNotification(AndroidNotification.builder()
                                .setTitle(String.valueOf(penaltyCompleteDto.getUserId()))
                                .setBody(penaltyCompleteDto.getMessage())
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("wallet-service")
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("FCM send-" + response);
        } catch (FirebaseMessagingException e) {
            log.info("FCM except-" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void sendRealTimeChatWebhook(ChatDto chatDto) {
        Users users = usersRepository.findByUserId(chatDto.getUserId());
        String token = users.getFcmToken();
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(String.valueOf(chatDto.getUserId()))
                        .setBody(chatDto.getMessage())
                        .build())
                .putData("userId", String.valueOf(chatDto.getUserId()))
                .putData("messageId", chatDto.getMessageId())
                .putData("fitgroupId", String.valueOf(chatDto.getFitgroupId()))
                .putData("fitMateId", String.valueOf(chatDto.getFitMateId()))
                .putData("message", chatDto.getMessage())
                .putData("messageTime", chatDto.getMessageTime())
                .putData("messageType", String.valueOf(chatDto.getMessageType()))
                .setTopic("chat-service")
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("FCM send-" + response);
        } catch (FirebaseMessagingException e) {
            log.info("FCM except-" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void sendPenaltyCompleteWebhookSingle(PenaltyCompleteDto penaltyCompleteDto) {
        Users users = usersRepository.findByUserId(penaltyCompleteDto.getUserId());
        String token = users.getFcmToken();
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(String.valueOf(penaltyCompleteDto.getUserId()))
                        .setBody(penaltyCompleteDto.getMessage())
                        .build())
                .putData("userId", String.valueOf(penaltyCompleteDto.getUserId()))
                .putData("message", penaltyCompleteDto.getMessage())
                .setAndroidConfig(AndroidConfig.builder()
                        .setNotification(AndroidNotification.builder()
                                .setTitle(String.valueOf(penaltyCompleteDto.getUserId()))
                                .setBody(penaltyCompleteDto.getMessage())
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("wallet-service")
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("FCM send-" + response);
        } catch (FirebaseMessagingException e) {
            log.info("FCM except-" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void sendRealTimeChatWebhookSingle(ChatDto chatDto) {
        Users users = usersRepository.findByUserId(chatDto.getUserId());
        String token = users.getFcmToken();
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(String.valueOf(chatDto.getUserId()))
                        .setBody(chatDto.getMessage())
                        .build())
                .putData("userId", String.valueOf(chatDto.getUserId()))
                .putData("messageId", chatDto.getMessageId())
                .putData("fitgroupId", String.valueOf(chatDto.getFitgroupId()))
                .putData("fitMateId", String.valueOf(chatDto.getFitMateId()))
                .putData("message", chatDto.getMessage())
                .putData("messageTime", chatDto.getMessageTime())
                .putData("messageType", String.valueOf(chatDto.getMessageType()))
                .setAndroidConfig(AndroidConfig.builder()
                        .setNotification(AndroidNotification.builder()
                                .setTitle(String.valueOf(chatDto.getUserId()))
                                .setBody(chatDto.getMessage())
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("wallet-service")
                .build();

        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("FCM send-" + response);
        } catch (FirebaseMessagingException e) {
            log.info("FCM except-" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
