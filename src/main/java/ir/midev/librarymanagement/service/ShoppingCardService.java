package ir.midev.librarymanagement.service;

import ir.midev.librarymanagement.dto.request.ShoppingCardRequest;
import ir.midev.librarymanagement.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {

    ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest);
}
