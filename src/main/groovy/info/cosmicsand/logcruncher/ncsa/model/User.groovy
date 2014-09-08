package info.cosmicsand.logcruncher.ncsa.model

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class User {
    static final def EMPTY_USER = new User(userName: '-')
    String userName
}
