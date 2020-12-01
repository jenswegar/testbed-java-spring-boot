package fi.wegar.jens.testbedapi.mapper;

import fi.wegar.jens.testbedapi.entity.QuestionEntity;
import fi.wegar.jens.testbedapi.model.Question;
import fi.wegar.jens.testbedapi.model.QuestionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper( QuestionMapper.class );

    QuestionEntity toEntity(QuestionRequest question);

    Question toAPI(QuestionEntity questionEntity);
}
