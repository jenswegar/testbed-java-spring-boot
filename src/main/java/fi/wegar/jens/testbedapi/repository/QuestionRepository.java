package fi.wegar.jens.testbedapi.repository;

import fi.wegar.jens.testbedapi.entity.QuestionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface QuestionRepository extends PagingAndSortingRepository<QuestionEntity, Long> {
}