package mogether.mogether.web.moim.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mogether.mogether.domain.info.Address;
import mogether.mogether.domain.info.Keyword;
import mogether.mogether.domain.moim.Moim;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoimUpdateRequest {

    @NotEmpty
    private Long userId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String keyword;

    @NotEmpty
    private Address address;

    @NotEmpty
    private LocalDate createdAt;
    @NotEmpty
    private LocalDate expireAt; ///

    public Moim toMoim() {
        return new Moim(
                this.title,
                this.content,
                Keyword.of(this.keyword),
                this.address,
                this.createdAt,
                this.expireAt
        );
    }
}
