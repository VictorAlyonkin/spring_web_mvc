package ru.service;

import org.springframework.stereotype.Service;
import ru.exception.IsExistException;
import ru.exception.NotFoundException;
import ru.model.Post;
import ru.repository.PostRepository;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    private static final Long ID_0 = 0L;
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        Post post = repository.getById(id).orElseThrow(NotFoundException::new);
        if (post.getIsRemoved())
            throw new NotFoundException();
        else
            return post;
    }

    public Post save(Post post) {

        if (ID_0.equals(post.getId()))
            return repository.create(post);

        Post postFind = repository.getById(post.getId()).orElse(null);

        if (Objects.nonNull(postFind)) {
            if (postFind.getIsRemoved()) {
                throw new NotFoundException();
            }
            return repository.update(post);
        }
        throw new IsExistException("Для создания/изменения неправильно указан id");
    }

    public void removeById(long id) {

        Post post = getById(id);

        if (post.getIsRemoved())
            throw new NotFoundException();
        else
            repository.removeById(post);
    }
}
