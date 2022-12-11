package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.concretes.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedbackRepository extends JpaRepositoryAdapter<Feedback, UUID> {

    <P> Page<P> findByReviewed(Boolean reviewed, Pageable pageable, Class<P> projection);

    <P> Page<P> findByTopicContainingIgnoreCase(String containing, Pageable pageable, Class<P> projection);

    <P> Page<P> findByContentContainingIgnoreCase(String containing, Pageable pageable, Class<P> projection);

    @Modifying
    @Query("update Feedback fb set fb.reviewed = :reviewed, fb.reviewer = :#{@securityHelper.currentUsername.orElseThrow()} where fb.id = :id")
    int updateReviewed(UUID id, Boolean reviewed);

}
