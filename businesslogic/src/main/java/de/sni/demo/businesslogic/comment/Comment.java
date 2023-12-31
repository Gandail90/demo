package de.sni.demo.businesslogic.comment;

import de.sni.demo.businesslogic.user.User;

import java.time.LocalDateTime;
import java.util.List;

public interface Comment
{
    void setTimestamp(final LocalDateTime timestamp);

    void addLike(final User user);

    List<User> getLikedUsers();
}
