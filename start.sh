#! bash
docker-compose up -d
sleep 10
docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/employee.csv"
docker-compose exec mongo bash -c "mongoimport -u root -p example -d pattayaDB --authenticationDatabase admin --type csv --columnsHaveTypes --headerline --file map/changeLog.csv"

