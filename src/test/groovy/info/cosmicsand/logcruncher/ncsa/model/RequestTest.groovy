package info.cosmicsand.logcruncher.ncsa.model

import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

public class RequestTest {

    @Test
    public void GIVEN_theInputIsTheDefaultForAnEmptyValue_THEN_itEqualsToTheEmptyRequest() throws Exception {
        assertThat(new Request(rawRequestValue: '"-"'), is(Request.EMPTY_REQUEST))
    }

    @Test
    public void GIVEN_itIsCreatedWithTheDefaultConstructor_THEN_itEqualsToTheEmptyRequest() throws Exception {
        assertThat(new Request(), is(Request.EMPTY_REQUEST))
    }

    @Test
    public void GIVEN_theEmptyRequest_THEN_theMethodIs_UNKNOWN_METHOD() throws Exception {
        assertThat(new Request().method, is(HttpMethod.UNKNOWN_METHOD))
    }

    @Test
    public void GIVEN_a_GET_request_THEN_itKnows() throws Exception {
        def getRequest = "GET http://www.example.org/ HTTP/1.1"
        assertThat(new Request(rawRequestValue: getRequest).method, is(HttpMethod.GET))
    }

    @Test
    public void GIVEN_a_POST_request_THEN_itKnows() throws Exception {
        def postRequest = "POST http://www.example.org/ HTTP/1.1"
        assertThat(new Request(rawRequestValue: postRequest).method, is(HttpMethod.POST))
    }

    @Test
    public void GIVEN_theRequestIs_https_THEN_itKnowsItsProtocol() throws Exception {
        def httpsRequest = "POST https://www.example.org/ HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpsRequest).protocol, is(HttpProtocol.https))
    }

    @Test
    public void GIVEN_theRequestIs_http_THEN_itKnowsItsProtocol() throws Exception {
        def httpRequest = "POST http://www.example.org/ HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).protocol, is(HttpProtocol.http))
    }

    @Test
    public void GIVEN_theRequestJustContainsAPath_THEN_theProtocolDefaultsTo_http() throws Exception {
        def pathRequest = "POST /just/a/path HTTP/1.1"
        assertThat(new Request(rawRequestValue: pathRequest).protocol, is(HttpProtocol.http))
    }
}
