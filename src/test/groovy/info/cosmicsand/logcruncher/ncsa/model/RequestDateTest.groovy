package info.cosmicsand.logcruncher.ncsa.model

import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test

import java.text.SimpleDateFormat

import static org.junit.Assert.assertThat
import static org.hamcrest.Matchers.*

class RequestDateTest {
    @Test
    public void GIVEN_anEmptyDateString_THEN_returnAnEmptyDate() throws Exception {
        assertThat(new RequestDate("-"), is(RequestDate.EMPTY_DATE))
    }

    @Test
    public void GIVEN_anValidDateString_THEN_returnARequestDate() throws Exception {
        def dateParser = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z")
        def sampleDate = "01/Jul/2002:12:11:52 +0000"
        assertThat(new RequestDate(sampleDate).parsedDate, is(dateParser.parse(sampleDate)))
    }

}
