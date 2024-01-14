package ru.repository;

import org.springframework.stereotype.Repository;
import ru.exception.IsExistException;
import ru.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Repository
public class PostRepository {
    private static final Boolean IS_REMOVED = false;
    private Long postId = 0L;

    private final Map<Long, Post> posts = Collections.synchronizedMap(new TreeMap<>());

    public List<Post> all() {
        return posts.values()
                .stream()
                .filter(post -> IS_REMOVED.equals(post.getIsRemoved()))
                .toList();
    }

    public Optional<Post> getById(long id) {
        return Optional.of(posts.get(id));
    }

    public synchronized Post create(Post post) throws IsExistException {
        post = new Post(++postId, post.getContent());
        posts.put(postId, post);
        return post;
    }

    public Post update(Post post) throws IsExistException {
        return posts.put(post.getId(), post);
    }

    public void removeById(Post post) {
        post.setIsRemoved();
    }
}
