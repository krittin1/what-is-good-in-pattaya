#! bash
winpty docker-compose up -d
sleep 5
winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/employee.csv"
winpty docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/changeLog.csv"

