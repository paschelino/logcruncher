package info.cosmicsand.logcruncher.args

import info.cosmicsand.logcruncher.ncsa.visitors.NCSARequestTotalsVisitor
import org.junit.Assert
import org.junit.Test

import static org.junit.Assert.assertThat
import static org.hamcrest.Matchers.*

class VisitorClassNameExtractorTest {
    @Test
    public void GIVEN_anEmptyArgument_THEN_returnAnEmptyList() throws Exception {
        def arg = "[]"
        assertThat(new VisitorClassNameExtractor(arg).classNames, is([]))
    }

    @Test
    public void GIVEN_oneClassName_THEN_returnIt() throws Exception {
        def expectedClassName = NCSARequestTotalsVisitor.class.getName()
        def extractor = new VisitorClassNameExtractor("[${expectedClassName}]")
        assertThat(extractor.classNames, is([expectedClassName]))
    }

    @Test
    public void GIVEN_severalClassNames_THEN_returnThose() throws Exception {
        def expectedClassName1 = NCSARequestTotalsVisitor.class.getName()
        def expectedClassName2 = NCSARequestTotalsVisitor.class.getName()
        def extractor = new VisitorClassNameExtractor("[${expectedClassName1},${expectedClassName2}]")
        assertThat(extractor.classNames, is([expectedClassName1,expectedClassName2]))
    }

}
