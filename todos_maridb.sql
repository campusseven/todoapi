DROP TABLE IF EXISTS todos;

CREATE TABLE todos(
 todo_num INT AUTO_INCREMENT,
 PRIMARY KEY(todo_num),
 title VARCHAR(100) NOT NULL,
 contents VARCHAR(250) ,
 start_date VARCHAR(50) ,
 end_date VARCHAR(50) 	
);

