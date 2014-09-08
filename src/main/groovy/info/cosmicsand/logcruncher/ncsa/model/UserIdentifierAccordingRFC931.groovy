package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class UserIdentifierAccordingRFC931 {
    static final def EMPTY_USER_ID = new UserIdentifierAccordingRFC931(rawUserIdentifier: '-')
    String rawUserIdentifier
}
