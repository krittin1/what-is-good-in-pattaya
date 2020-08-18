#! bash
winpty docker-compose up -d
winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/employee.csv"
winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/changeLog.csv"

