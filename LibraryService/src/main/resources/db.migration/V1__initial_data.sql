CREATE TABLE IF NOT EXISTS book
(
    isbn VARCHAR
(
    255
) PRIMARY KEY,
    title VARCHAR
(
    255
) NOT NULL,
    author VARCHAR
(
    255
) NOT NULL,
    category VARCHAR
(
    255
) NOT NULL,
    borrower VARCHAR
(
    255
));

INSERT INTO book (isbn, title, author, category)
VALUES ('978-0544003415', 'Władca Pierścieni: Drużyna Pierścienia', 'J.R.R. Tolkien', 'Fantasy'),
       ('978-0547928227', 'Hobbit, czyli tam i z powrotem', 'J.R.R. Tolkien', 'Fantasy'),
       ('978-0747532699', 'Harry Potter i Kamień Filozoficzny', 'J.K. Rowling', 'Fantasy') ON CONFLICT (isbn) DO NOTHING;

INSERT INTO book (isbn, title, author, category, borrower)
VALUES ('978-0553593716', 'Gra o tron', 'George R.R. Martin', 'Fantasy', 'Adam'),
       ('978-0061120084', 'Zabić drozda', 'Harper Lee', 'Klasyczna', 'Maciek') ON CONFLICT (isbn) DO NOTHING;