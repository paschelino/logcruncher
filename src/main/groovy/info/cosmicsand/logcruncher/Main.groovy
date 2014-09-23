package info.cosmicsand.logcruncher

import au.com.bytecode.opencsv.CSVWriter
import info.cosmicsand.logcruncher.args.VisitorClassNameExtractor
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry

public class Main {

    public static void main(String[] args) {
        if(args.length != 3) {
            println "usage:\n" +
                    "logcruncher <input-ncsa-logfile> <statistics-output-file> (<visitor-class-name>[,<visitor-class-name>])"
            return
        }
        println "Please note: The command line usage of logcruncher is an early stage version. It will be subject to change in the future."
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
