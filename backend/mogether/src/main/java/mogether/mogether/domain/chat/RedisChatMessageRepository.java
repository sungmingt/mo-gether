package mogether.mogether.domain.chat;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.time.Duration.ofMillis;

@Repository
public class RedisChatMessageRepository {

    private static final String ROOM_KEY_PREFIX = "chatMessage:room:";

    private final RedisTemplate<String, ChatMessage> chatMessageRedisTemplate;
    private final HashOperations<String, String, ChatMessage> hashOperations;

    public RedisChatMessageRepository(@Qualifier("chatMessageRedisTemplate") RedisTemplate<String, ChatMessage> chatMessageRedisTemplate) {
        this.chatMessageRedisTemplate = chatMessageRedisTemplate;
        this.hashOperations = chatMessageRedisTemplate.opsForHash();
    }

    public Optional<ChatMessage> findById(Long roomId, String id) {
        return Optional.ofNullable(hashOperations.get(getRoomKey(roomId), id));
    }

    public List<ChatMessage> findByRoomId(Long roomId) {
        String roomKey = getRoomKey(roomId);
        return hashOperations.values(roomKey);
    }

    public void save(ChatMessage chatMessage) {
        String roomKey = getRoomKey(chatMessage.getRoomId());
        hashOperations.put(roomKey, chatMessage.getId(), chatMessage);
        chatMessageRedisTemplate.expire(roomKey, Duration.ofHours(25));
    }

    public void deleteById(Long roomId, Long id) {
        hashOperations.delete(getRoomKey(roomId), String.valueOf(id));
    }

    private String getRoomKey(Long roomId) {
        return ROOM_KEY_PREFIX + roomId;
    }
}
