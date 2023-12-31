package de.sni.demo.database_neo4j.tag;

import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Primary
@Component
@Profile("Neo4j")
@RequiredArgsConstructor
public class Neo4jTagRepository implements TagRepository
{
    private final Neo4jSpringTagRepository repository;

    @Override
    public Tag save(final Tag tag)
    {
        return repository.save((Neo4jTag) tag);
    }

    @Override
    public void deleteById(final String tagId)
    {
        repository.deleteById(tagId);
    }

    @Override
    public Optional<Tag> findById(final String tagId)
    {
        return repository.findById(tagId).map(Tag.class::cast);
    }

    @Override
    public List<Tag> findAll()
    {
        return repository.findAll().stream()
                .map(Tag.class::cast)
                .toList();
    }
}
