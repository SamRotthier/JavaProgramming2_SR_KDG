package be.kdg.java2.database;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonsterDbDao implements MonsterDao {
    private static final Logger logger = Logger.getLogger(MonsterDbDao.class.getName());
    private Connection connection = null;

    public MonsterDbDao(String databasePath) {
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:file:" + databasePath, "sa", "");
            createTable();
        } catch (SQLException e) {
            System.err.println("Fatal error: cannot create connection ");
            System.exit(1);
        }
    }

    public void close() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE monstertable IF EXISTS");
            statement.execute("CREATE TABLE monstertable" +
                    "(" +
                    "id INTEGER IDENTITY," +
                    "name VARCHAR(30) NOT NULL," +
                    "totalXp DOUBLE NOT NULL," +
                    "level INT NOT NULL," +
                    "type VARCHAR(10) NOT NULL," +
                    "birthday DATE NOT NULL," +
                    "battlesWon INT NOT NULL,)");
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Cannot create table " + e.getMessage());
        }
    }

    @Override
    public boolean insert(Monster monster) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO monstertable (name, totalXp, level, type, birthday, battlesWon) " +
                            "VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, monster.getName());
            statement.setDouble(2, monster.getTotalXp());
            statement.setInt(3, monster.getLevel());
            statement.setString(4, monster.getType().name());
            statement.setDate(5, Date.valueOf(monster.getBirthday()));
            statement.setInt(6, monster.getBattlesWon());
            int count = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) monster.setId(resultSet.getInt(1));
            resultSet.close();
            statement.close();
            if (count == 1) return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, String.format("Error while trying insert %s - ", monster.getName()) + e.getMessage());
        }
        return false;
    }

    @Override
    public Monster retrieve(String name) {
        Monster monster = null;
        try {

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM monstertable WHERE name = ?"
            );
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                monster = new Monster(
                        resultSet.getString("name"),
                        resultSet.getDouble("totalXp"),
                        resultSet.getInt("level"),
                        MonsterType.valueOf(resultSet.getString("type")),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getInt("battlesWon"),
                        resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, String.format("could not retrieve %s - ", name) + e.getMessage());
        }
        return monster;
    }

    @Override
    public boolean update(Monster monster) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE monstertable SET name = ?, totalXp = ?, level = ?, type = ?, birthday = ?, battlesWon = ? WHERE id = ?"
            );
            statement.setString(1, monster.getName());
            statement.setDouble(2, monster.getTotalXp());
            statement.setInt(3, monster.getLevel());
            statement.setString(4, monster.getType().name());
            statement.setDate(5, Date.valueOf(monster.getBirthday()));
            statement.setInt(6, monster.getBattlesWon());
            statement.setInt(7, monster.getId());
            int count = statement.executeUpdate();
            statement.close();
            if (count == 1) return true;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, String.format("could not update %s - ", monster.getName()) + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(String name) {
        try {
            PreparedStatement statement;
            if (name.equals("*")) statement = connection.prepareStatement("DELETE FROM monstertable");
            else {
                statement = connection.prepareStatement("DELETE FROM monstertable WHERE name = ?");
                statement.setString(1, name);
            }
            int count = statement.executeUpdate();
            statement.close();
            if (count == 1) return true;
        } catch (SQLException | IllegalArgumentException e) {
            logger.log(Level.SEVERE, String.format("could not delete %s - ", name) + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Monster> sortedOn(String query) {
        List<Monster> monsters = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Monster monster = new Monster(
                        resultSet.getString("name"),
                        resultSet.getDouble("totalXp"),
                        resultSet.getInt("level"),
                        MonsterType.valueOf(resultSet.getString("type")),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getInt("battlesWon"),
                        resultSet.getInt("id"));
                monsters.add(monster);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error while sorting - " + e.getMessage());
        }
        return monsters;
    }

    public List<Monster> sortedOnName() {
        String sql = "SELECT * FROM monstertable ORDER BY name";
        return sortedOn(sql);
    }

    public List<Monster> sortedOnTotalXp() {
        String sql = "SELECT * FROM monstertable ORDER BY totalXp";
        return sortedOn(sql);
    }

    public List<Monster> sortedOnLevel() {
        String sql = "SELECT * FROM monstertable ORDER BY level";
        return sortedOn(sql);
    }

    public List<Monster> sortedOnType() {
        String sql = "SELECT * FROM monstertable ORDER BY type";
        return sortedOn(sql);
    }

    public List<Monster> sortedOnBirthday() {
        String sql = "SELECT * FROM monstertable ORDER BY birthday";
        return sortedOn(sql);
    }

    public List<Monster> sortedOnBattlesWon() {
        String sql = "SELECT * FROM monstertable ORDER BY battlesWon";
        return sortedOn(sql);
    }
}
