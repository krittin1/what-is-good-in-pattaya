<<<<<<< HEAD
#! bash
winpty docker-compose up -d
sleep 5
winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/employee.csv"
winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/changeLog.csv"
=======
#! /bin/bash
mongoimport  -d pattayaDB  --type csv --columnsHaveTypes --headerline --file postman/employee.csv
mongoimport  -d pattayaDB  --type csv --columnsHaveTypes --headerline --file postman/changeLog.csv
>>>>>>> 39cf7d8b104e7658379c8b9a89e2c704aaf98523

