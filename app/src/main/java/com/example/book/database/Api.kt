package com.example.book.database

object Api {


    private val ROOT_URL = "http://192.168.0.164/BookstoreApi/api/Api.php?apicall="
    val URL_GET_USERS = ROOT_URL + "getUsers"
    val URL_GET_BOOKS = ROOT_URL + "getBooks"
    val URL_GET_NEWS = ROOT_URL + "getNews"

    val URL_GET_USER_QUOTES = ROOT_URL + "getUserQuotes&id=3"
    val URL_GET_BOOK_QUOTES = ROOT_URL + "getBookQuotes&id=3"

}