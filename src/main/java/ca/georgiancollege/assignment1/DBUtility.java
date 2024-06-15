package ca.georgiancollege.assignment1;

import java.sql.*;

public class DBUtility {

    private String connectionURL, username, password, database;
    private String table;

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public DBUtility(String database) {
        String connectionURL = "jdbc:mysql://database-1.cj2aqmsw2hib.us-east-2.rds.amazonaws.com:3306",
        username = "admin", password = "";
        //database = "Assignment1"
        this.database = database;

        try {
            Connection connection = DriverManager.getConnection(connectionURL + "/" + database, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into GenshinImpact(version, 5_star_character, revenue, start_date, end_date, banner_days) " +
                            "values (?, ?, ?, ?, ?, ?)");

            preparedStatement.setDouble(1, 1.0);
            preparedStatement.setString(2, "Venti");
            preparedStatement.setInt(3, 30632752);
            preparedStatement.setString(4, "25/09/2020");
            preparedStatement.setString(5, "19/10/2020");
            preparedStatement.setInt(6, 25);

            preparedStatement.execute();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from GenshinImpact");

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
        catch (Exception e){
            System.err.println(e);
        }
    }

    public DBUtility(String database, String table){
        this(database);
        setTable(table);
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
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
        return queryResult("select * from " + table);
    }

    public ResultSet getAllRowsOrderBy(String table, String column, String direction) throws SQLException {
        return queryResult("select * from " + table + " order by " + column + " " + direction);
    }

}
