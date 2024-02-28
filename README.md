Task is to create a code, that would be able to handle with gold transactions in 100 threads at one time. 
Gold is coming from users or successfully completed tasks (task can increase or decrease gold count depending on success of the task) to Clan gold counter.
Multithread safety is achieved by using synchronized methods and Atomic Integer in class variables.

NOTE: To run the application you need to create a database in Postgresql, create db.properties in "resources" folder and describe next database's parameters there: db.url, db.username, db.password 

