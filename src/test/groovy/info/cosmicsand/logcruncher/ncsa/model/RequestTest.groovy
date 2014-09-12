package info.cosmicsand.logcruncher.ncsa.model

import de.cosmicsand.webtools.path.Path
import org.junit.Ignore
import org.junit.Test

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertThat

public class RequestTest {

    @Test
    public void GIVEN_theInputIsTheDefaultForAnEmptyValue_THEN_itEqualsToTheEmptyRequest() throws Exception {
        assertThat(new Request(rawRequestValue: '-'), is(Request.EMPTY_REQUEST))
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

    @Test
    public void GIVEN_theRequestHasNoPath_THEN_itDefaultsToRoot() throws Exception {
        def httpRequest = "POST http://www.example.org HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).path, is(Path.ROOT))
    }

    @Test
    public void GIVEN_theRequestHasAPath_THEN_itKnows() throws Exception {
        def httpRequest = "POST http://www.example.org/some/path HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).path, is(new Path("/some/path")))
    }

    @Test
    public void GIVEN_thePathIsRoot_THEN_itKnows() throws Exception {
        def httpRequest = "POST http://www.example.org/ HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).path, is(Path.ROOT))
    }

    @Test
    public void GIVEN_anEmptyQuery_THEN_returnAnEmptyQuery() throws Exception {
        def httpRequest = "POST http://www.example.org HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).query, is(UriQuery.EMPTY_QUERY))
    }

    @Test
    public void GIVEN_aQuery_THEN_knowThatQuery() throws Exception {
        def httpRequest = "POST http://www.example.org/?key=value HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).query, is(new UriQuery("key=value")))
    }

    @Test
    public void GIVEN_aQueryAndNoRoot_THEN_knowThatQuery() throws Exception {
        def httpRequest = "POST http://www.example.org?key=value HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).query, is(new UriQuery("key=value")))
    }

    @Test
    public void toStringDeliversTheRawValue() throws Exception {
        def httpRequest = "POST http://www.example.org/?key=value HTTP/1.1"
        assertThat(new Request(rawRequestValue: httpRequest).toString(), is(httpRequest))
    }
}
