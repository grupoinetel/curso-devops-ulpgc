package com.inerza.ulpgc.bookReview.model.mappers;

import com.inerza.ulpgc.bookReview.model.dto.BookDTO;
import com.inerza.ulpgc.bookReview.model.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDTO convertToDto(Book entity);
    Book convertToEntity(BookDTO dto);
}
