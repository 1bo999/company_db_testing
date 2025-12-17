package tests.titles;

import dao.TitleDao;
import model.Title;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.time.LocalDate;
import java.util.List;

public class TC_37 extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_37.class);
    private TitleDao titleDao;

    @BeforeMethod
    public void setupDao() {
        log.info("Setting up DAO");
        titleDao = new TitleDao(connection);
    }
    @Test
    public void testEmployeeTitleHistory() {
        String dateSRT = "9999-01-01";
        LocalDate date = LocalDate.parse(dateSRT);

        log.info("Running test");

        List<Title> result = titleDao.latestTitlePerEmp(date);

        Assert.assertFalse(result.isEmpty(), "Result is empty or null");
        Assert.assertFalse(result.getFirst().getTitle().isEmpty(),
                "First employee title is empty");

        log.info("TC_37 finished successfully");
    }
}
