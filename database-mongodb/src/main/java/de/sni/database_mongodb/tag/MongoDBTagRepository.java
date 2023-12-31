package de.sni.database_mongodb.tag;

import de.sni.demo.businesslogic.tag.Tag;
import de.sni.demo.businesslogic.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Primary
@Component
@Profile("MongoDB")
@RequiredArgsConstructor
public class MongoDBTagRepository implements TagRepository
{

    private final MongoDBSpringTagRepository repository;

    @Override
    public Tag save(Tag tag)
    {
        return repository.save((MongoDBTag) tag);
    }

    @Override
    public void deleteById(String tagId)
    {
        if (tagId == null)
        {
            return;
        }

        repository.deleteById(UUID.fromString(tagId));
    }

    @Override
    public Optional<Tag> findById(String tagId)
    {
        if (tagId == null)
        {
            return Optional.empty();
        }

        return repository.findById(UUID.fromString(tagId))
                .map(Tag.class::cast);
    }

    @Override
    public List<Tag> findAll()
    {
        return repository.findAll().stream()
                .map(Tag.class::cast)
                .collect(Collectors.toList());
    }
}
