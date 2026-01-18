create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);


//lets insert some records:
INSERT INTO users VALUES ('user','{noop}EazyBytes@12345',1);
INSERT INTO authorities VALUES ('user','read');

INSERT IGNORE INTO users VALUES ('admin','{bcrypt}$2a$12$/j3pwOIhKmiIkbsd27FVP.9tsBcDW2..LcFD86Xmz5BXTeozO9N1S',1);
INSERT IGNORE INTO authorities VALUES ('admin','admin');

//Ashish!@#123
//customer table creation for custom tables section 4 lecture 30:

CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(100) NOT NULL,
  pwd VARCHAR(200) NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO customer (email,pwd,role) VALUES ('happy@example.com','{noop}EazyBytes@12345','read');
INSERT INTO customer (email,pwd,role) VALUES ('admin@example.com','{bcrypt}$2a$12$/j3pwOIhKmiIkbsd27FVP.9tsBcDW2..LcFD86Xmz5BXTeozO9N1S','admin');
