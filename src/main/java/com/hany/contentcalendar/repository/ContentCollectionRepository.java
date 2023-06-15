package com.hany.contentcalendar.repository;

import com.hany.contentcalendar.model.Content;
import com.hany.contentcalendar.model.Status;
import com.hany.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count()==1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));

    }

    @PostConstruct
    private void init(){
        Content content = new Content(
                1,
                "Highest in the room",
                "Fav desc",
                Status.COMPLETED,
                Type.VIDEO,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);

    }



}
