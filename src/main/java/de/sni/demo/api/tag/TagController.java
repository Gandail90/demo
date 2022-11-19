package de.sni.demo.api.tag;

import de.sni.demo.businesslogic.tag.TagService;
import de.sni.demo.database.tag.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping(path = "tag")
@RequiredArgsConstructor
public class TagController
{
    private final TagService tagService;

    @GetMapping(path = "{tagId}")
    public ResponseEntity<Tag> getById(
            @PathVariable("tagId") final String tagId)
    {
        return ResponseEntity.of(tagService.getById(tagId));
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Tag>> getAll()
    {
        return ResponseEntity.ok(
                tagService.getAll());
    }

    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody final TagDTO dto)
    {
        log.info("####################### create Tag: " + dto.getName());
        return ResponseEntity.ok(
                tagService.save(new Tag(null, dto.getName(), new ArrayList<>())));
    }

    @PostMapping(path = "rename")
    public ResponseEntity<Tag> rename (@RequestBody final RenameTagDTO dto)
    {
        final Optional<Tag> tag = tagService.getById(dto.getTagId());

        if (tag.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        tag.ifPresent(tag1 -> tag1.setName(dto.getName()));

        return ResponseEntity.ok(tagService.save(tag.get()));
    }

    @DeleteMapping(path = "{tagId}")
    public ResponseEntity<Object> delete(
            @PathVariable("tagId") final String tagId)
    {
        try
        {
            tagService.delete(tagId);
            return ResponseEntity.ok().build();
        } catch (final Exception exception)
        {
            exception.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
