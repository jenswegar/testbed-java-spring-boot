package fi.wegar.jens.testbedapi.repository;

import fi.wegar.jens.testbedapi.entity.QuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface QuestionRepository extends PagingAndSortingRepository<QuestionEntity, Long> {

    default Optional<QuestionEntity> randomQuestion() {
        Long qty = this.count();
        int idx = (int)(Math.random() * qty);
        Page<QuestionEntity> questionPage = this.findAll(PageRequest.of(idx, 1));

        Optional<QuestionEntity> q = Optional.empty();
        if (questionPage.hasContent()) {
            q = Optional.of(questionPage.getContent().get(0));
        }
        return q;
    }
}