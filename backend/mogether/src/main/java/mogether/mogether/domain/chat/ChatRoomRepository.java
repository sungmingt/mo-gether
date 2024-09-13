package mogether.mogether.domain.chat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findByGatherTypeAndGatherId(String gatherType, Long gatherId);
}
