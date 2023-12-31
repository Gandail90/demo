package de.sni.demo.businesslogic.tag;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TagRepository
{
    Tag save(final Tag tag);

    void deleteById(final String tagId);

    Optional<Tag> findById(final String tagId);

    List<Tag> findAll();
}
