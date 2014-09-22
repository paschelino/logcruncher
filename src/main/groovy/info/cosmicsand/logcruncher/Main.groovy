package info.cosmicsand.logcruncher

import au.com.bytecode.opencsv.CSVWriter
import groovy.io.GroovyPrintWriter
import info.cosmicsand.logcruncher.ncsa.NCSAExtendedLogentry
import info.cosmicsand.logcruncher.ncsa.model.RequestType
import info.cosmicsand.logcruncher.ncsa.visitors.NCSARequestTotalsVisitor
public class Main {

    public static void main(String[] args) {
        def input = args[0]
        def output = args[1]
        def visitor = new NCSARequestTotalsVisitor()
        new File(input).eachLine {
            visitor.visit(new NCSAExtendedLogentry(it))
        }

        def writer = new CSVWriter(new FileWriter(output))

//        def writer = new GroovyPrintWriter(new File(output))
        String[] nextLine = [RequestType.class.getName(), Long.class.getName()]
        writer.writeNext(nextLine)
//        writer.println(visitor.requestCounts.keySet().join(','))
        visitor.requestCounts.each { requestType, count ->
            nextLine = [requestType.toString(),count.toString()]
            writer.writeNext(nextLine)
//            writer.println("$requestType,$count")
        }
        writer.close()
    }
}
