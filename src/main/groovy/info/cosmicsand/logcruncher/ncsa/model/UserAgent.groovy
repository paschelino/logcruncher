package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class UserAgent {
    static final def EMPTY_USER_AGENT = new UserAgent(rawUserAgentValue: '"-"')
    String rawUserAgentValue
}
