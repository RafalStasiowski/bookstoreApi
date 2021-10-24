package com.example.bookstore.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Setter
@Getter
public class BookRequestDto {
    private long id;
    private String name;
    private String bookAuthors;
    private int numberOfPages;
}
