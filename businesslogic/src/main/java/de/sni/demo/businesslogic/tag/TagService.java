package de.sni.demo.businesslogic.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public Tag save(final Tag tag)
    {
        return tagRepository.save(tag);
    }

    public void delete(final String tagId)
    {
        tagRepository.deleteById(tagId);
    }

    public Optional<Tag> getById(final String tagId)
    {
        return tagRepository.findById(tagId);
    }

    public List<Tag> getAll()
    {
        return tagRepository.findAll();
    }
}
