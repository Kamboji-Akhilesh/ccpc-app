package com.example.ccpc

class User {
    var clgname: String? = null
    var fullname: String? = null
    var phnno: String? = null
    var age: String? = null
    var uid: String? = null

    constructor(){}

    constructor(clgname: String?,fullname: String?,phnno: String?,age: String?,uid: String?){
        this.clgname = clgname
        this.fullname = fullname
        this.phnno = phnno
        this.age = age
        this.uid = uid
    }
}