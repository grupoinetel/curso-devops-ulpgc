package com.inerza.ulpgc.bookReview.mappers;

import com.inerza.ulpgc.bookReview.entities.Book;
import com.inerza.ulpgc.bookReview.entitiesDTO.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO convert(Book entity);
    Book convert(BookDTO dto);
}
