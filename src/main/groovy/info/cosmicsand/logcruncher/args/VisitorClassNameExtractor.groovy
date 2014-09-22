package info.cosmicsand.logcruncher.args

class VisitorClassNameExtractor {
    ArrayList<String> classNames

    def VisitorClassNameExtractor(String argument) {
        def classNamesString = argument.substring(1, argument.length() - 1)
        classNames = classNamesString ? classNamesString.split(/,/) : []
    }
}
