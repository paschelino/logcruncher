package info.cosmicsand.logcruncher

import au.com.bytecode.opencsv.CSVWriter
import info.cosmicsand.logcruncher.args.VisitorClassNameExtractor
import info.cosmicsand.logcruncher.contracts.LogStatistics
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry
import info.cosmicsand.logcruncher.ncsa.visitors.NCSARequestTotalsVisitor

public class Main {

    public static void main(String[] args) {
        def input = args[0]
        def output = args[1]
        def visitorClassNames = new VisitorClassNameExtractor(args[2]).classNames
        def visitors = []
        visitorClassNames.each {
            visitors.add(Class.forName(it).newInstance())
        }

        // TODO: use info.cosmicsand.logcruncher.contracts.LogIterator interface instead
        new File(input).eachLine { inputLine ->
            def logentry = new NCSAExtendedLogentry(inputLine)
            visitors.each { visitor ->
                visitor.visit(logentry)
            }
        }

        visitors.each { visitor ->
            writeResults(output, visitor)
        }
    }

    private static void writeResults(fileName, logStatistics) {
        def writer = new CSVWriter(new FileWriter(fileName))
        writer.writeNext(logStatistics.getColumnNames())
        writer.writeAll(logStatistics.getValueLines())
        writer.close()
    }
}
