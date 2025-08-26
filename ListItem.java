package todo;

import java.util.UUID;

public abstract class ListItem {
    private String id;
    private String createdAt;

    public ListItem() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = java.time.LocalDateTime.now().toString();
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public abstract void display();
}
