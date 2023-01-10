package com.inerza.ulpgc.bookReview.mappers;

import com.inerza.ulpgc.bookReview.entities.Review;
import com.inerza.ulpgc.bookReview.entitiesDTO.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);
    ReviewDTO convert(Review entity);
    Review convert(ReviewDTO dto);
}
