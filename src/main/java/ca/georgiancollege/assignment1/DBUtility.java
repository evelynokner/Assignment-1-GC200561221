package ca.georgiancollege.assignment1;

import java.sql.*;

public class DBUtility {

    private String connectionURL, username, password, database;
    private String table;

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public static void main(String[] args) {

        DBUtility db = new DBUtility("Assignment1", "GenshinImpact");
        try {
            db.createDatabase();
            db.createTable();
            db.insertData();
            System.out.println("Data has been inserted");
            // Using the following commented code in TableController
            //ResultSet resultSet = db.getAllRows("GenshinImpact");
            //printResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DBUtility(String database) {
        String connectionURL = "jdbc:mysql://database-1.cj2aqmsw2hib.us-east-2.rds.amazonaws.com:3306",
        username = "admin", password = "051007georgianJAVA";
        database = "Assignment1";
        //this.database = database;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(connectionURL + "/" + database, username, password);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    public DBUtility(String database, String table){
        this(database);
        setTable(table);
    }

    public void createDatabase() throws SQLException {
        String createDatabaseQuery = "create database Assignment1";
        PreparedStatement preparedStatement = connection.prepareStatement(createDatabaseQuery);
        preparedStatement.execute();
    }

    public void createTable() throws SQLException {
        String createTableQuery = "use Assignment1;" +
                "create table GenshinImpact(" +
                "    version double," +
                "    5_star_character varchar(50)," +
                "    revenue int," +
                "    start_date varchar(50)," +
                "    end_date varchar(50)," +
                "    banner_days int);";
        PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
        preparedStatement.execute();
    }

    public void insertData() throws SQLException {
        String sql = "insert into GenshinImpact(version, 5_star_character, revenue, start_date, end_date, banner_days)"
        +"values(1.0, 'Venti', 30632752, '25/09/2020', '19/10/2020', 25),"
                +"(1.0, 'Klee', 22750000, '20/10/2020', '10/11/2020', 22),"
                +"(1.1, 'Tartaglia', 13443619, '11/11/2020', '30/11/2020', 20),"
                +"(1.1, 'Zhongli', 16264892, '01/12/2020', '22/12/2020', 22),"
                +"(1.2, 'Albedo', 11816107, '23/12/2020', '12/01/2021', 21),"
                +"(1.2, 'Ganyu', 15669918, '13/01/2021', '02/02/2021', 21),"
                +"(1.3, 'Xiao', 13145115, '03/02/2021', '17/02/2021', 15),"
                +"(1.3, 'Keqing', 9505798, '18/02/2021', '02/03/2021', 13),"
                +"(1.3, 'Hu Tao', 12481634, '03/03/2021', '16/03/2021', 14),"
                +"(1.4, 'Venti (Rerun)', 16614209, '17/03/2021', '06/04/2021', 21),"
                +"(1.4, 'Tartaglia (Rerun)', 6965445, '07/04/2021', '27/04/2021', 21),"
                +"(1.5, 'Zhongli (Rerun)', 10215165, '28/04/2021', '18/05/2021', 21),"
                +"(1.5, 'Eula', 12619330, '19/05/2021', '08/06/2021', 21),"
                +"(1.6, 'Klee (Rerun)', 7006180, '09/06/2021', '29/06/2021', 21),"
                +"(1.6, 'Kazuha', 9807112, '30/06/2021', '20/07/2021', 21),"
                +"(2.0, 'Ayaka', 16451006, '21/07/2021', '10/08/2021', 21),"
                +"(2.0, 'Yoimiya', 8615114, '11/08/2021', '31/08/2021', 21),"
                +"(2.1, 'Raiden Shogun', 33020905, '01/09/2021', '20/09/2021', 20),"
                +"(2.1, 'Kokomi', 7020975, '21/09/2021', '12/10/2021',22),"
                +"(2.2, 'Tartaglia (2nd Rerun)', 7785438, '13/10/2021', '02/11/2021', 21),"
                +"(2.2, 'Hu Tao (Rerun)', 25226952, '02/11/2021', '23/11/2021', 22),"
                +"(2.3, 'Albedo (Rerun) & Eula (Rerun)', 17026066, '24/11/2021', '14/12/2021', 21),"
                +"(2.3, 'Arataki Itto', 13404072, '14/12/2021', '04/01/2022', 22),"
                +"(2.4, 'Shenhe & Xiao (Rerun)', 16994406, '05/01/2022', '25/01/2022', 21),"
                +"(2.4, 'Ganyu (Rerun) & Zhongli (2nd Rerun)', 26780298, '25/01/2022', '15/02/2022', 22),"
                +"(2.5, 'Yae Miko', 15110264, '16/02/2022', '08/03/2022', 21),"
                +"(2.5, 'Raiden Shogun (Rerun) & Kokomi (Rerun)', 33560259, '/08/03/2022', '29/03/2022', 22),"
                +"(2.6, 'Ayato & Venti (2nd Rerun)', 22767455, '30/03/2022', '19/04/2022', 21),"
                +"(2.6, 'Ayaka (Rerun)', 35939006, '19/04/2022', '31/05/2022', 43),"
                +"(2.7, 'Yelan 7 Xiao (2nd Rerun)', 32177144, '31/05/2022', '21/06/2022', 22),"
                +"(2.7, 'Arataki Itto (Rerun)', 12586764, '21/06/2022', '12/07/2022', 22),"
                +"(2.8, 'Kazuha (Rerun) & Klee (2nd Rerun)', 24808479, '13/07/2022', '02/08/2022', 21),"
                +"(2.8, 'Yoimiya (Rerun)', 14333266, '02/08/2022', '23/08/2022', 22),"
                +"(3.0, 'Tighnari & Zhongli (3rd Rerun)', 19068372, '23/08/2022', '09/09/2022', 18),"
                +"(3.0, 'Ganyu (2nd Rerun) & Kokomi (2nd Rerun)', 15681840, '09/09/2022', '27/09/2022', 19),"
                +"(3.1, 'Cyno & Venti (3rd Rerun)', 19052023, '27/09/2022', '14/10/2022', 18),"
                +"(3.1, 'Nilou & Albedo (2nd Rerun)', 15731680, '14/10/2022', '01/11/2022', 19),"
                +"(3.2, 'Nahida & Yoimiya (2nd Rerun)', 32101943, '01/11/2022', '15/11/2022', 15);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    private static void printResults(ResultSet resultSet) throws SQLException {
        while(resultSet.next()){
            double version = resultSet.getDouble(1);
            String character = resultSet.getString(2);
            int revenue = resultSet.getInt(3);
            String start_date = resultSet.getString(4);
            String end_date = resultSet.getString(5);
            int banner_days = resultSet.getInt(6);

            System.out.println(version);
            System.out.println(character);
            System.out.println(revenue);
            System.out.println(start_date);
            System.out.println(end_date);
            System.out.println(banner_days);
            System.out.println("*".repeat(20));
        }
    }

    public void queryExec(String sql) throws Exception{
        statement = connection.createStatement();
        statement.execute(sql);
    }
    public ResultSet queryResult(String sql) throws SQLException{
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public ResultSet getRowById(String table, int id) throws SQLException{
        preparedStatement = connection.prepareStatement("select * from "+table+" where id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public ResultSet deleteRowById(String table, int id) throws SQLException{
        preparedStatement = connection.prepareStatement("delete from "+table+" where id = ?");
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public ResultSet getAllRows(String table) throws SQLException {
        table = "GenshinImpact";
        Statement statement = connection.createStatement();
        //ResultSet resultSet = statement.executeQuery("select * from " + table);
        return statement.executeQuery("select * from " + table);
        //return queryResult("select * from " + table);

    }

    public ResultSet getAllRowsOrderBy(String table, String column, String direction) throws SQLException {
        return queryResult("select * from " + table + " order by " + column + " " + direction);
    }

}
