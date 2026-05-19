CREATE TABLE wish_list (
                           id BIGSERIAL PRIMARY KEY,
                           user_id BIGINT NOT NULL REFERENCES users(id),
                           created_at TIMESTAMP,
                           updated_at TIMESTAMP
);

CREATE TABLE wish_list_books (
                                 wish_list_id BIGINT NOT NULL REFERENCES wish_list(id),
                                 books_id BIGINT NOT NULL REFERENCES book(id),
                                 PRIMARY KEY (wish_list_id, books_id)
);