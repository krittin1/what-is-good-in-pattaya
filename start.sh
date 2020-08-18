#! /bin/bash
<<<<<<< HEAD
 winpty docker-compose up -d
 winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/employee.csv"
 winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/changeLog.csv"
=======
mongoimport  -d pattayaDB  --type csv --columnsHaveTypes --headerline --file postman/employee.csv
mongoimport  -d pattayaDB  --type csv --columnsHaveTypes --headerline --file postman/changeLog.csv
>>>>>>> 776ecb90dbdd08551938e392509a4f9b24fcbf44

