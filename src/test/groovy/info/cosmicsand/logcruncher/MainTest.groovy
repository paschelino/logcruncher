package info.cosmicsand.logcruncher

import info.cosmicsand.logcruncher.ncsa.visitors.NCSARequestTotalsVisitor
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


import static org.junit.Assert.assertThat
import static org.hamcrest.Matchers.*
import static org.junit.Assert.fail

class MainTest {
    static def userDir = System.getProperty("user.dir")
    static def sampleDataDir = "/src/test/resources/info/cosmicsand/logcruncher/"
    static def sampleVarnishLog = "$userDir$sampleDataDir/sample_varnishncsa.log"
    static def sampleOutput = "$userDir$sampleDataDir/sample_request_totals.csv"

    @Before
    public void setUp() {
        def output = new File(sampleOutput)
        if (output.exists()) output.delete()
        if (output.exists()) fail("sample output csv file still exists")
    }

    @Test
    public void readsSampleNCSALog_integrationTest() throws Exception {
        String[] args = new String[3]
        args[0] = sampleVarnishLog
        args[1] = sampleOutput
        args[2] = "[${NCSARequestTotalsVisitor.toString()}]"
        Main.main(args)
        assertThat(new File(sampleOutput).exists(), is(true))
    }
}
