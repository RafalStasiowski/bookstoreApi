package com.example.bookstore.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookResponseDto {
    private long id;
    private String name;
    private String bookAuthors;
    private int numberOfPages;
}
