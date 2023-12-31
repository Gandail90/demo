package de.sni.demo.businesslogic.tag;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultTagRepository implements TagRepository
{
    @Override
    public Tag save(final Tag tag)
    {
        throw new RuntimeException("DefaultTagRepository should not be used");
    }

    @Override
    public void deleteById(final String tagId)
    {
        throw new RuntimeException("DefaultTagRepository should not be used");
    }

    @Override
    public Optional<Tag> findById(final String tagId)
    {
        throw new RuntimeException("DefaultTagRepository should not be used");
    }

    @Override
    public List<Tag> findAll()
    {
        throw new RuntimeException("DefaultTagRepository should not be used");
    }
}
