package com.miu.a3walmart

import java.io.Serializable

class User constructor(val _firstName: String, val _lastName: String, val _username: String, val _password: String) : Serializable {
    var firstName: String = _firstName
    var lastName: String = _lastName
    var userName: String = _username
    var password: String = _password

}