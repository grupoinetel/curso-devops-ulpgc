package com.inerza.ulpgc.bookReview.model.mappers;

import com.inerza.ulpgc.bookReview.model.dto.ReviewDTO;
import com.inerza.ulpgc.bookReview.model.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
    ReviewDTO convertToDto(Review entity);
    Review convertToEntity(ReviewDTO dto);
}
