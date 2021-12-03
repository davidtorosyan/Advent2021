package com.dtoro.advent2021.util

import com.github.kittinunf.fuel.Fuel
import java.io.File
import java.io.FileNotFoundException

object InputFetcher {

    private const val ADVENT_URL_TEMPLATE = "https://adventofcode.com/2021/day/%s/input"
    private const val COOKIE_HEADER_KEY = "cookie"
    private const val COOKIE_LOCATION = "~/.advent2021_cookie"

    fun fetchInputForDay(day: Int) : List<String> {
        val url = ADVENT_URL_TEMPLATE.format(day)
        val (_, _, result) = Fuel.get(url)
            .set(COOKIE_HEADER_KEY, getCookie())
            .responseString()
        return result.get().lines().dropLast(1)
    }

    private fun getCookie() : String {
        return try {
            File(COOKIE_LOCATION.expandPath()).readLines().first()
        } catch (ex: FileNotFoundException) {
            error("""Missing cookie file! Create a file at $COOKIE_LOCATION with your Advent of Code session cookie.
                
        To get this, go to https://adventofcode.com/ in your browser, open developer tools, 
        click Network and copy the value of `cookie` in the request headers. 
        Then paste that value into a file at $COOKIE_LOCATION
        
        Note that you need to be logged in!"""")
        }
    }

    private fun String.expandPath() : String {
        return replaceFirst("~", System.getProperty("user.home"))
    }
}
