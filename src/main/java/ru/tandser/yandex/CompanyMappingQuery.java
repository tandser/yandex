package ru.tandser.yandex;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.tandser.yandex.pojo.Company;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Этот класс реализует логику преобразования записей, извлекаемых
 * из базы данных, в объекты класса {@link Company}.
 *
 * @author Andrew Timokhin
 */
public class CompanyMappingQuery extends MappingSqlQuery<Company> {

    private static final String QUERY = "SELECT * FROM company";

    public CompanyMappingQuery(DataSource dataSource) {
        super(dataSource, QUERY);
    }

    @Override
    protected Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setId(rs.getInt("id"));
        company.setName(rs.getString("name"));
        company.setAddress(rs.getString("address"));
        return company;
    }
}