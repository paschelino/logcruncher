package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Referer {
    static final def EMPTY_REFERER = new Referer(rawRefererValue: '"-"')
    String rawRefererValue
}
