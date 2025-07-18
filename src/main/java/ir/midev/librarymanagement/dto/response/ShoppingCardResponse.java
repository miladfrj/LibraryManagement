package ir.midev.librarymanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ShoppingCardResponse {

    private final Long shoppingCard;
    private final Long factorId;
}
