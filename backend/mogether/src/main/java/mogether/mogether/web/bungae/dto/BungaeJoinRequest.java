package mogether.mogether.web.bungae.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BungaeJoinRequest {

    @NotNull
    private Long bungaeId;
    @NotNull
    private Long userId;
}
