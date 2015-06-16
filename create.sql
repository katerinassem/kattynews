/*
 * SQL script that creates all the neccessary tables 
 * Oracle DataBase
 */

CREATE TABLE news(
  news_id NUMBER(6) NOT NULL,
  message VARCHAR2(500) NOT NULL,
  author_id NUMBER(6) NULL,
  PRIMARY KEY (news_id)
);

CREATE TABLE news_comment(
  comment_id NUMBER(6) NOT NULL,
  news_id NUMBER(6) NOT NULL,
  message VARCHAR2(100) NOT NULL,
  access_date DATE NOT NULL,
  PRIMARY KEY (comment_id),
  CONSTRAINT fk_CommentsNew FOREIGN KEY (news_id)
  REFERENCES news (news_id)
    ON DELETE CASCADE
);

CREATE TABLE author(
  author_id NUMBER(6) NOT NULL,
  name VARCHAR2(50) NOT NULL,
  deletion_date DATE NULL,
  PRIMARY KEY (author_id)
);

CREATE TABLE news_tag(
  tag_id NUMBER(6) NOT NULL,
  news_id NUMBER(6) NOT NULL,
  name VARCHAR2(50) NOT NULL,
  PRIMARY KEY (tag_id),
  CONSTRAINT fk_TagsNew FOREIGN KEY (news_id)
  REFERENCES news (news_id)
    ON DELETE CASCADE
);

ALTER TABLE news 
  ADD CONSTRAINT fk_NewsAuthor FOREIGN KEY (author_id)
  REFERENCES author (author_id);  
  