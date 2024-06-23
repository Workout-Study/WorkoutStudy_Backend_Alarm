package com.fitmate.workoutstudy_backend_alarm.controller;

import com.fitmate.workoutstudy_backend_alarm.dto.ChatDto;
import com.fitmate.workoutstudy_backend_alarm.dto.PenaltyCompleteDto;
import com.fitmate.workoutstudy_backend_alarm.service.WebhookService;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AlarmController {

    private final WebhookService webhookService;

    @PostMapping("/wallet/penalty-complete")
    public void penaltyComplete(@RequestBody PenaltyCompleteDto penaltyCompleteDto) {
        // wallet 서버 웹훅
        webhookService.sendPenaltyCompleteWebhook(penaltyCompleteDto);
    }

    @PostMapping("/chat/real-time-chat")
    public void realTimeChat(@RequestBody ChatDto chatDto) {
        // chat 서버 웹훅
        webhookService.sendRealTimeChatWebhook(chatDto);
    }

}
