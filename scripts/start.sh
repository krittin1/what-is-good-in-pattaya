#! /bin/bash
mongoimport  -d pattayaDB  --type csv --columnsHaveTypes --headerline --file postman/employee.csv
mongoimport  -d pattayaDB  --type csv --columnsHaveTypes --headerline --file postman/changeLog.csv
